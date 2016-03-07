// Fig. 10.19: OtherCharMethods.java
// Demonstrate the non-static methods of class
// Character from the java.lang package.

// Java extension packages
import javax.swing.*;

public class OtherCharMethods {

   // test non-static Character methods
   public static void main( String args[] )
   {
      Character c1, c2;

      c1 = new Character( 'A' );
      c2 = new Character( 'a' );

      String output = "c1 = " + c1.charValue() +
         "\nc2 = " + c2.toString() +
         "\n\nhash code for c1 = " + c1.hashCode() +
         "\nhash code for c2 = " + c2.hashCode();

      if ( c1.equals( c2 ) )
         output += "\n\nc1 and c2 are equal";
      else
         output += "\n\nc1 and c2 are not equal";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Non-Static Character Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class OtherCharMethods

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
