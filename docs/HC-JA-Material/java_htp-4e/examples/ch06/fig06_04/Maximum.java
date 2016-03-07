// Fig. 6.4: Maximum.java
// Finding the maximum of three doubles

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class Maximum extends JApplet {

   // initialize applet by obtaining user input and creating GUI
   public void init()
   {
      // obtain user input
      String s1 = JOptionPane.showInputDialog(
         "Enter first floating-point value" );
      String s2 = JOptionPane.showInputDialog(
         "Enter second floating-point value" );
      String s3 = JOptionPane.showInputDialog(
         "Enter third floating-point value" );

      // convert user input to double values
      double number1 = Double.parseDouble( s1 );
      double number2 = Double.parseDouble( s2 );
      double number3 = Double.parseDouble( s3 );

      // call method maximum to determine largest value
      double max = maximum( number1, number2, number3 );

      // create JTextArea to display results
      JTextArea outputArea = new JTextArea();

      // display numbers and maximum value 
      outputArea.setText( "number1: " + number1 +
         "\nnumber2: " + number2 + "\nnumber3: " + number3 +
         "\nmaximum is: " + max );

      // get the applet's GUI component display area
      Container container = getContentPane();

      // attach outputArea to Container c
      container.add( outputArea );

   }  // end method init

   // maximum method uses Math class method max to help
   // determine maximum value
   public double maximum( double x, double y, double z )
   {
      return Math.max( x, Math.max( y, z ) );

   }  // end method maximum

}  // end class Maximum

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
