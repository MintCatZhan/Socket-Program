// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/RMICallback/Solution/TimeMonitor.java#2 $
import java.rmi.*;
import java.util.Date;

// Create the interface TimeMonitor.
// It contains one method tellMeTheTime.
// This method accepts a parameter of type Date
// and returns void.
public interface TimeMonitor extends java.rmi.Remote
{
   public void tellMeTheTime( Date d ) throws RemoteException;
}
