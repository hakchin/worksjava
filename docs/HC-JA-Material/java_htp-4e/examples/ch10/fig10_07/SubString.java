// Fig. 10.7: SubString.java
// This program demonstrates the
// String class substring methods.

// Java extension packages
import javax.swing.*;

public class SubString {

   // test String substring methods
   public static void main( String args[] )
   {
      String letters = "abcdefghijklmabcdefghijklm";

      // test substring methods
      String output = "Substring from index 20 to end is " +
         "\"" + letters.substring( 20 ) + "\"\n";

      output += "Substring from index 0 up to 6 is " +
         "\"" + letters.substring( 0, 6 ) + "\"";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class Substring Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class SubString


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
