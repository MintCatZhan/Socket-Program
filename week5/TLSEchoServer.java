

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class TLSEchoServer {
    
    public static int MYECHOPORT = 8189;

    public static void main(String argv[]) {
	try {
	    SSLServerSocketFactory factory =
		(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	    
	    SSLServerSocket sslSocket =
		(SSLServerSocket) factory.createServerSocket(MYECHOPORT);

	    while (true) {
		Socket incoming = sslSocket.accept();
		new SocketHandler(incoming).start();
	    }  
	} catch(IOException e) {
	    e.printStackTrace();
	    System.exit(30);
	}
    }
}

class SocketHandler extends Thread {

    Socket incoming;

    SocketHandler(Socket incoming) {
	this.incoming = incoming;
    }

    public void run() {
	try {
	    BufferedReader reader =
		new BufferedReader(new InputStreamReader(
				   incoming.getInputStream()));
	    PrintStream out =
		new PrintStream(incoming.getOutputStream());

	    boolean done = false;
	    while ( ! done) {
		String str = reader.readLine();
		if (str == null) 
		    done = true;
		else {
		    System.out.println("Read from client: " + str);
		    out.println("Echo: " + str);
		    if (str.trim().equals("BYE"))
			done = true;
		}
		
	    }
	    incoming.close();
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
