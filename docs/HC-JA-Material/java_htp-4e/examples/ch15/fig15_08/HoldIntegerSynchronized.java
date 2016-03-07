// Fig. 15.10: HoldIntegerSynchronized.java
// Definition of class HoldIntegerSynchronized that
// uses thread synchronization to ensure that both
// threads access sharedInt at the proper times.
public class HoldIntegerSynchronized {
   private int sharedInt = -1;
   private boolean writeable = true;  // condition variable

   // synchronized method allows only one thread at a time to 
   // invoke this method to set the value for a particular
   // HoldIntegerSynchronized object
   public synchronized void setSharedInt( int value )
   {
      while ( !writeable ) {  // not the producer's turn

         // thread that called this method must wait 
         try {
            wait();  
         }

         // process Interrupted exception while thread waiting
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }
      }

      System.err.println( Thread.currentThread().getName() +
         " setting sharedInt to " + value );

      // set new sharedInt value
      sharedInt = value;

      // indicate that producer cannot store another value until
      // a consumer retrieve current sharedInt value
      writeable = false;

      // tell a waiting thread to become ready
      notify();  
   }

   // synchronized method allows only one thread at a time to 
   // invoke this method to get the value for a particular
   // HoldIntegerSynchronized object
   public synchronized int getSharedInt()
   {
      while ( writeable ) {   // not the consumer's turn

         // thread that called this method must wait 
         try {
            wait();
         }

         // process Interrupted exception while thread waiting
         catch ( InterruptedException exception ) {
            exception.printStackTrace();
         }
      }

      // indicate that producer cant store another value 
      // because a consumer just retrieved sharedInt value
      writeable = true;

      // tell a waiting thread to become ready
      notify();  

      System.err.println( Thread.currentThread().getName() +
         " retrieving sharedInt value " + sharedInt );

      return sharedInt;
   }

}  // end class HoldIntegerSynchronized

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
