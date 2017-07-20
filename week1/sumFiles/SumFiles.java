package sumFiles;

import java.io.*;

public class SumFiles {

    private long sum = 0;

    public static void main(String[] args) {
	SumFiles lister = new SumFiles(new File(args[0]));
    }

    public SumFiles(File dir) {
	sumDirectory(dir);
	System.out.println("Sum is " + sum);
    }

    public void sumDirectory(File dir) {
		File[] files = dir.listFiles();
	
		if (files == null) {
		    return;
		}
	
		for (int n = 0; n < files.length; n++) {
		    File file = files[n];
	
		    if (! file.isDirectory()) {
				//System.out.println(file.length() + " " + file.toString());
				System.out.println(file.length() + " " + sum);
				sum += file.length();
		    } else {
		    	sumDirectory(file);
		    }
		}
    }
}
