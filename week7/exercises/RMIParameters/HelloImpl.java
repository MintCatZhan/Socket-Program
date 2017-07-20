// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/RMIParameters/HelloImpl.java#2 $
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public

class HelloImpl

extends UnicastRemoteObject

implements Hello
{

   public HelloImpl() throws RemoteException
   {
      super();
   }

   public String sayHello() throws RemoteException
   {
     return "Hello!";

   }

   // Insert the implementation for getMessageObject here ->

}
