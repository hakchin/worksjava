// Fig. 10.10: StringValueOf.java
// This program demonstrates the String class valueOf methods.

// Java extension packages
import javax.swing.*;

public class StringValueOf {

   // test String valueOf methods
   public static void main( String args[] )
   {
      char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
      boolean b = true;
      char c = 'Z';
      int i = 7;
      long l = 10000000;
      float f = 2.5f;
      double d = 33.333;

      Object o = "hello";  // assign to an Object reference
      String output;

      output = "char array = " + String.valueOf( charArray ) +
         "\npart of char array = " +
         String.valueOf( charArray, 3, 3 ) +
         "\nboolean = " + String.valueOf( b ) +
         "\nchar = " + String.valueOf( c ) +
         "\nint = " + String.valueOf( i ) +
         "\nlong = " + String.valueOf( l ) + 
         "\nfloat = " + String.valueOf( f ) + 
         "\ndouble = " + String.valueOf( d ) + 
         "\nObject = " + String.valueOf( o );

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class valueOf Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringValueOf

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
