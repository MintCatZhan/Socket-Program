import java.io.*;
import java.net.*;

public class FileTransferTextServer {
    

    public static void main(String argv[]) {
	ServerSocket s = null;
	try {
	    s = new ServerSocket(8089);
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

	    new SocketHandler(incoming).start();
	}
    }
}

class SocketHandler extends Thread {

    Socket incoming;
    File clientDir = new File(".");
    BufferedReader reader;
    DataOutputStream out;

    SocketHandler(Socket incoming) {
	this.incoming = incoming;
    }

    public void run() {
	try {
	    
	    out = new DataOutputStream(incoming.getOutputStream());
	    
	    int[] a = {1,2,3,4}; 
        out.writeByte(4);     
        for (int n = 0; n < 4; n++) 
        {
           System.out.println("Writing " + a[n]);
           out.writeInt(a[n]); 
        }
	    
	    incoming.close();
	} catch(IOException e) {
	    e.printStackTrace();
	}
    }


    
    
}
