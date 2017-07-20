package example.send;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.net.*;

import java.rmi.*;
import java.rmi.server.*;

class RemoteServer extends UnicastRemoteObject
                 implements Send {

  private String text;

  public RemoteServer() throws RemoteException {
    super();
  }

  public void sendData(String gotText){
    text = gotText;
  }

  public String getData(){
    return text;
  }

  public static void main(String[] args){
    if(System.getSecurityManager() == null) {
      System.setSecurityManager(new RMISecurityManager());
    }

    String name = "//kq6py.eng.sun.com/Send";
    try {
      Send remoteServer = new RemoteServer();
      Naming.rebind(name, remoteServer);
      System.out.println("RemoteServer bound");
    } catch (java.rmi.RemoteException e) {
      System.out.println("Cannot create remote server object");
    } catch (java.net.MalformedURLException e) {
      System.out.println("Cannot look up server object");
    }
  }
}
