/*
 * From An Introduction to Network Programming with Java by Jan Graba, 2007
 * published by Springer
 * Chapter 5
 */
package RMITestInterface;
import java.rmi.*;

public interface Hello extends Remote {
  public String getGreeting() throws RemoteException;
}