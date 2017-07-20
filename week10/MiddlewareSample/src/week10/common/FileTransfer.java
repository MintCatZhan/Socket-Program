package week10.common;

import java.rmi.RemoteException;
import java.io.IOException;

public interface FileTransfer extends java.rmi.Remote {

    public boolean chdir(String dir) throws RemoteException;

    public String[] dir() throws RemoteException;

    public String getdir() throws RemoteException;

    public String get(String filename) throws RemoteException, IOException;

    public void quit() throws RemoteException;
}
