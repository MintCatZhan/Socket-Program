package week10.socket;

import java.io.*;
import java.net.*;

import week10.server.FileTransferServerHOPP;

public class FileTransferServer {

  public static void main(String argv[]) {
    ServerSocket s = null;
    try {
      s = new ServerSocket(FileTransferConstants.PORT);
    } catch (IOException e) {
      System.out.println(e);
      System.exit(1);
    }

    while (true) {
      Socket incoming = null;
      try {
        incoming = s.accept();
      } catch (IOException e) {
        System.out.println(e);
        continue;
      }

      new SocketHandler(incoming).start();
    }
  }
}

class SocketHandler extends Thread {

  Socket incoming;
  FileTransferServerHOPP fileServer = new FileTransferServerHOPP();

  BufferedReader reader;
  PrintStream out;

  SocketHandler(Socket incoming) {
    this.incoming = incoming;
  }

  public void run() {
    try {
      reader = new BufferedReader(new InputStreamReader(
          incoming.getInputStream()));
      out = new PrintStream(incoming.getOutputStream());

      while (true) {
        String line = reader.readLine();
        if (line == null) {
          break;
        }
        System.out.println("Received request: " + line);

        if (line.startsWith(FileTransferConstants.CD)) {
          changeDirRequest(losePrefix(line, FileTransferConstants.CD));
        } else if (line.startsWith(FileTransferConstants.DIR)) {
          directoryRequest();
        } else if (line.startsWith(FileTransferConstants.GETDIR)) {
          getdirRequest();
        } else if (line.startsWith(FileTransferConstants.GET)) {
          // code omitted
        } else if (line.startsWith(FileTransferConstants.QUIT)) {
          break;
        } else {
          out.print(FileTransferConstants.ERROR + FileTransferConstants.CR_LF);
        }

      }
      incoming.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Given that the string starts with the prefix, get rid of the prefix and any
   * following whitespace
   */
  public String losePrefix(String str, String prefix) {
    int index = prefix.length();
    String ret = str.substring(index).trim();
    return ret;

  }

  public void changeDirRequest(String dir) {
    if (fileServer.chdir(dir)) {
      out.print(FileTransferConstants.SUCCEEDED + " " + fileServer.getdir()
          + FileTransferConstants.CR_LF);
    } else {
      out.print(FileTransferConstants.ERROR + FileTransferConstants.CR_LF);
    }
  }

  public void getdirRequest() {
    out.print(fileServer.getdir() + FileTransferConstants.CR_LF);
  }

  public void directoryRequest() {
    String[] fileNames = fileServer.dir();
    if (fileNames == null) {
      out.print(FileTransferConstants.ERROR + FileTransferConstants.CR_LF);
    }
    for (int n = 0; n < fileNames.length; n++) {
      out.print(fileNames[n] + FileTransferConstants.CR_LF);
    }
    out.print(FileTransferConstants.CR_LF);
  }
}
