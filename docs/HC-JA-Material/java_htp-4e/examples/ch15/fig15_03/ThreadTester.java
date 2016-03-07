// Fig. 15.3: ThreadTester.java
// Show multiple threads printing at different intervals.

public class ThreadTester {

   // create and start threads
   public static void main( String args[] )
   {
      PrintThread thread1, thread2, thread3, thread4;

      // create four PrintThread objects
      thread1 = new PrintThread( "thread1" );
      thread2 = new PrintThread( "thread2" );
      thread3 = new PrintThread( "thread3" );
      thread4 = new PrintThread( "thread4" );

      System.err.println( "\nStarting threads" );

      // start executing PrintThreads
      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();

      System.err.println( "Threads started\n" );
   }

}  // end class ThreadTester

// Each object of this class picks a random sleep interval.
// When a PrintThread executes, it prints its name, sleeps,
// prints its name again and terminates.
class PrintThread extends Thread {
   private int sleepTime;

   // PrintThread constructor assigns name to thread 
   // by calling superclass Thread constructor
   public PrintThread( String name )
   {
      super( name );

      // sleep between 0 and 5 seconds
      sleepTime = (int) ( Math.random() * 5000 );

      // display name and sleepTime
      System.err.println( 
         "Name: " + getName() + ";  sleep: " + sleepTime );
   }

   // control thread's execution
   public void run()
   {
      // put thread to sleep for a random interval
      try {
         System.err.println( getName() + " going to sleep" );

         // put thread to sleep
         Thread.sleep( sleepTime );
      }

      // if thread interrupted during sleep, catch exception 
      // and display error message
      catch ( InterruptedException interruptedException ) {
         System.err.println( interruptedException.toString() );
      }

      // print thread name
      System.err.println( getName() + " done sleeping" );
   }

}  // end class PrintThread


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
