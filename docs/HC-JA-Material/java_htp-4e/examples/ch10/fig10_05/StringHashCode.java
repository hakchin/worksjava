// Fig. 10.5: StringHashCode.java1
// This program demonstrates the method 
// hashCode of the String class.

// Java extension packages
import javax.swing.*;

public class StringHashCode {

   // test String hashCode method
   public static void main( String args[] )
   {
      String s1 = "hello", s2 = "Hello";

      String output = 
         "The hash code for \"" + s1 + "\" is " +
         s1.hashCode() + 
         "\nThe hash code for \"" + s2 + "\" is " +
         s2.hashCode();

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Method hashCode",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringHashCode


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
