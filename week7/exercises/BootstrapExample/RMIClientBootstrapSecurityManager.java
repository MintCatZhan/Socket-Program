// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI2/magercises/BootstrapClient/working/RMIClientBootstrapSecurityManager.java#3 $
import java.rmi.RMISecurityManager;

/**
 * This class defines a security policy for RMI applications
 * that are bootstrap loaded from a server. The relaxation in
 * security provided by this class is the minimal amount that
 * is required to bootstrap load and run a RMI client application.
 *
 * The policy changes from RMISecurityManager are:
 *
 * Security Check                    This Policy  RMISecurityManager
 * ------------------------------   ------------  ------------------
 * Access to Thread Groups               YES              NO
 * Access to Threads                     YES              NO
 * Create Class Loader                   YES              NO
 * System Properties Access              YES              NO
 * Connections                           YES              NO
 *
 */

public class RMIClientBootstrapSecurityManager
    extends RMISecurityManager {

  /**
   * Loaded classes are allowed to create class loaders.
   */
  public synchronized void checkCreateClassLoader() {
    // Provide null override
  }

  /**
   * Connections to other machines are allowed
   */
  public synchronized void checkConnect(String host, int port) {
	// Provide null override
  }

  /**
   * Loaded classes are allowed to manipulate threads.
   */
  public synchronized void checkAccess(Thread t) {
    // Provide null override
  }

  /**
   * Loaded classes are allowed to manipulate thread groups.
   */
  public synchronized void checkAccess(ThreadGroup g) {
    // Provide null override
  }

  /**
   * Loaded classes are allowed to access the system properties list.
   */
  public synchronized void checkPropertiesAccess() {
    // Provide null override
  }
}
