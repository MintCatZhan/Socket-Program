package TCP;

import java.io.*;
import java.net.*;

public class MultiEchoServer {
    
    public static int MYECHOPORT = 8189;

    public static void main(String argv[]) {
	ServerSocket s = null;
	try {
	    s = new ServerSocket(MYECHOPORT);
	} catch(IOException e) {
	    System.out.println(e);
	    System.exit(1);
	}
     System.out.println("Echo Server Running");
	while (true) {
	    Socket incoming = null;
	    try {
		incoming = s.accept();
	    } catch(IOException e) {
		System.out.println(e);
		continue;
	    }

	    new SocketHandler(incoming).start();

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
		String str = reader.readLine();
		System.out.println(str);
	    out.println("Echo from Server: " + str + " Enter BYE to exit");
	    
	    boolean done = false;
	    while ( ! done) {
		str = reader.readLine();
		if (str == null) 
		    done = true;
		else {
		    System.out.println(str);
		    out.println("Echo from Server: " + str);
		    if (str.trim().equalsIgnoreCase("BYE"))
			done = true;
		}
		
	    }
	    incoming.close();
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }
}
