// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI2/magercises/BootstrapServer/working/RMIServer.java#3 $
import java.net.*;
import java.io.*;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

/**
 * RMIServer acts as a server for the remote "Hello" service.
 *
 * RMIServer starts execution at the standard entry point "public static void main";
 * It creates an instance of itself and continues processing in the constructor.
 *
 */

public class RMIServer
    {
    private static final int    PORT        = 10009;

    //
    // -> Change the name to your own computer name
    //
    private static final String HOST_NAME   = "localhost";


    // Instance of ourselves
    private static RMIServer  rmi;

    public static void main ( String[] args )
	{
	// We need to set the security manager to the RMISecurityManager
	System.setSecurityManager( new RMIServerSecurityManager() );

	try
	    {
	    rmi = new RMIServer();
	    }
	catch ( java.rmi.UnknownHostException uhe )
	    {
	    System.out.println
		(
		 "The host computer name you have specified, " + 
		 HOST_NAME + 
		 " does not match your real computer name." 
		 );

	    }
	catch ( RemoteException re )
	    {
	    System.out.println( "Error starting service" );
	    System.out.println( "" + re );
	    }
	catch ( MalformedURLException mURLe )
	    {
	    System.out.println( "Internal error" + mURLe );
	    }
	catch ( NotBoundException nbe )
	    {
	    System.out.println( "Not Bound" );
	    System.out.println( "" + nbe );
	    }

	}  // main

    // Constructor
    public RMIServer() 
	throws RemoteException, 
	MalformedURLException, 
	NotBoundException
	{

	LocateRegistry.createRegistry( PORT );

	System.out.println
	    ( 
	     "Registry created on host computer " + 
	     HOST_NAME + 
	     " on port " + 
	     Integer.toString( PORT) 
	     );

	Hello hello  = new HelloImpl();

	System.out.println( "Remote Hello implementation object created" );

	String urlString = "//" + 
	    HOST_NAME + 
	    ":" + 
	    Integer.toString( PORT ) + 
	    "/" + 
	    "Hello";

	Naming.rebind( urlString, hello );

	System.out.println( "Bindings Finished, waiting for client requests." );
	}

    }  // class RMIServer


/* 
This is a new class for the exercise (1999/07/26) that will try to get
this to work with JDK 1.2
*/



/**
 * This class defines a security policy for RMI applications
 * that are bootstrap loaded from a server. The relaxation in
 * security provided by this class is the minimal amount that
 * is required to bootstrap load and run a RMI client application.
 *
 * The policy changes from RMISecurityManager are:
 *
 * Security Check                    This Policy  RMISecurityManager
 * ------------------------------   ------------  ------------------
 * Access to Thread Groups               YES              NO
 * Access to Threads                     YES              NO
 * Create Class Loader                   YES              NO
 * System Properties Access              YES              NO
 * Connections                           YES              NO
 *
 */

class RMIServerSecurityManager
    extends RMISecurityManager
    {

    /**
     * Loaded classes are allowed to create class loaders.
     */
    public synchronized void checkCreateClassLoader()
	{
	// Provide null override
	System.out.println( "checkCreateClassLoader()");
	}
    

    /**
     * Connections to other machines are allowed
     */
    public synchronized void checkConnect( String host, int port )
	{
	// Provide null override
	System.out.println( "checkConnect()");
	}

    /**
     * Loaded classes are allowed to manipulate threads.
     */
    public synchronized void checkAccess(Thread t)
	{
	// Provide null override
	System.out.println( "checkAccess()");
	}

    /**
     * Loaded classes are allowed to manipulate thread groups.
     */
    public synchronized void checkAccess(ThreadGroup g)
	{
	// Provide null override
	System.out.println( "checkAccess()");
	}


    /**
     * Loaded classes are allowed to access the system properties list.
     */
    public synchronized void checkPropertiesAccess()
	{
	// Provide null override
	System.out.println( "checkPropertiesAccess()");
	}

    }




