// Fig. 3.12: AdditionApplet.java
// Adding two floating-point numbers.

// Java core packages
import java.awt.Graphics;   // import class Graphics

// Java extension packages
import javax.swing.*;       // import package javax.swing

public class AdditionApplet extends JApplet {
   double sum;  // sum of values entered by user

   // initialize applet by obtaining values from user
   public void init()
   {
      String firstNumber;   // first string entered by user
      String secondNumber;  // second string entered by user
      double number1;       // first number to add
      double number2;       // second number to add

      // obtain first number from user
      firstNumber = JOptionPane.showInputDialog(
         "Enter first floating-point value" );

      // obtain second number from user
      secondNumber = JOptionPane.showInputDialog(
         "Enter second floating-point value" );

      // convert numbers from type String to type double
      number1 = Double.parseDouble( firstNumber ); 
      number2 = Double.parseDouble( secondNumber );

      // add numbers
      sum = number1 + number2;
   }

   // draw results in a rectangle on applet’s background
   public void paint( Graphics g )
   {
      // call inherited version of method paint
      super.paint( g );

      // draw rectangle starting from (15, 10) that is 270 
      // pixels wide and 20 pixels tall
      g.drawRect( 15, 10, 270, 20 );

      // draw results as a String at (25, 25)
      g.drawString( "The sum is " + sum, 25, 25 );

   }  // end method paint

}  // end class AdditionApplet

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
