 // Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI2/magercises/BootstrapClient/working/RMIClientLoader.java#3 $
import java.net.*;
import java.io.*;
import java.util.Properties;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

/**
 * RMIClientLoader is used to "Bootstrap" an RMI Client system.
 * The client class and all of its supporting classes are loaded
 * across the RMI link (via an http server)
 *
 */

public class RMIClientLoader {
  private static final int    PORT        = 10009;
  private static final String HOST_NAME   = "localhost";

  // Reference to ourselves
  private static RMIClientLoader rcl;

  // Class for the client to be bootstrapped
  private Class    clientClass;
  private Runnable client;

  private URL        url;
  private Properties p;

  // Command Variables
  private String clientName;

  // no-argument Constructor
  public RMIClientLoader() throws   
      MalformedURLException,
      ClassNotFoundException,
      InstantiationException,
      IllegalAccessException {

    p = System.getProperties();

    url = new URL(p.getProperty("java.rmi.server.codebase"));

    System.out.println("" + url);

    // Put this information into a property so that the downloaded 
    // client can retrieve it
    p.put( 
        "java.rmi.server.rminode", 
        "rmi://" + 
          HOST_NAME + 
          ":" + 
          Integer.toString(PORT) + 
          "/");

    // Use the RMIClassLoader to fetch the class of the client 
    // program "clientName" from the URL specified in the 
    // variable "url" into the variable "clientClass".

    clientName = "RMIClient";

    System.out.println("Asking for: " + url + " and " + clientName);

    clientClass = RMIClassLoader.loadClass(url, clientName);

    System.out.println("After loading Client Class");

    // Create a new instance of the client class and place it into the
    // variable "client"
    client = (Runnable)clientClass.newInstance();

    // Start the client program by executing its "run" method.
    client.run();
  }

  public static void main (String args[]) {
    System.setSecurityManager(  
      new RMIClientBootstrapSecurityManager());
    try {
      rcl = new RMIClientLoader();
    } catch (MalformedURLException mURLe) {
      System.out.println( 
        "URL not specified correctly for the Client class: " + mURLe);
    } catch (ClassNotFoundException cnfe) {
      System.out.println("RMIClientLoader, class not found: " + cnfe);
    } catch (InstantiationException ie) {
      System.out.println( 
        "RMIClientLoader, class could not be instantiated" + ie);
    } catch (IllegalAccessException iae) {
      System.out.println("Internal error" + iae);
    }
  }  // main
}  // class RMIClientLoader
