// Fig. 10.6: StringIndexMethods.java
// This program demonstrates the String 
// class index methods.

// Java extension packages
import javax.swing.*;

public class StringIndexMethods {

   // String searching methods 
   public static void main( String args[] )
   {
      String letters = "abcdefghijklmabcdefghijklm";

      // test indexOf to locate a character in a string
      String output = "'c' is located at index " +
         letters.indexOf( 'c' );

      output += "\n'a' is located at index " +
         letters.indexOf( 'a', 1 );

      output += "\n'$' is located at index " +
         letters.indexOf( '$' );

      // test lastIndexOf to find a character in a string
      output += "\n\nLast 'c' is located at index " +
         letters.lastIndexOf( 'c' );

      output += "\nLast 'a' is located at index " +
         letters.lastIndexOf( 'a', 25 );

      output += "\nLast '$' is located at index " +
         letters.lastIndexOf( '$' );

      // test indexOf to locate a substring in a string
      output += "\n\n\"def\" is located at index " +
         letters.indexOf( "def" );

      output += "\n\"def\" is located at index " +
         letters.indexOf( "def", 7 );

      output += "\n\"hello\" is located at index " +
         letters.indexOf( "hello" );

      // test lastIndexOf to find a substring in a string
      output += "\n\nLast \"def\" is located at index " +
         letters.lastIndexOf( "def" );

      output += "\nLast \"def\" is located at index " +
         letters.lastIndexOf( "def", 25 );

      output += "\nLast \"hello\" is located at index " +
         letters.lastIndexOf( "hello" );

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class \"index\" Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringIndexMethods

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
