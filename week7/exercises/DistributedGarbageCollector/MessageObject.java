// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/DistributedGarbageCollector/MessageObject.java#2 $
import java.io.Serializable;
import java.rmi.server.*;

public

interface MessageObject extends java.rmi.Remote

{

   public int getNumberFromObject() throws java.rmi.RemoteException;

   public int getNumberFromClass() throws java.rmi.RemoteException;

}
