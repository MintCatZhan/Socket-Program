package Basic;


import java.io.*;
import java.net.*;


public class BasicClient{

    public static final int MYPORT = 8188;
    
    public static void main(String[] args){

	Socket server = null;
	InetAddress address = null;
	
	
	
	
	try {
	    address = InetAddress.getByName("localhost");
	
	
	    server = new Socket(address, MYPORT);
	    
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
			                         server.getInputStream()));
	    PrintStream writer = new PrintStream(server.getOutputStream());
	    
	    writer.println("Hello, server from client");
	    
	    String serverMessage = reader.readLine();
	   
	    System.out.println(serverMessage);
	    
	    server.close();
	 
	} catch(Exception e) {
	    e.printStackTrace();
	    
    }

  }
	
} // BasicClient