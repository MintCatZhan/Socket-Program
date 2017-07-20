// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/Solution/RemoteModelRef.java#2 $
/**
 * Interface:    RemoteModelRef
 *
 * Purpose:      Provides remote access to the "ComputationalModel"
 *
 * Notes:
 */
interface RemoteModelRef
  extends  java.rmi.Remote
{
   String getVersionNumber() throws java.rmi.RemoteException;
}
