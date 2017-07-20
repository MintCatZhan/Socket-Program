package week10.server;
import java.io.File;
import java.io.IOException;

import week10.common.FileTransfer;

public class FileTransferServerHOPP implements FileTransfer {
    File clientDir = new File(".");
    
    public boolean chdir(String dir) {
	File newDir = new File(clientDir, dir);
	if (newDir.isDirectory()) {
	    clientDir = newDir;
	    return true;
	} else {
	    return false;
	}
    }

    public String[] dir() {
	String[] fileNames = clientDir.list();
	// list() doesn't show current and parent dirs, so add them
	String[] allFileNames = new String[fileNames.length + 2];
	allFileNames[0] = ".";
	allFileNames[1] = "..";
	for (int n = 0; n < fileNames.length; n++) {
	    allFileNames[n+2] = fileNames[n];
	}
	
	return allFileNames;
    }

    public String getdir() {
	try {
	    return clientDir.getCanonicalPath();
	} catch(IOException e) {
	    return "";
	}
    }

    public String get(String filename) {
	// stub
	return "";
    }

    public void quit() {
    }
}
