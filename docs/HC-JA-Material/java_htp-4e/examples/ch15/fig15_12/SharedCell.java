// Fig. 15.16: SharedCell.java
// Show multiple threads modifying shared object.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

public class SharedCell extends JFrame {

   // set up GUI
   public SharedCell()
   {
      super( "Demonstrating Thread Synchronization" );

      JTextArea outputArea = new JTextArea( 20, 30 );
      getContentPane().add( new JScrollPane( outputArea ) );

      setSize( 500, 500 );
      show();

      // set up threads 
      HoldIntegerSynchronized sharedObject =
         new HoldIntegerSynchronized( outputArea );

      ProduceInteger producer = 
         new ProduceInteger( sharedObject, outputArea );

      ConsumeInteger consumer = 
         new ConsumeInteger( sharedObject, outputArea );

      // start threads
      producer.start();
      consumer.start();
   }

   // execute application
   public static void main( String args[] )
   {
      SharedCell application = new SharedCell();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
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
