package week10.client;

import java.io.*;
import java.net.*;
import java.rmi.RemoteException;

import week10.common.FileTransfer;
import week10.common.FileTransferFactory;

public class FileTransferClientUI {

  private static String DIR = "dir";
  private static String QUIT = "quit";
  private static String CD = "cd";
  private static String GETDIR = "getdir";
  private static String GET = "get";

  private BufferedReader console;
  private FileTransfer clientHOPP;

  public static void main(String[] args) {

    if (args.length < 1) {
      System.err.println("Usage: Client args");
      System.exit(1);
    }

    FileTransfer clientHOPP = null;
    try {
      clientHOPP = FileTransferFactory.newClient(args);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    if (clientHOPP == null) {
      System.out.println("Unknown client type");
      System.exit(2);
    }

    FileTransferClientUI ui = new FileTransferClientUI(clientHOPP);
    ui.loop();
  }

  public FileTransferClientUI(FileTransfer clientHOPP) {

    this.clientHOPP = clientHOPP;
    console = new BufferedReader(new InputStreamReader(System.in));
  }

  public void loop() {
    while (true) {
      String line = null;
      try {
        System.out.print("Enter request: ");
        line = console.readLine();
        if (line == null) {
          break;
        }
        System.out.println("Request was " + line);
      } catch (IOException e) {
        e.printStackTrace();
        quit();
      }

      if (line.equals(DIR)) {
        dir();
      } else if (line.startsWith(CD)) {
        chdir(losePrefix(line, CD));
      } else if (line.startsWith(GETDIR)) {
        getdir();
      } else if (line.startsWith(GET)) {
        get(losePrefix(line, GET));
      } else if (line.equals(QUIT)) {
        quit();
      } else {
        System.out.println("Unrecognised command");
      }
    }
  }

  /**
   * Given that the string starts with the prefix, get rid of the prefix and any
   * whitespace
   */
  public String losePrefix(String str, String prefix) {
    int index = prefix.length();
    String ret = str.substring(index).trim();
    return ret;
  }

  protected void dir() {
    String[] dirList = null;
    try {
      dirList = clientHOPP.dir();
    } catch (RemoteException e) {
      System.out.println("Error in remote call " + e.toString());
    }
    if (dirList == null) {
      System.out.println("No dir list available");
    } else {
      for (int n = 0; n < dirList.length; n++) {
        System.out.println(dirList[n]);
      }
    }
  }

  public void chdir(String dir) {
    try {
      if (clientHOPP.chdir(dir)) {
        System.out.println("Chdir okay");
      } else {
        System.out.println("Chdir failed");
      }
    } catch (RemoteException e) {
      System.out.println("Error in remote call " + e.toString());
    }
  }

  public void getdir() {
    try {
      String dir = clientHOPP.getdir();
      System.out.println("Current dir: " + dir);
    } catch (RemoteException e) {
      System.out.println("Error in remote call " + e.toString());
    }
  }

  public void get(String filename) {
    // omitted
  }

  private void quit() {
    try {
      clientHOPP.quit();
    } catch (RemoteException e) {
      // nothing
    }
    System.exit(0);
  }
} // FileTransferClientUI
