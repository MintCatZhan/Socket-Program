/*
 * From An Introduction to Network Programming with Java by Jan Graba, 2007
 * published by Springer
 * Chapter 5
 */
package RMITestClient;
import java.rmi.*;
import RMITestInterface.Hello;

public class HelloClient {
  private static final String HOST = "localhost";

  public static void main(String[] args) {
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }
    try {
      // Obtain a reference to the object from the
      // registry and typecast it into the appropriate
      // type...
      Hello greeting = (Hello) Naming.lookup("rmi://localhost/Hello");
      // Use the above reference to invoke the remote
      // object's method...
      System.out.println("Message received: " + greeting.getGreeting());
    } catch (ConnectException conEx) {
      System.out.println("Unable to connect to server!");
      System.exit(1);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }
  }
}