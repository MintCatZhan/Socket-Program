package TCP;

import java.io.*;
import java.net.*;

public class EchoServer {
    
    public static int MYECHOPORT = 8189;

    public static void main(String argv[]) {
	ServerSocket s = null;
	try {
	    s = new ServerSocket(MYECHOPORT);
	} catch(IOException e) {
	    System.out.println(e);
	    System.exit(1);
	}
	while (true) {
	    Socket incoming = null;
	    try {
		incoming = s.accept();
	    } catch(IOException e) {
		System.out.println(e);
		continue;
	    }

	    try {
		incoming.setSoTimeout(10000); // 10 seconds
	    } catch(SocketException e) {
		e.printStackTrace();
	    }

	    try {
		handleSocket(incoming);
	    } catch(InterruptedIOException e) {
		System.out.println("Time expired " + e);
	    } catch(IOException e) {
		System.out.println(e);
	    }

	    try {
		incoming.close();
	    } catch(IOException e) {
		// ignore
	    }
	}  
    }
    
    public static void handleSocket(Socket incoming) throws IOException {
	BufferedReader reader =
	    new BufferedReader(new InputStreamReader(
			       incoming.getInputStream()));
	PrintStream out =
	    new PrintStream(incoming.getOutputStream());
	out.println("Hello. Enter BYE to exit");
	
	boolean done = false;
	while ( ! done) {
	    String str = reader.readLine();
	    if (str == null) {
		done = true;
		System.out.println("Null received");
	    }
	    else {
		out.println("Echo: " + str);
		if (str.trim().equals("BYE"))
		    done = true;
	    }
	    
		}
	incoming.close();
    }
}