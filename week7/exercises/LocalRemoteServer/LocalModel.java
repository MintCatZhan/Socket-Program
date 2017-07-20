// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/LocalRemoteServer/LocalModel.java#2 $
/**
 * Class:        LocalModel
 *
 * Purpose:      Provides the actual services for the model.
 *               This class can be serialized and sent to
 *               a different JVM or it can be a delegatee
 *               from a remote wrapper class.
 */

public class LocalModel
  implements java.io.Serializable
{
   public String getVersionNumber()
   {
      String version = "Version 1.0";

      System.out.println( "LocalModel...Returning: " + version );

      return version;
   }
}


