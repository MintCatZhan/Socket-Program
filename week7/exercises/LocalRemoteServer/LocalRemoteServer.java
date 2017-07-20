// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/LocalRemoteServer.java#2 $
/**
 * Class:        LocalRemoteServer
 *
 * Purpose:      Instatiates and Registers the Remote Services
 *               neede for this Magercise.
 */
import java.net.*;
import java.io.*;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

public class LocalRemoteServer
{
   private static final int    PORT        = 10009;

   //
   // -> Change the name to your own computer name
   //
   private static final String HOST_NAME   = "ROSA";


   // Instance of ourselves
   private static LocalRemoteServer lrs;

   public static void main
      (
         String[] args
      )
   {
      // We need to set the security manager to the RMISecurityManager
      System.setSecurityManager( new RMISecurityManager() );

      try
      {
         lrs = new LocalRemoteServer();
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
      catch ( NotBoundException nbe )
      {
         System.out.println( "Not Bound" );
         System.out.println( "" + nbe );
      }

   }  // main


   // Constructor
   public LocalRemoteServer()
     throws RemoteException,
            MalformedURLException,
            NotBoundException
   {

      LocateRegistry.createRegistry( PORT );

      System.out.println( "Registry created on host computer " + HOST_NAME + " on port " + Integer.toString( PORT) );

      RemoteModelMgrImpl rmmImpl = new RemoteModelMgrImpl();

      System.out.println( "RemoteModelImpl object created" );

      String urlString = "//" + HOST_NAME + ":" + Integer.toString( PORT ) + "/" + "RemoteModelManager";

      Naming.rebind( urlString, rmmImpl );

      System.out.println( "Bindings Finished, waiting for client requests." );
   }

}  // class LocalRemoteServer

