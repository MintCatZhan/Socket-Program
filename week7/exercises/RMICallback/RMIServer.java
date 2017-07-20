// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/RMICallback/RMIServer.java#2 $
import java.net.*;
import java.io.*;
import java.util.Date;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

/**
 * RMIServer acts as a server for the remote "TimeServer" service.
 *
 * RMIServer starts execution at the standard entry point "public static void main";
 * It creates an instance of itself and continues processing in the constructor.
 *
 */

public class RMIServer implements Remote, TimeServer
{
   private static final int    PORT        = 10005;

//
// -> Change the name to your own computer name
//
   private static final String HOST_NAME   = "ROSA";


   // Instance of ourselves
   private static RMIServer  rmi;

   public static void main ( String[] args )
   {
      // We need to set the security manager to the RMISecurityManager
      System.setSecurityManager( new RMISecurityManager() );

      try
      {
         rmi = new RMIServer();

         LocateRegistry.createRegistry( PORT );

         System.out.println( "Registry created" );

         UnicastRemoteObject.exportObject( ((TimeServer)rmi) );

         Naming.rebind( "//" + HOST_NAME + ":" + Integer.toString( PORT ) + "/" + "TimeServer", rmi );

         System.out.println( "Bindings Finished" );

         System.out.println( "Waiting for Client requests" );


      }
      catch ( java.rmi.UnknownHostException uhe )
      {
         System.out.println( "The host computer name you have specified, " + HOST_NAME + " does not match your real computer name." );

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

   }  // main

   public void registerTimeMonitor( TimeMonitor tm )
   {
      System.out.println( "Client requesting a connection" );

      TimeTicker tt;

      // Insert two lines of code that complete the implementation of this method.
      // 1. Create a new TimeTicker object
      // 2. Start this new object running.

      System.out.println( "Timer Started" );
   }


}  // class RMIServer

class TimeTicker extends Thread
{

   private TimeMonitor tm;

   TimeTicker( TimeMonitor tm )
   {
      this.tm = tm;
   }

   public void run()
   {
      while ( true )
      {
         try
         {
            sleep( 2000 );

            // Insert a single line of code that calls the tellMeTheTime
            // method of the TimeMonitor interface.
            // Pass it a new instance of the Date class.
            
         }
         catch ( Exception e )
         {
            stop();
         }
      }
   }
}


