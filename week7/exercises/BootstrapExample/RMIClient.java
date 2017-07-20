// Copyright MageLang Institute; Version $Id: //depot/rkahle/src/edu/modules/RMI/magercises/BootstrapServer/RMIClient.java#4 $
import java.net.*;
import java.io.*;
import java.util.Properties;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;

/**
 * RMIClient is a bootstrap loaded RMI Client program.
 *
 * It implements the Runnable interface so that
 * it has a well known way to start.
 *
 */

public class RMIClient

implements Runnable
{
   // Instance of the Root Object(s)
   private Hello         hello;

   private String        rmiName;
   private Properties    p;
   private MessageObject mo;

   public void run()
   {
      try
      {
         // Retrieve the network location of the RMIServer location
         // This was stored in the system properties by the bootstrap
         // loader program.
         p       = System.getProperties();
         rmiName = (String)p.get( "java.rmi.server.rminode" );
         hello   = (Hello)Naming.lookup( rmiName + "Hello" );

         System.out.println( "Message from Server: " + hello.sayHello() );

         for ( int i = 0; i< 10; i++ )
         {
            mo = hello.getMessageObject();
            System.out.println( "MessageObject: Class Number is #" + mo.getNumberFromClass() + " Object Number is #" +  mo.getNumberFromObject() );
         }
      }
      catch ( Exception e )
      {
         System.out.println( "RMIClient encountered an error when trying to locate Hello on the server" + e );
         e.printStackTrace();
      }
   }

}  // class RMIClient
