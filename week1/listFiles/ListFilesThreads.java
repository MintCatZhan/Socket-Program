package week1.listFiles;
import java.io.*;

public class ListFilesThreads extends Thread {

    private static Object synch;
    private static ThreadGroup group;

    private File dir;

    public static void main(String[] args) {
	ListFilesThreads lister = new ListFilesThreads(new File(args[0]));

	lister.start();
    }

    public ListFilesThreads(File dir) {
	this.dir = dir;
    }

    public void run() {
	listDirectory(dir);
    }

    public void listDirectory(File dir) {
	System.out.println(dir.getAbsolutePath());
	File[] files = dir.listFiles();
	if (files == null) {
	    return;
	}
	for (int n = 0; n < files.length; n++) {
	    File file = files[n];
	    if (! file.isDirectory()) {
		System.out.println(file.getAbsolutePath());
	    } else {
	        System.out.println("Directory found " + file.getAbsolutePath() + " - new Thread starting!");
		new ListFilesThreads(file).start();
		
	    }
	}
    }
}