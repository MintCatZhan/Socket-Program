// Copyright MageLang Institute; Version $Id: //depot/main/src/edu/modules/RMI-mml2/magercises/RMIParameters/MessageObject.java#2 $
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
