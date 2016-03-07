// Fig. 10.14: StringBufferChars.java
// The charAt, setCharAt, getChars, and reverse methods 
// of class StringBuffer.

// Java extension packages
import javax.swing.*;

public class StringBufferChars {

   // test StringBuffer character methods
   public static void main( String args[] )
   {
      StringBuffer buffer = new StringBuffer( "hello there" );

      String output = "buffer = " + buffer.toString() +
         "\nCharacter at 0: " + buffer.charAt( 0 ) +
         "\nCharacter at 4: " + buffer.charAt( 4 );

      char charArray[] = new char[ buffer.length() ];
      buffer.getChars( 0, buffer.length(), charArray, 0 );
      output += "\n\nThe characters are: ";

      for ( int count = 0; count < charArray.length; ++count )
         output += charArray[ count ];

      buffer.setCharAt( 0, 'H' );
      buffer.setCharAt( 6, 'T' );
      output += "\n\nbuf = " + buffer.toString();

      buffer.reverse();
      output += "\n\nbuf = " + buffer.toString();

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating StringBuffer Character Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringBufferChars


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
