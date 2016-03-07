// Fig. 10.16: StringBufferInsert.java
// This program demonstrates the insert and delete
// methods of class StringBuffer.

// Java extension packages
import javax.swing.*;

public class StringBufferInsert {

   // test StringBuffer insert methods
   public static void main( String args[] )
   {
      Object o = "hello";  
      String s = "good bye";  
      char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
      boolean b = true;
      char c = 'K';
      int i = 7;
      long l = 10000000;
      float f = 2.5f;
      double d = 33.333;
      StringBuffer buffer = new StringBuffer();

      buffer.insert( 0, o );
      buffer.insert( 0, "  " );
      buffer.insert( 0, s );
      buffer.insert( 0, "  " );
      buffer.insert( 0, charArray );
      buffer.insert( 0, "  " );
      buffer.insert( 0, b );
      buffer.insert( 0, "  " );
      buffer.insert( 0, c );
      buffer.insert( 0, "  " );
      buffer.insert( 0, i );
      buffer.insert( 0, "  " );
      buffer.insert( 0, l );
      buffer.insert( 0, "  " );
      buffer.insert( 0, f );
      buffer.insert( 0, "  " );
      buffer.insert( 0, d );

      String output = 
         "buffer after inserts:\n" + buffer.toString();

      buffer.deleteCharAt( 10 );  // delete 5 in 2.5
      buffer.delete( 2, 6 );      // delete .333 in 33.333

      output += 
         "\n\nbuffer after deletes:\n" + buffer.toString();

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating StringBufferer Inserts and Deletes",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringBufferInsert

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
