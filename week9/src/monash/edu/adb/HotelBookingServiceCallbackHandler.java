
/**
 * HotelBookingServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package monash.edu.adb;

    /**
     *  HotelBookingServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HotelBookingServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HotelBookingServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HotelBookingServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for cities method
            * override this method for handling normal response from cities operation
            */
           public void receiveResultcities(
                    monash.edu.adb.HotelBookingServiceStub.CitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cities operation
           */
            public void receiveErrorcities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for rates method
            * override this method for handling normal response from rates operation
            */
           public void receiveResultrates(
                    monash.edu.adb.HotelBookingServiceStub.RatesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from rates operation
           */
            public void receiveErrorrates(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hotels method
            * override this method for handling normal response from hotels operation
            */
           public void receiveResulthotels(
                    monash.edu.adb.HotelBookingServiceStub.HotelsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hotels operation
           */
            public void receiveErrorhotels(java.lang.Exception e) {
            }
                


    }
    