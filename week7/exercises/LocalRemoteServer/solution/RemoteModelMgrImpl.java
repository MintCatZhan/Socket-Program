// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/Solution/RemoteModelMgrImpl.java#2 $
/**
 * Class:        RemoteModelMgrImpl
 *
 * Purpose:      Provides an implementation for the RemoteModelMgr
 *               RMI Service.
 *
 * Notes:        RemoteModel is an RMI "Remote" interface.
 *               LocalModel is a local interface
 */
public class RemoteModelMgrImpl
  extends    java.rmi.server.UnicastRemoteObject
  implements RemoteModelMgr
{
   LocalModel      lm;
   RemoteModelImpl rmImpl;

   /**
    * Constructor
   */
   public RemoteModelMgrImpl()
     throws java.rmi.RemoteException
   {
      super();
   }


   public RemoteModelRef getRemoteModelRef()
     throws java.rmi.RemoteException
   {
      // Lazy instantiation of delgatee
      if ( null == lm )
      {
         lm = new LocalModel();
      }

      // Lazy instantiation of Remote Interface Wrapper
      if ( null == rmImpl )
      {
         rmImpl = new RemoteModelImpl( lm );
      }

      return ( (RemoteModelRef) rmImpl );
   }


   /**
    * Returns a reference to the the object that performs
    * the real operations. If this is an RMI call, it will
    * return a copy.
   */
   public LocalModel getLocalModel()
     throws java.rmi.RemoteException
   {
      // Lazy instantiation of delgatee
      if ( null == lm )
      {
         lm = new LocalModel();
      }

      return lm;
   }
}
