import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;


public class HotelBroker
{
 public static void main(String[] args)
{
try
{
	ORB orb = ORB.init(args,null);
	HotelServant servant = new HotelServant();
	orb.connect(servant);
	org.omg.CORBA.Object objectRef =
	orb.resolve_initial_references("NameService");
	NamingContext namingContext =
	NamingContextHelper.narrow(objectRef);
	NameComponent nameComp =
	new NameComponent("Hotel", "");
	NameComponent[] path = {nameComp};
	namingContext.rebind(path,servant);
	java.lang.Object syncObj =
	new java.lang.Object();
	synchronized(syncObj)
	{
		syncObj.wait();
	}
}catch (Exception ex)
{
	System.out.println("*** Server error! ***");
ex.printStackTrace();
}
}
}
