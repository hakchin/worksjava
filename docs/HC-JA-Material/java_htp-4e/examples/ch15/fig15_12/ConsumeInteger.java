// Fig. 15.14: ConsumeInteger.java
// Definition of threaded class ConsumeInteger

// Java extension packages
import javax.swing.*;

public class ConsumeInteger extends Thread {
   private HoldIntegerSynchronized sharedObject;
   private JTextArea outputArea;

   // initialize ConsumeInteger
   public ConsumeInteger( HoldIntegerSynchronized shared,
      JTextArea output )
   {
      super( "ConsumeInteger" );

      sharedObject = shared;
      outputArea = output;
   }

   // ConsumeInteger thread loops until it receives 10
   // from sharedObject's getSharedInt method
   public void run()
   {
      int value, sum = 0;

      do {

         // sleep for a random interval
         try {
            Thread.sleep( (int) ( Math.random() * 3000 ) );
         }

         // process InterruptedException during sleep
         catch( InterruptedException exception ) {
            System.err.println( exception.toString() );
         }

         value = sharedObject.getSharedInt();
         sum += value;

      } while ( value != 10 );

      // update Swing GUI component
      SwingUtilities.invokeLater( new UpdateThread( outputArea,
         "\n" + getName() + " retrieved values totaling: " + 
         sum + "\nTerminating " + getName() + "\n" ) );
   }

}  // end class ConsumeInteger



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
