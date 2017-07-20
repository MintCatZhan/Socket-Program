// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/RemoteModelImpl.java#2 $
/**
 * Class:        RemoteModelImpl
 *
 * Purpose:      Provides remote wrapper for the LocalModel delegatee
 *
 */
public class RemoteModelImpl
  extends    java.rmi.server.UnicastRemoteObject
  implements RemoteModelRef
{
   LocalModel lm;

   public RemoteModelImpl( LocalModel lm )
     throws java.rmi.RemoteException
   {
      super();

      this.lm = lm;
      System.out.println( "RemoteModelImpl...Constructor finished" );

   }

   // Delegate to the local model implementation
   public String getVersionNumber()
     throws java.rmi.RemoteException
   {
      String s = lm.getVersionNumber();

      System.out.println( "RemoteModelImpl...Returning delegated VersionNumber: " + s );

      return s;
   }

}
