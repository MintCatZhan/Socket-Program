package week10.rmi;

/**
 * FileTransferClientHOPP.java
 *
 *
 * Created: Thu Sep 22 10:58:07 2005
 *
 * @author <a href="mailto:jan.newmarch@infotech.monash.edu.au">Jan Newmarch</a>
 * @version 1.0
 */

import week10.common.FileTransfer;
import java.rmi.RemoteException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileTransferClientHOPP implements FileTransfer {

  private FileTransfer proxy;

  public FileTransferClientHOPP(String server) throws MalformedURLException,
      NotBoundException, RemoteException {

    // find the object
    System.setSecurityManager(new java.rmi.RMISecurityManager());
    Registry registry = LocateRegistry.getRegistry();
    proxy = (FileTransfer) registry.lookup("FileTransfer");
  } // FileTransferClientHOPP constructor

  public boolean chdir(String dir) throws RemoteException {
    return proxy.chdir(dir);
  }

  public String[] dir() throws RemoteException {
    return proxy.dir();
  }

  public String getdir() throws RemoteException {
    return proxy.getdir();
  }

  public String get(String filename) throws RemoteException, IOException {
    return proxy.get(filename);
  }

  public void quit() throws RemoteException {
    proxy.quit();
  }
} // FileTransferClientHOPP
