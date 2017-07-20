package monash.edu.ws;

public class HotelBookingService {

  public String[] cities() {
    String cities[] = { "Melbourne", "Sydney" };
    return cities;

  }

  public String[] hotels(String city) {
    String[] sydneyHotels = { "Chevron", "Wentworth" };
    String[] melbourneHotels = { "Windsor", "Hilton" };
    String[] nullHotel = { "City not serviced" };
    if (city.equalsIgnoreCase("sydney"))
      return sydneyHotels;
    if (city.equalsIgnoreCase("melbourne"))
      return melbourneHotels;
    return nullHotel;
  }

  public double rates(String hotel) {
    if (hotel.equalsIgnoreCase("Windsor"))
      return 120.00;
    if (hotel.equalsIgnoreCase("Hilton"))
      return 150.00;
    if (hotel.equalsIgnoreCase("Chevron"))
      return 100.00;
    if (hotel.equalsIgnoreCase("Wentworth"))
      return 110.00;
    return 0;

  }

}
