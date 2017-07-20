// File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class GreetingClient
{
   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Just connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);

         out.writeUTF("Hello from " + client.getLocalSocketAddress());

try {
Thread.sleep(1000L);    // one second
}
catch (Exception e) {}     // this never happen... nobody check for it

         InputStream inFromServer = client.getInputStream();

try {
Thread.sleep(1000L);    // one second
}
catch (Exception e) {}     // this never happen... nobody check for it

         DataInputStream in = new DataInputStream(inFromServer);

try {
Thread.sleep(1000L);    // one second
}
catch (Exception e) {}     // this never happen... nobody check for it

         System.out.println("Server says " + in.readUTF());

try {
Thread.sleep(1000L);    // one second
}
catch (Exception e) {}     // this never happen... nobody check for it

         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}