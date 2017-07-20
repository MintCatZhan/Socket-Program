import java.io.*;
import java.net.*;

public class FileTransferTextClient {

   

    protected Socket sock;
   

    public static void main(String[] args){

	if (args.length != 1) {
	    System.err.println("Usage: Client address");
	    System.exit(1);
	}
	new FileTransferTextClient(args[0]);
    }

    public FileTransferTextClient(String server) {

	InetAddress address = null;
	try {
	    address = InetAddress.getByName(server);
	} catch(UnknownHostException e) {
	    e.printStackTrace();
	    System.exit(2);
	}

	sock = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	try {
	    sock = new Socket(address, 8089);
	    in = new DataInputStream(sock.getInputStream());
	    out = new DataOutputStream(sock.getOutputStream());
	
	
       byte size = in.readByte();
       System.out.println("size is " + size); 
       int[] a = new int[size];  
       for (byte n = 0; n < size; n++) 
       {      
          a[n] = in.readInt(); 
          System.out.println(a[n]); 
       }       

	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(1);
	
	}
}

 }   
    
