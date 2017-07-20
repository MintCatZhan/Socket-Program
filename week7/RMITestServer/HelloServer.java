/*
 * From An Introduction to Network Programming with Java by Jan Graba, 2007
 * published by Springer
 * Chapter 5
 */
package RMITestServer;
import java.rmi.*;

public class HelloServer {
  private static final String HOST = "localhost";

  public static void main(String[] args) throws Exception {

    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }

    // Create a reference to an
    // implementation object...
    HelloImpl temp = new HelloImpl();
    // Create the string URL holding the
    // object's name...
    String rmiObjectName = "rmi://localhost/Hello";
    // (Could omit host name here, since 'localhost'
    // would be assumed by default.)

    // 'Bind' the object reference to the name...
    Naming.rebind(rmiObjectName, temp);

    // Display a message so that we know the process
    // has been completed...
    System.out.println("Binding complete...\n");
  }
}