public class HotelServant extends _HotelImplBase
{
	
	public String cities()
	{
		
		return "Mebourne" + "\nSydney";
		
	}
	

    public String hotels(String city)
    {
    	if(city.equalsIgnoreCase("sydney"))
    	   return "Chevron" + "\nWentworth";
       if(city.equalsIgnoreCase("melbourne")) 
        return "Windsor" + "\nHilton";
       return "City not serviced";
    }
    

    public double rates()
    {
    	return 120.00;
    	
    }
	
	
}