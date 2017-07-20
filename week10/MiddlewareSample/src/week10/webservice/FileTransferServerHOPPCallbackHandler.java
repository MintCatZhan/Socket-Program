/**
 * FileTransferServerHOPPCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package week10.webservice;

/**
 * FileTransferServerHOPPCallbackHandler Callback class, Users can extend this
 * class and implement their own receiveResult and receiveError methods.
 */
public abstract class FileTransferServerHOPPCallbackHandler {

  protected Object clientData;

  /**
   * User can pass in any object that needs to be accessed once the NonBlocking
   * Web service call is finished and appropriate method of this CallBack is
   * called.
   * 
   * @param clientData
   *          Object mechanism by which the user can pass in user data that will
   *          be avilable at the time this callback is called.
   */
  public FileTransferServerHOPPCallbackHandler(Object clientData) {
    this.clientData = clientData;
  }

  /**
   * Please use this constructor if you don't want to set any clientData
   */
  public FileTransferServerHOPPCallbackHandler() {
    this.clientData = null;
  }

  /**
   * Get the client data
   */

  public Object getClientData() {
    return clientData;
  }

  /**
   * auto generated Axis2 call back method for dir method override this method
   * for handling normal response from dir operation
   */
  public void receiveResultdir(
      week10.webservice.FileTransferServerHOPPStub.DirResponse result) {
  }

  /**
   * auto generated Axis2 Error handler override this method for handling error
   * response from dir operation
   */
  public void receiveErrordir(java.lang.Exception e) {
  }

  /**
   * auto generated Axis2 call back method for getdir method override this
   * method for handling normal response from getdir operation
   */
  public void receiveResultgetdir(
      week10.webservice.FileTransferServerHOPPStub.GetdirResponse result) {
  }

  /**
   * auto generated Axis2 Error handler override this method for handling error
   * response from getdir operation
   */
  public void receiveErrorgetdir(java.lang.Exception e) {
  }

  // No methods generated for meps other than in-out

  /**
   * auto generated Axis2 call back method for chdir method override this method
   * for handling normal response from chdir operation
   */
  public void receiveResultchdir(
      week10.webservice.FileTransferServerHOPPStub.ChdirResponse result) {
  }

  /**
   * auto generated Axis2 Error handler override this method for handling error
   * response from chdir operation
   */
  public void receiveErrorchdir(java.lang.Exception e) {
  }

}
