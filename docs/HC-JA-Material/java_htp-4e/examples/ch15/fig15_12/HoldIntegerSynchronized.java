// Fig. 15.15: HoldIntegerSynchronized.java
// Definition of class HoldIntegerSynchronized that
// uses thread synchronization to ensure that both
// threads access sharedInt at the proper times.

// Java core packages
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

public class HoldIntegerSynchronized {
   
   // array of shared locations
   private int sharedInt[] = { -1, -1, -1, -1, -1 };

   // variables to maintain buffer information
   private boolean writeable = true;
   private boolean readable = false;
   private int readLocation = 0, writeLocation = 0;

   // GUI component to display output
   private JTextArea outputArea;

   // initialize HoldIntegerSynchronized
   public HoldIntegerSynchronized( JTextArea output )
   {
      outputArea = output;
   }

   // synchronized method allows only one thread at a time to 
   // invoke this method to set a value in a particular
   // HoldIntegerSynchronized object
   public synchronized void setSharedInt( int value )
   {
      while ( !writeable ) {

         // thread that called this method must wait 
         try {

            // update Swing GUI component
            SwingUtilities.invokeLater( new UpdateThread( 
               outputArea, " WAITING TO PRODUCE " + value ) );

            wait();
         }

         // process InterrupteException while thread waiting
         catch ( InterruptedException exception ) {
            System.err.println( exception.toString() );
         }
      }

      // place value in writeLocation
      sharedInt[ writeLocation ] = value;

      // indicate that consumer can read a value
      readable = true;

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\nProduced " + value + " into cell " + 
         writeLocation ) );

      // update writeLocation for future write operation
      writeLocation = ( writeLocation + 1 ) % 5;

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\twrite " + writeLocation + "\tread " + 
         readLocation ) );

      displayBuffer( outputArea, sharedInt );

      // test if buffer is full
      if ( writeLocation == readLocation ) {
         writeable = false;

         // update Swing GUI component
         SwingUtilities.invokeLater( new UpdateThread( outputArea,
		    "\nBUFFER FULL" ) );
      }

      // tell a waiting thread to become ready
      notify();

   }  // end method setSharedInt

   // synchronized method allows only one thread at a time to 
   // invoke this method to get a value from a particular
   // HoldIntegerSynchronized object
   public synchronized int getSharedInt()
   {
      int value;

      while ( !readable ) {

         // thread that called this method must wait 
         try {

			// update Swing GUI component
            SwingUtilities.invokeLater( new UpdateThread( 
               outputArea, " WAITING TO CONSUME" ) );

            wait();
         }

         // process InterrupteException while thread waiting
         catch ( InterruptedException exception ) {
            System.err.println( exception.toString() );
         }
      }

      // indicate that producer can write a value
      writeable = true;

      // obtain value at current readLocation
      value = sharedInt[ readLocation ];

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\nConsumed " + value + " from cell " + 
         readLocation ) );

      // update read location for future read operation
      readLocation = ( readLocation + 1 ) % 5;

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\twrite " + writeLocation + "\tread " + 
         readLocation ) );

      displayBuffer( outputArea, sharedInt );

      // test if buffer is empty
      if ( readLocation == writeLocation ) {
         readable = false;

         // update Swing GUI component
         SwingUtilities.invokeLater( new UpdateThread( 
            outputArea, "\nBUFFER EMPTY" ) );
      }

      // tell a waiting thread to become ready
      notify();

      return value;

   }  // end method getSharedInt

   // diplay contents of shared buffer
   public void displayBuffer( JTextArea outputArea, 
      int buffer[] )
   {
      DecimalFormat formatNumber = new DecimalFormat( " #;-#" );
      StringBuffer outputBuffer = new StringBuffer();
 
      // place buffer elements in outputBuffer
      for ( int count = 0; count < buffer.length; count++ )
         outputBuffer.append( 
            " " + formatNumber.format( buffer[ count ] ) );

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\tbuffer: " + outputBuffer ) );
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
