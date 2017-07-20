import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class HotelClient
{


Hotel hotelRef;
 
public static void main(String[] args)
{
try
{
	HotelClient client= new HotelClient(args);
	
	System.out.println("Cities: " + client.cities());
	System.out.println("Sydney Hotels: \n" + client.hotels("Sydney"));
	System.out.println("Melbourne Hotels: \n" + client.hotels("Melbourne"));
	System.out.println("Perth Hotels: \n" + client.hotels("Perth"));
	System.out.println("Rates: " + client.rates());


}catch (Exception ex)
{
	System.out.println("*** Client error! ***");
	ex.printStackTrace();
}
}


public HotelClient(String args[])
{
   setup(args);
}

public void setup(String args[])
{
try
{
ORB orb = ORB.init(args,null);
org.omg.CORBA.Object objectRef =
orb.resolve_initial_references(
"NameService");
NamingContext namingContext =
NamingContextHelper.narrow(objectRef);
NameComponent nameComp =
new NameComponent("Hotel", "");
NameComponent[] path = {nameComp};
//Re-use existing object reference...
objectRef = namingContext.resolve(path);
hotelRef = HotelHelper.narrow(objectRef);
}
catch (Exception ex)
{
System.out.println("*** Client error! ***");
ex.printStackTrace();
}
}

      public String cities()
	{
		
		return hotelRef.cities();

		
	}
	
    public String hotels(String city)
    {
    	return hotelRef.hotels(city);
    }
    
    public double rates()
    {
    	return hotelRef.rates();
    	
    }


}