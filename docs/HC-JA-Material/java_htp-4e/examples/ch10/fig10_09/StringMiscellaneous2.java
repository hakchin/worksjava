// Fig. 10.9: StringMiscellaneous2.java
// This program demonstrates the String methods replace,
// toLowerCase, toUpperCase, trim, toString and toCharArray

// Java extension packages
import javax.swing.*;

public class StringMiscellaneous2 {

   // test miscellaneous String methods
   public static void main( String args[] )
   {
      String s1 = new String( "hello" ),
         s2 = new String( "GOOD BYE" ),
         s3 = new String( "   spaces   " );

      String output = "s1 = " + s1 + "\ns2 = " + s2 +
         "\ns3 = " + s3;

      // test method replace      
      output += "\n\nReplace 'l' with 'L' in s1: " +
         s1.replace( 'l', 'L' );

      // test toLowerCase and toUpperCase
      output +=
         "\n\ns1.toUpperCase() = " + s1.toUpperCase() +
         "\ns2.toLowerCase() = " + s2.toLowerCase();

      // test trim method
      output += "\n\ns3 after trim = \"" + s3.trim() + "\"";

      // test toString method
      output += "\n\ns1 = " + s1.toString();

      // test toCharArray method
      char charArray[] = s1.toCharArray();

      output += "\n\ns1 as a character array = ";

      for ( int count = 0; count < charArray.length; ++count )
         output += charArray[ count ];

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Miscellaneous String Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringMiscellaneous2

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
