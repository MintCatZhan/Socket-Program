package week10.socket;

/**
 * FileTransferClientHOPP.java
 *
 *
 * Created: Fri Jul 20 12:54:51 2001
 *
 * @author <a href="mailto: "Jan Newmarch</a>
 * @version
 */
import java.io.*;
import java.net.*;

import java.rmi.RemoteException;

import week10.common.FileTransfer;

public class FileTransferClientHOPP implements FileTransfer {

  protected Socket sock;
  protected BufferedReader reader;
  protected PrintStream writer;

  public FileTransferClientHOPP(String server) throws UnknownHostException,
      IOException {

    InetAddress address = InetAddress.getByName(server);

    sock = null;
    InputStream in = null;
    OutputStream out = null;

    sock = new Socket(address, FileTransferConstants.PORT);
    in = sock.getInputStream();
    out = sock.getOutputStream();

    reader = new BufferedReader(new InputStreamReader(in));
    writer = new PrintStream(out);
  }

  public void quit() throws RemoteException {
    try {
      writer.print(FileTransferConstants.QUIT + FileTransferConstants.CR_LF);
      reader.close();
      writer.close();
      sock.close();
    } catch (Exception e) {
      throw new RemoteException("Quit failed", e);
    }
  }

  public String[] dir() {
    // stub
    return null;
  }

  public boolean chdir(String dir) throws RemoteException {
    writer.print(FileTransferConstants.CD + " " + dir
        + FileTransferConstants.CR_LF);

    String response = null;
    try {
      response = reader.readLine();
    } catch (IOException e) {
      throw new RemoteException("Chdir failed", e);
    }
    if (response.startsWith(FileTransferConstants.SUCCEEDED)) {
      return true;
    } else {
      return false;
    }
  }

  public String getdir() throws RemoteException {
    writer.print(FileTransferConstants.GETDIR + FileTransferConstants.CR_LF);
    String response = null;
    try {
      response = reader.readLine();
    } catch (IOException e) {
      throw new RemoteException("Chdir failed", e);
    }
    return response;
  }

  public String get(String filename) throws RemoteException {
    // stub
    return "";
  }
} // FileTransferClientHOPP
