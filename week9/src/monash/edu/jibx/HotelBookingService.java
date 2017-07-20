

/**
 * HotelBookingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package monash.edu.jibx;

    /*
     *  HotelBookingService java interface
     */

    public interface HotelBookingService {
          

        /**
          * Auto generated method signature
          * 
         */

         
                     public java.lang.String[] cities(

                        )
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param rates
                
         */

         
                     public Double rates(

                        java.lang.String hotel)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param hotels
                
         */

         
                     public java.lang.String[] hotels(

                        java.lang.String city)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    