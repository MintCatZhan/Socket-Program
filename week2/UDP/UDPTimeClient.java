package UDP;
/**
 * UDPTimeClient.java
 *
 *
 * 
 *
 *
 */

import java.io.*;
import java.net.*;

public class UDPTimeClient{

    public static final int DAYTIMEPORT = 9013;
    public static final int DGRAM_BUF_LEN = 512;                                
    public static void main(String[] args){
	
	if (args.length != 1) {
	    System.err.println("Usage: Client address");
	    // System.exit(1);
            return;
	}

	InetAddress address = null;
	try {
	    address = InetAddress.getByName(args[0]);
	} catch(UnknownHostException e) {
	    e.printStackTrace();
	    // System.exit(2);
            return;
	}

	DatagramSocket socket = null;
	try {
	    socket = new DatagramSocket();
	} catch (SocketException e) {
	    e.printStackTrace();
	    // System.exit(3);
            return;
	}

	try {
	    socket.connect(address, DAYTIMEPORT);
	    
	    byte[] buf = new byte[DGRAM_BUF_LEN];
	    DatagramPacket packet = new DatagramPacket(buf, buf.length);
	    socket.send(packet);
	    
	    socket.receive(packet);
	    byte[] data = packet.getData();
	    String date = new String(data);
	    System.out.println(date);
	    
	} catch(IOException e) {
	    e.printStackTrace();
	    // System.exit(4);
            return;
	}
	// System.exit(0);
        return;
    }
} // UDPTimeClient