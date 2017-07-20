package week10.corba;
/**
 * FileTransferClientHOPP.java
 *
 *
 * Created: Wed Sep 21 12:19:55 2005
 *
 * @author <a href="mailto:jan.newmarch@infotech.monash.edu.au">Jan Newmarch</a>
 * @version 1.0
 */

// import common.FileTransfer;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.rmi.RemoteException;
import java.io.IOException;
import org.omg.CORBA.SystemException;

public class FileTransferClientHOPP implements week10.common.FileTransfer {

    private week10.corba.FileTransfer impl;

    public FileTransferClientHOPP(String[] args) {
	try{
	    // create and initialize the ORB
	    ORB orb = ORB.init(args, null);
	    
	    // get the root naming context
	    org.omg.CORBA.Object objRef = 
		orb.resolve_initial_references("NameService");
	    // Use NamingContextExt instead of NamingContext. This is 
	    // part of the Interoperable naming Service.  
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    
	    // resolve the Object Reference in Naming
	    String name = "FileTransfer";
	    impl = FileTransferHelper.narrow(ncRef.resolve_str(name));
	    
	    System.out.println("Obtained a handle on server object: " + impl);
	    
	} catch (Exception e) {
	    System.out.println("ERROR : " + e) ;
	    e.printStackTrace(System.out);
	}
    } // FileTransferClientHOPP constructor
    
    public boolean chdir(String dir) throws RemoteException{
	try {
	    return impl.chdir(dir);	     
	} catch (SystemException e) {
	    throw new RemoteException("CORBA exception", e);
	}	
    }

    public String[] dir() throws RemoteException {
	try {
	    return impl.dir();
	} catch (SystemException e) {
	    throw new RemoteException("CORBA exception", e);
	}	
    }

    public String getdir() throws RemoteException {
	try {
	    return impl.getdir();
	} catch (SystemException e) {
	    throw new RemoteException("CORBA exception", e);
	}	
    }

    public String get(String filename) throws RemoteException, IOException {
	try {
	    return impl.get(filename);
	} catch (SystemException e) {
	    throw new RemoteException("CORBA exception", e);
	}	
    }

    public void quit() throws RemoteException {
	try {
	    impl.quit();
	} catch (SystemException e) {
	    throw new RemoteException("CORBA exception", e);
	}	
    }

} // FileTransferClientHOPP
