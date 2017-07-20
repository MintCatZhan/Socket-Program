package inetAddress;

 

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetInetInfo{
    public static void main(String[] args){
        if (args.length != 1) {
            System.err.println("Usage: GetInetInfo address");
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
        System.out.println("Host name: " + address.getHostName());
        System.out.println("Host address: " + address.getHostAddress());
        // System.exit(0);
        return;
    }
} // GetInetInfo