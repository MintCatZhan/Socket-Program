// Copyright MageLang Institute; Version $Id: //depot/rkahle/src/edu/modules/RMI/magercises/BootstrapServer/HelloImpl.java#4 $
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

   public MessageObject getMessageObject() throws RemoteException
   {
      return new MessageObject();
   }

}
