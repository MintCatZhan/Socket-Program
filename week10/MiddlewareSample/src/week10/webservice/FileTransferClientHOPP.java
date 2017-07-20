package week10.webservice;

import java.io.IOException;
import java.rmi.RemoteException;
import week10.webservice.FileTransferServerHOPPStub;
import week10.common.FileTransfer;
import javax.xml.namespace.QName;

public class FileTransferClientHOPP implements FileTransfer {

  private FileTransferServerHOPPStub stub;

  public FileTransferClientHOPP(String host) throws Exception {
    String END_POINT = "http://localhost:8080/axis2/services/FileTransferService";
    try {
      stub = new FileTransferServerHOPPStub(END_POINT);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void quit() throws RemoteException {
    FileTransferServerHOPPStub.Quit q = new FileTransferServerHOPPStub.Quit();
    stub.quit(q);
  }

  public String[] dir() throws RemoteException {
    FileTransferServerHOPPStub.Dir d = new FileTransferServerHOPPStub.Dir();
    FileTransferServerHOPPStub.DirResponse dResponse = stub.dir(d);
    String[] ret = dResponse.get_return();
    return ret;
  }

  public boolean chdir(String dir) throws RemoteException {
    FileTransferServerHOPPStub.Chdir cdInput = new FileTransferServerHOPPStub.Chdir();
    cdInput.setDir(dir);
    FileTransferServerHOPPStub.ChdirResponse cdResponse = stub.chdir(cdInput);
    Boolean ret = cdResponse.get_return();
    return ret.booleanValue();
  }

  public String getdir() throws RemoteException {
    FileTransferServerHOPPStub.Getdir gdInput = new FileTransferServerHOPPStub.Getdir();
    FileTransferServerHOPPStub.GetdirResponse gdResponse = stub.getdir(gdInput);
    String ret = gdResponse.get_return();
    return ret;
  }

  public String get(String filename) throws RemoteException, IOException {
    
    return null;
  }
}
