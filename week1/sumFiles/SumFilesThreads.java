package sumFiles;

import java.io.*;

public class SumFilesThreads extends Thread {

    private static long sum = 0;
    private static long threadCount = 1;
    private static Object synch;

    private File dir;

    public static void main(String[] args) {
	SumFilesThreads lister = new SumFilesThreads(new File(args[0]));

	// synchronize on the first object created
	synch = lister;
	lister.start();
	synchronized(synch) {
	    while (true) {
		try {
		    // every time a thread dies, it should
		    // notify all others, so we will be woken
		    // up periodically
		    synch.wait();
		} catch(InterruptedException e) {
		    System.out.println("Interrupted " + e);
		}
		if (threadCount == 0) {
		    System.out.println("Sum " + sum);
		    System.exit(0);
		}
	    }
	}
    }

    public SumFilesThreads(File dir) {
	this.dir = dir;
    }

    public void run() {
	listDirectory(dir);
    }

    public void listDirectory(File dir) {
	if (! dir.isDirectory()) return;
	
	// System.out.println(dir.getAbsolutePath());
	File[] files = dir.listFiles();
	for (int n = 0; n < files.length; n++) {
	    File file = files[n];
	    if (! file.isDirectory()) {
		// make access to sum atomic
		synchronized(synch) {
		    sum += file.length();
		}
	    } else {
		synchronized(synch) {
		    // make access to threadCount atomic
		    threadCount++;
		}
		new SumFilesThreads(file).start();
	    }
	}

	synchronized(synch) {
	    // this thread is finished, wake up a 
	    // thread waiting on the synch object
	    threadCount--;
	    synch.notifyAll();
	}
    }
}