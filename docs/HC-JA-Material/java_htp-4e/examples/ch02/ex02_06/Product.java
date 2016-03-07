// Calculate the product of three integers

// Java extension packages
import javax.swing.JOptionPane;

public class Product {

   public static void main( String args[] )
   {
      int x, y, z, result;
      String xVal, yVal, zVal;

      xVal = JOptionPane.showInputDialog(
         "Enter first integer:" );
      yVal = JOptionPane.showInputDialog(
         "Enter second integer:" );
      zVal = JOptionPane.showInputDialog(
         "Enter third integer:" );

      x = Integer.parseInt( xVal );
      y = Integer.parseInt( yVal );
      z = Integer.parseInt( zVal );

      result = x * y * z;
      JOptionPane.showMessageDialog( null,
         "The product is " + result );

      System.exit( 0 );
   }
}

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