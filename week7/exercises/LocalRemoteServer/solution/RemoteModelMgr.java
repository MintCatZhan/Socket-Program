// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/Solution/RemoteModelMgr.java#2 $
import java.rmi.*;

/**
 * Interface:    RemoteModelMgr
 *
 * Purpose:      Provides Remote Access to either a remote
 *               or a returned local copy of the "ComputationalModel"
 *
 * Notes:        RemoteModel is an RMI "Remote" interface.
 *               LocalModel is a local interface
 */
interface RemoteModelMgr
  extends java.rmi.Remote
{
   RemoteModelRef getRemoteModelRef()
     throws java.rmi.RemoteException;

   LocalModel     getLocalModel()
     throws java.rmi.RemoteException;
}
