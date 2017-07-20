// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteClient/Solution/LocalRemoteClient.java#2 $
/**
 * Class:        LocalRemoteClient
 *
 * Purpose:      Test the use of Delegation Pattern to
 *               implement Remote and Local versions
 *               of an RMI network service.
 */
import java.net.*;
import java.io.*;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;


public class LocalRemoteClient
{
   private static final int    PORT        = 10009;
   //
   // -> Change the name to your own computer!
   //
   private static final String HOST_NAME   = "ROSA";

   // Instance of ourselves
   private static LocalRemoteClient lrc;


   public static void main
     (
       String[] args
     )
   {

      lrc = new LocalRemoteClient();

   }  // main



   // Constructor
   public LocalRemoteClient()
   {

      RemoteModelMgr rmm;

      LocalModel     lm;
      RemoteModelRef rmr;

      String         versionLocal;
      String         versionRemote;


      try
      {
         rmm = (RemoteModelMgr)Naming.lookup( "rmi://" + HOST_NAME + ":" + Integer.toString( PORT ) + "/RemoteModelManager" );

         System.out.println( "RemoteModelManager lookup successful" );

         rmr           = rmm.getRemoteModelRef();
         versionRemote = rmr.getVersionNumber();

         System.out.println( "Remote version: " + versionRemote );

         lm            = rmm.getLocalModel();

         System.out.println( "Local Version of the model loaded" );

         versionLocal  = lm.getVersionNumber();

         System.out.println( "Local  version: " + versionLocal  );


      }
      catch ( java.rmi.UnknownHostException uhe )
      {
         System.out.println( "The host computer name you have specified, " + HOST_NAME + " does not match your real computer name." );
      }
      catch ( RemoteException re )
      {
         System.out.println( "A Remote Exception was thrown when requesting the RemoteModelManager Server" );
         System.out.println( "" + re );
      }
      catch ( MalformedURLException mURLe )
      {
         System.out.println( "There is a problem with the rmi: URL you are using" );
         System.out.println( "" + mURLe );
      }
      catch ( NotBoundException nbe )
      {
         System.out.println( "" + nbe );
      }
      catch ( Exception e )
      {
         System.out.println( "" + e );
      }

   }

}  // class LocalRemoteClient
