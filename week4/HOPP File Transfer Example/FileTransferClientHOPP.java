/**
 * FileTransferTextClient.java
 *
 *
 * 
 */
import java.io.*;
import java.net.*;

public class FileTransferClientHOPP {

    protected Socket sock;
    protected BufferedReader reader;
    protected PrintStream writer;

    public FileTransferClientHOPP(String server)
	throws UnknownHostException, IOException {

	InetAddress address = InetAddress.getByName(server);

	sock = null;
	InputStream in = null;
	OutputStream out = null;

	sock = new Socket(address, FileTransferTextConstants.PORT);
	in = sock.getInputStream();
	out = sock.getOutputStream();

	reader = new BufferedReader(new InputStreamReader(in));
	writer = new PrintStream(out);
    }

    public void quit() {
	try {
	    writer.print(FileTransferTextConstants.QUIT +
			 FileTransferTextConstants.CR_LF);
	    reader.close();
	    writer.close();
	    sock.close();
	} catch(Exception e) {
	    // ignore
	}
    }

    public String[] dir() {
	// stub
	return null;
    }

    public boolean chdir(String dir) {
	writer.print(FileTransferTextConstants.CD + " " + dir + 
		     FileTransferTextConstants.CR_LF);

	String response = null;
	try {
	    response = reader.readLine();
	} catch(IOException e) {
	    return false;
	}
	if (response.startsWith(FileTransferTextConstants.SUCCEEDED)) {
	    return true;
	} else {
	    return false;
	}
    }

    public String get(String filename) throws IOException {
	// stub
	return "";
    }
} // FileTransferClientHOPP