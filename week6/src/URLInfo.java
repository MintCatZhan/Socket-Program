/**
 * URLInfo.java
 */
import java.net.*;
import java.io.*;
import java.util.*;

public class URLInfo {
	public URLInfo() {

	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java URLInfo url");
			System.exit(1);
		}
		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		URLConnection connection = null;
		try {
			connection = url.openConnection();
			connection.connect();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("Encoding: " + connection.getContentEncoding());
		System.out.println("Type: " + connection.getContentType());
		System.out.println("Length: " + connection.getContentLength());
		System.out.println("Date: " + new Date(connection.getDate()));
	}
} // URLInfo