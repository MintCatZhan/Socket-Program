package monash.edu.clients.jibx;

import monash.edu.jibx.HotelBookingServiceStub;

public class HotelClient {

  /**
   * END_POINT is the web service endpoint
   */
  private final static String END_POINT = "http://localhost:8080/axis2/services/HotelBookingService";

  HotelBookingServiceStub stub;

  public HotelClient() {

    try {
      stub = new HotelBookingServiceStub(END_POINT);

    } catch (Exception e) {
      e.printStackTrace();
    }
    ;
  }

  public String[] cities() {
    String[] x = null;
    try {
      x = stub.cities();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return x;
  }

  public String[] hotels(String city) {
    String[] x = null;
    try {
      x = stub.hotels(city);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return x;
  }

  public double rates(String hotel) {
    Double x = null;
    try {
      x = stub.rates(hotel);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return x.doubleValue();
  }

}
