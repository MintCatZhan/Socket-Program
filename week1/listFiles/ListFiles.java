package week1.listFiles;


import java.io.*;

public class ListFiles {

    public static void main(String[] args) {
	  ListFiles lister = new ListFiles(new File(args[0]));
    }

    public ListFiles(File dir) {
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
		    	listDirectory(file);
		    }
		}
    }
}
