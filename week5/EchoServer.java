package echoDES;


import java.io.*;
import java.net.*;
import javax.crypto.spec.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.*;

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

	    /*
	    try {
		incoming.setSoTimeout(10000); // 10 seconds
	    } catch(SocketException e) {
		e.printStackTrace();
	    }
	    */

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
	DataInputStream in =
	    new DataInputStream(incoming.getInputStream());
	DataOutputStream out =
	    new DataOutputStream(incoming.getOutputStream());

	// should get user id first in order to work out which
	// key to use. Here, just use the same key for everyone
	byte[] key = new byte[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	             // should be DESKeySpec.DES_KEY_LEN bytes
	DESKeySpec spec = null;
	try {
	    spec = new DESKeySpec(key);
	} catch(InvalidKeyException e) {
	    e.printStackTrace();
	    return;
	}
	SecretKeyFactory factory = null;
	try {
	    factory = SecretKeyFactory.getInstance("DES");
	} catch(NoSuchAlgorithmException e) {
	    e.printStackTrace();
	    return;
	}
	SecretKey secret = null;
	try {
	    secret = factory.generateSecret(spec);
	} catch(InvalidKeySpecException e) {
	    e.printStackTrace();
	    return;
	}

	Cipher inCipher = null;
	Cipher outCipher = null;
	try {
	    inCipher = Cipher.getInstance("DES");
	    outCipher = Cipher.getInstance("DES");
	} catch( NoSuchAlgorithmException e) {
	    e.printStackTrace();
	    return;
	} catch(NoSuchPaddingException e) {
	    e.printStackTrace();
	    return;
	}

	try {
	    inCipher.init(Cipher.DECRYPT_MODE, secret);
	    outCipher.init(Cipher.ENCRYPT_MODE, secret);
	} catch(InvalidKeyException e) {
	    e.printStackTrace();
	    return;
	}

	while (true) {
	    // read a byte saying how many bytes of data
	    // are coming
	    byte length = in.readByte();
	    byte[] inBytes = new byte[length];
	    int nread = in.read(inBytes);
	    if (nread != length) {
		break;
	    }
	    byte[] inDecrypt = null;
	    try {
		inDecrypt = inCipher.doFinal(inBytes);
	    } catch(IllegalBlockSizeException e) {
		e.printStackTrace();
		break;
	    } catch(BadPaddingException e) {
		e.printStackTrace();
		break;
	    }

	    String inStr = new String(inDecrypt);
	    System.out.println("Read from client: " + inStr);
	    if (inStr.equals("BYE")) {
		break;
	    }

	    // send it back
	    byte[] outCrypt = null;
	    try {
		outCrypt = outCipher.doFinal(inStr.getBytes());
	    } catch(IllegalBlockSizeException e) {
		e.printStackTrace();
		break;
	    } catch(BadPaddingException e) {
		e.printStackTrace();
		break;
	    }

	    out.writeByte((byte) outCrypt.length);
	    out.write(outCrypt);

	}
	incoming.close();
    }
}