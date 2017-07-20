package week10.corba;

/**
 * FileTransferServer.java
 *
 *
 * Created: Wed Sep 21 11:22:44 2005
 *
 * @author <a href="mailto:jan.newmarch@infotech.monash.edu.au">Jan Newmarch</a>
 * @version 1.0
 */

import java.io.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

public class FileTransferServer {

  static public void main(String[] args) {
    try {
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // create servant and register it with the ORB
      FileTransferImpl impl = new FileTransferImpl();
      // impl.setORB(orb);

      // get object reference from the servant
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
      FileTransfer href = FileTransferHelper.narrow(ref);

      // get the root naming context
      // NameService invokes the name service

      org.omg.CORBA.Object objRef = orb
          .resolve_initial_references("NameService");

      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "FileTransfer";
      NameComponent path[] = ncRef.to_name(name);
      ncRef.rebind(path, href);

      System.out.println("FileTransferServer ready and waiting ...");

      // wait for invocations from clients
      orb.run();
    } catch (org.omg.CORBA.SystemException e) {
      System.err.println("CORBA ERROR: " + e);
      e.printStackTrace(System.out);
    }

    catch (org.omg.CORBA.UserException e) {
      System.err.println("CORBA User ERROR: " + e);
      e.printStackTrace(System.out);
    }

    catch (Exception e) {
      System.err.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }

    System.out.println("FileTransferServer Exiting ...");
  }
} // FileTransferServer
