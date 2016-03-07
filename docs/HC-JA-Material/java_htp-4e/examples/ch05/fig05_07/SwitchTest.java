// Fig. 5.7: SwitchTest.java
// Drawing lines, rectangles or ovals based on user input.

// Java core packages
import java.awt.Graphics;

// Java extension packages
import javax.swing.*;

public class SwitchTest extends JApplet {
   int choice;   // user's choice of which shape to draw

   // initialize applet by obtaining user's choice
   public void init()
   {
      String input;  // user's input

      // obtain user's choice
      input = JOptionPane.showInputDialog( 
                 "Enter 1 to draw lines\n" +
                 "Enter 2 to draw rectangles\n" +
                 "Enter 3 to draw ovals\n" );

      // convert user's input to an int
      choice = Integer.parseInt( input );
   }

   // draw shapes on applet's background
   public void paint( Graphics g )
   {
      // call inherited version of method paint
      super.paint( g );

      // loop 10 times, counting from 0 through 9
      for ( int i = 0; i < 10; i++ ) { 

         // determine shape to draw based on user's choice
         switch ( choice ) {

            case 1:
               g.drawLine( 10, 10, 250, 10 + i * 10 );
               break;  // done processing case

            case 2:
               g.drawRect( 10 + i * 10, 10 + i * 10,
                  50 + i * 10, 50 + i * 10 );
               break;  // done processing case

            case 3:
               g.drawOval( 10 + i * 10, 10 + i * 10,
                  50 + i * 10, 50 + i * 10 );
               break;  // done processing case

            default:
               g.drawString( "Invalid value entered",
				  10, 20 + i * 15 );

         }  // end switch structure

      }  // end for structure

   }  // end paint method

}  // end class SwitchTest


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
