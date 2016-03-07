// Fig. 15.7: SharedCell.java
// Show multiple threads modifying shared object.
public class SharedCell {

   // execute application
   public static void main( String args[] )
   {
      HoldIntegerUnsynchronized sharedObject =
         new HoldIntegerUnsynchronized();

      // create threads
      ProduceInteger producer = 
         new ProduceInteger( sharedObject );
      ConsumeInteger consumer = 
         new ConsumeInteger( sharedObject );

      // start threads
      producer.start();
      consumer.start();
   }

}  // end class SharedCell


/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
