package Basic;

import java.io.*;
import java.net.*;

public class BasicServer {
    
    public static int MYPORT = 8188;

    public static void main(String argv[])
    {
    ServerSocket server = null;
    Socket client = null;
    try 
    {
        server = new ServerSocket(MYPORT);
    
        client = server.accept();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
			                         client.getInputStream()));
	    PrintStream writer = new PrintStream(client.getOutputStream());
	    
	    String clientMessage = reader.readLine();
	    System.out.println(clientMessage);
	    
	    writer.println("Hello, client from server");
	    
	    client.close();
	    
        } catch(Exception e) {
        System.out.println(e);
        }
    }        
 }
