// Fig. 10.2: StringMiscellaneous.java
// This program demonstrates the length, charAt and getChars
// methods of the String class.
//
// Note: Method getChars requires a starting point
// and ending point in the String. The starting point is the
// actual subscript from which copying starts. The ending point
// is one past the subscript at which the copying ends.

// Java extension packages
import javax.swing.*;

public class StringMiscellaneous {

   // test miscellaneous String methods
   public static void main( String args[] )
   {
      String s1, output;
      char charArray[];

      s1 = new String( "hello there" );
      charArray = new char[ 5 ];

      // output the string
      output = "s1: " + s1;

      // test length method
      output += "\nLength of s1: " + s1.length();

      // loop through characters in s1 and display reversed
      output += "\nThe string reversed is: ";

      for ( int count = s1.length() - 1; count >= 0; count-- )
         output += s1.charAt( count ) + " ";

      // copy characters from string into char array
      s1.getChars( 0, 5, charArray, 0 );
      output += "\nThe character array is: ";

      for ( int count = 0; count < charArray.length; count++ )
         output += charArray[ count ];

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class Constructors",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringMiscellaneous

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
