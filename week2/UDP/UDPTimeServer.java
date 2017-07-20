package UDP;
/**
 * UDPTimeServer.java
 *
 *
 * 
 *
 * 
 */

import java.io.*;
import java.net.*;
import java.util.Date;

public class UDPTimeServer {

    public static final int DAYTIMEPORT = 9013;
    public static final int DGRAM_BUF_LEN = 512;

    public static void main(String[] args){
	
	DatagramSocket socket = null;
	try {
	    socket = new DatagramSocket(DAYTIMEPORT);
	} catch (SocketException e) {
	    e.printStackTrace();
	    System.exit(3);
	}
	while (true) {
	    try {
		byte[] buf = new byte[DGRAM_BUF_LEN];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		String date = new Date().toString();
		buf = date.getBytes();

		// get client info
		InetAddress clientAddr = packet.getAddress();
		int port = packet.getPort();
		// prepare packet for return to client
		packet = new DatagramPacket(buf, buf.length, clientAddr, port);
		socket.send(packet);
	    } catch(IOException e) {
		e.printStackTrace();
	    }
	}
    }
} // UDPTimeServer