package week10.webservice;

import java.io.File;
import java.io.IOException;

public class FileTransferServerHOPP {
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
    return fileNames;
  }

  public String getdir() {
    try {
      return clientDir.getCanonicalPath();
    } catch (IOException e) {
      return "";
    }
  }

  public void quit() {
    // do nothing
  }
}
