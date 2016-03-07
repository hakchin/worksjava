// Fig. 15.13: ProduceInteger.java
// Definition of threaded class ProduceInteger

// Java extension packages
import javax.swing.*;

public class ProduceInteger extends Thread {
   private HoldIntegerSynchronized sharedObject;
   private JTextArea outputArea;

   // initialize ProduceInteger
   public ProduceInteger( HoldIntegerSynchronized shared,
      JTextArea output )
   {
      super( "ProduceInteger" );

      sharedObject = shared;
      outputArea = output;
   }

   // ProduceInteger thread loops 10 times and calls 
   // sharedObject's setSharedInt method each time
   public void run()
   {
      for ( int count = 1; count <= 10; count++ ) {

         // sleep for a random interval
         // Note: Interval shortened purposely to fill buffer
         try {
            Thread.sleep( (int) ( Math.random() * 500 ) );
         }

         // process InterruptedException during sleep
         catch( InterruptedException exception ) {
            System.err.println( exception.toString() );
         }

         sharedObject.setSharedInt( count );
      }

      // update Swing GUI component 
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\n" + getName() + " finished producing values" +
         "\nTerminating " + getName() + "\n" ) );
   }

}  // end class ProduceInteger


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
