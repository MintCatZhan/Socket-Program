// Copyright MageLang Institute; Version $Id: //depot/rkahle/src/edu/modules/RMI/magercises/BootstrapServer/MessageObject.java#4 $
import java.io.Serializable;

public

class MessageObject

implements Serializable
{
   static  int number = 0;
   private int objNumber;

   public MessageObject()
   {
      objNumber = number;
      System.out.println( "MessageObject: Class Number is #" + number + " Object Number is #" +  objNumber );
      number = number + 1;
   }

   public int getNumberFromObject()
   {
     return objNumber;
   }

   public int getNumberFromClass()
   {
      return number;
   }
}
