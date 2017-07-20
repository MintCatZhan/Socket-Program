package week10.rmi;

/**
 * FileTransferServer.java
 *
 *
 * Created: Thu Sep 22 10:52:48 2005
 *
 * @author <a href="mailto:jan.newmarch@infotech.monash.edu.au">Jan Newmarch</a>
 * @version 1.0
 */

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import week10.common.FileTransfer;
import week10.server.FileTransferServerHOPP;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteStub;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RMISecurityManager;

public class FileTransferServer {

  public static void main(String[] args) {
    try {
      System.setSecurityManager(new RMISecurityManager());
      FileTransferServerHOPP obj = new FileTransferServerHOPP();
      FileTransfer stub = (FileTransfer) UnicastRemoteObject.exportObject(obj,
          0);

      // Bind the remote object's stub in the registry
      Registry registry = LocateRegistry.getRegistry();
      registry.bind("FileTransfer", stub);
      System.out.println("Running");
      // make it public - advertise it
    } catch (RemoteException e) {
      e.printStackTrace();
      System.exit(1);
    } catch (AlreadyBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // main can now finish. An RMI thread keeps the server alive
  }
} // FileTransferServer
