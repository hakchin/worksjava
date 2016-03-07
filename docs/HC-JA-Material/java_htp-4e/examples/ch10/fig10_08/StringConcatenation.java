// Fig. 10.8: StringConcatenation.java
// This program demonstrates the String class concat method.
// Note that the concat method returns a new String object. It
// does not modify the object that invoked the concat method.

// Java extension packages
import javax.swing.*;

public class StringConcatenation {

   // test String method concat
   public static void main( String args[] )
   {
      String s1 = new String( "Happy " ),
             s2 = new String( "Birthday" );

      String output = "s1 = " + s1 + "\ns2 = " + s2;

      output += "\n\nResult of s1.concat( s2 ) = " +
         s1.concat( s2 );

      output += "\ns1 after concatenation = " + s1;

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Method concat",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringConcatenation

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
