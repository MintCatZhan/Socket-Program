/**
 * SimpleURL.java
 */

import java.net.*;
import java.io.*;

public class SimpleURL {
	public SimpleURL() {

	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java SimpleURL url");
			System.exit(1);
		}

		URL url = null;
		try {
			url = new URL(args[0]);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		Object content = null;
		try {
			content = url.getContent();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(2);
		}
		// The content is actually a subclass of InputStream
		BufferedReader reader = null;
		reader = new BufferedReader(
				new InputStreamReader((InputStream) content));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(3);
		}
	}
} // SimpleURL