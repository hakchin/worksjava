// Fig. 5.1: WhileCounter.java
// Counter-controlled repetition

// Java core packages
import java.awt.Graphics;

// Java extension packages
import javax.swing.JApplet;

public class WhileCounter extends JApplet {

   // draw lines on applet’s background
   public void paint( Graphics g ) 
   {
      // call inherited version of method paint
      super.paint( g );

      int counter = 1;             // initialization

      while ( counter <= 10 ) {    // repetition condition
         g.drawLine( 10, 10, 250, counter * 10 );
         ++counter;                // increment

      }  // end while structure

   }  // end method paint

}  // end class WhileCounter

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
