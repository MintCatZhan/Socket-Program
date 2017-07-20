package monash.edu.clients.adb;

import monash.edu.adb.HotelBookingServiceStub;
import monash.edu.adb.HotelBookingServiceStub.*;

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
      Cities cInput = new Cities();
      CitiesResponse cResponse = stub.cities(cInput);
      x = (String[]) cResponse.get_return();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return x;
  }

  public String[] hotels(String city) {
    String[] x = null;
    try {
      Hotels hInput = new Hotels();
      hInput.setCity(city);
      HotelsResponse hResponse = stub.hotels(hInput);
      x = hResponse.get_return();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return x;
  }

  public double rates(String hotel) {
    Double x = null;
    try {
      Rates rInput = new Rates();
      rInput.setHotel(hotel);
      RatesResponse rResponse = stub.rates(rInput);
      x = rResponse.get_return();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return x.doubleValue();
  }

}
