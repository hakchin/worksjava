// Fig. 10.13: StringBufferCapLen.java
// This program demonstrates the length and
// capacity methods of the StringBuffer class.

// Java extension packages
import javax.swing.*;

public class StringBufferCapLen {

   // test StringBuffer methods for capacity and length
   public static void main( String args[] )
   {
      StringBuffer buffer =
         new StringBuffer( "Hello, how are you?" );

      String output = "buffer = " + buffer.toString() +
         "\nlength = " + buffer.length() +
         "\ncapacity = " + buffer.capacity();

      buffer.ensureCapacity( 75 );
      output += "\n\nNew capacity = " + buffer.capacity();

      buffer.setLength( 10 );
      output += "\n\nNew length = " + buffer.length() +
         "\nbuf = " + buffer.toString();

      JOptionPane.showMessageDialog( null, output,
         "StringBuffer length and capacity Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringBufferCapLen


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
