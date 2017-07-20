// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/RMIParameters/Solution/RMIClient.java#2 $
import java.net.*;
import java.io.*;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

/**
 * RMIClient02 utilizes the remote "Hello" object.
 *
 * RMIClient02 relies on RMIServer to do command line processing.
 */

public class RMIClient
{
   private static final int    PORT        = 10002;
//
// -> Change the name to your own computer!
//
   private static final String HOST_NAME   = "ROSA";

   // Instance of ourselves
   private static RMIClient  rmi;

   // Instance of the Root Object(s)
   private static Hello  hello;

   public static void main ( String[] args )
   {

      rmi = new RMIClient();

   }  // main



   // Constructor
   public RMIClient()
   {

      Hello         h;
      String        helloString;
      MessageObject mo;

      try
      {
         h = (Hello)Naming.lookup( "rmi://" + HOST_NAME + ":" + Integer.toString( PORT ) + "/HelloService" );

         System.out.println( "HelloService lookup successful" );

         helloString = h.sayHello();

         System.out.println( "The server says: " + helloString );


         for ( int i = 0; i< 10; i++ )
         {
            mo = h.getMessageObject();
            System.out.println( "MessageObject: Class Number is #" + mo.getNumberFromClass() + " Object Number is #" +  mo.getNumberFromObject() );
         }

      }
      catch ( java.rmi.UnknownHostException uhe )
      {
         System.out.println( "The host computer name you have specified, " + HOST_NAME + " does not match your real computer name." );
      }
      catch ( RemoteException re )
      {
         System.out.println( "A Remote Exception was thrown when requesting the HelloService" );
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

   }

}  // class RMIClient
