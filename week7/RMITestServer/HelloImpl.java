/*
 * From An Introduction to Network Programming with Java by Jan Graba, 2007
 * published by Springer
 * Chapter 5
 */
package RMITestServer;
import java.rmi.*;
import java.rmi.server.*;
import RMITestInterface.Hello;

public class HelloImpl extends UnicastRemoteObject implements Hello {
  public HelloImpl() throws RemoteException
  {
    // No action needed here.
  }

  public String getGreeting() throws RemoteException {
    return "Hello, World!";
  }
}