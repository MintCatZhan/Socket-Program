package TCP;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{

    public static final int ECHOPORT = 8189;
    
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

	Socket sock = null;
	try {
	    sock = new Socket(address, ECHOPORT);
	  
	} catch(IOException e) {
	    e.printStackTrace();
	    // System.exit(3);
            return;
	}

	InputStream in = null;
	PrintStream out = null;
	try {
	    in = sock.getInputStream();
	    out =
		new PrintStream(sock.getOutputStream());
	} catch(IOException e) {
	    e.printStackTrace();
	    // System.exit(5);
            return;
	}
    System.out.println("Client Running");
	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	out.println("Hello, server!");
		Scanner console = new Scanner(System.in);
		String message = "";
	while(!message.equalsIgnoreCase("BYE"))
	{
	   
	    
	String line = null;
	try {
	    line = reader.readLine();
	} catch(IOException e) {
	    e.printStackTrace();
	    // System.exit(6);
            return;
	}

	System.out.println(line);
	message = console.nextLine();
	out.println(message);
	// System.exit(0);
}
       System.out.println("Client Closed");
        return;
    }
} // Client