// Fig. 15.6: HoldIntegerUnsynchronized.java
// Definition of class HoldIntegerUnsynchronized.
public class HoldIntegerUnsynchronized {
   private int sharedInt = -1;

   // unsynchronized method to place value in sharedInt
   public void setSharedInt( int value )
   {
      System.err.println( Thread.currentThread().getName() +
         " setting sharedInt to " + value );

      sharedInt = value;
   }

   // unsynchronized method return sharedInt's value
   public int getSharedInt()
   {
      System.err.println( Thread.currentThread().getName() +
         " retrieving sharedInt value " + sharedInt );

      return sharedInt;
   }

}  // end class HoldIntegerUnsynchronized


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
