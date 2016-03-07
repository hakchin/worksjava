// Fig. 10.12: StringBufferConstructors.java
// This program demonstrates the StringBuffer constructors.

// Java extension packages
import javax.swing.*;

public class StringBufferConstructors {

   // test StringBuffer constructors
   public static void main( String args[] )
   {
      StringBuffer buffer1, buffer2, buffer3;
   
      buffer1 = new StringBuffer();
      buffer2 = new StringBuffer( 10 );
      buffer3 = new StringBuffer( "hello" );

      String output =
         "buffer1 = \"" + buffer1.toString() + "\"" +
         "\nbuffer2 = \"" + buffer2.toString() + "\"" +
         "\nbuffer3 = \"" + buffer3.toString() + "\"";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating StringBuffer Class Constructors",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringBufferConstructors


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
