

/**
 * TLSEchoClient.java
 *
 *
 */

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class TLSEchoClient{

    public static final int MYECHOPORT = 8189;
    
    public static void main(String[] args){

	if (args.length != 1) {
	    System.err.println("Usage: Client address");
	    System.exit(1);
	}

	InetAddress address = null;
	try {
	    address = InetAddress.getByName(args[0]);
	} catch(UnknownHostException e) {
	    e.printStackTrace();
	    System.exit(2);
	}

	Socket sock = null;
	try {
	    sock = new Socket(address, MYECHOPORT);
	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(3);
	}
	SSLSocketFactory factory =
	    (SSLSocketFactory) SSLSocketFactory.getDefault();
	
	SSLSocket sslSocket = null;
	try {
	    sslSocket =
	    (SSLSocket) factory.createSocket(sock, args[0], MYECHOPORT, true);
	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(3);
	}
	
	BufferedReader reader = null;
	PrintStream out = null;

	try {
	    reader = new BufferedReader(new InputStreamReader(
                                    sslSocket.getInputStream()));
	    out = new PrintStream(sslSocket.getOutputStream());
	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(6);
	}

	String line = null;
	try {
	    // Just send a goodbye message, for testing
	    out.println("BYE");
	    line = reader.readLine();
	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(6);
	}

	System.out.println(line);
	System.exit(0);
    }
} // Client