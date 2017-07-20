package week10.common;

import java.util.ArrayList;

public class FileTransferFactory {

  public static FileTransfer newClient(String[] args) throws Exception {
    String type = args[0];

    if (type.equals("socket")) {
      return new week10.socket.FileTransferClientHOPP(args[1]);
    }
    if (type.equals("webservice")) {
      return new week10.webservice.FileTransferClientHOPP(args[1]);
    }
    if (type.equals("corba")) {
      // lose 1st element
      String[] shortArgs = new String[args.length - 1];
      for (int n = 0; n < args.length - 1; n++) {
        shortArgs[n] = args[n + 1];
      }
      return new week10.corba.FileTransferClientHOPP(shortArgs);
    }
    if (type.equals("rmi")) {
      return new week10.rmi.FileTransferClientHOPP(args[1]);
    }
    return null;
  }
}
