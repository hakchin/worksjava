// Fig. 10.15: StringBufferAppend.java
// This program demonstrates the append
// methods of the StringBuffer class.

// Java extension packages
import javax.swing.*;

public class StringBufferAppend {

   // test StringBuffer append methods
   public static void main( String args[] )
   {
      Object o = "hello"; 
      String s = "good bye";  
      char charArray[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
      boolean b = true;
      char c = 'Z';
      int i = 7;
      long l = 10000000;
      float f = 2.5f;
      double d = 33.333;
      StringBuffer buffer = new StringBuffer();

      buffer.append( o );
      buffer.append( "  " );

      buffer.append( s );
      buffer.append( "  " );
      buffer.append( charArray );
      buffer.append( "  " );
      buffer.append( charArray, 0, 3 );
      buffer.append( "  " );
      buffer.append( b );
      buffer.append( "  " );
      buffer.append( c );
      buffer.append( "  " );
      buffer.append( i );
      buffer.append( "  " );
      buffer.append( l );
      buffer.append( "  " );
      buffer.append( f );
      buffer.append( "  " );
      buffer.append( d );

      JOptionPane.showMessageDialog( null,
         "buffer = " + buffer.toString(),
         "Demonstrating StringBuffer append Methods",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end StringBufferAppend

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
