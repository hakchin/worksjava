// Fig. 10.11: StringIntern.java
// This program demonstrates the intern method
// of the String class.

// Java extension packages
import javax.swing.*;

public class StringIntern {

   // test String method intern
   public static void main( String args[] )
   {
      String s1, s2, s3, s4, output;

      s1 = new String( "hello" );
      s2 = new String( "hello" );

      // test strings to determine if they are same
      // String object in memory
      if ( s1 == s2 )
         output = "s1 and s2 are the same object in memory";
      else
         output = "s1 and s2 are not the same object in memory";

      // test strings for equality of contents
      if ( s1.equals( s2 ) )
         output += "\ns1 and s2 are equal";
      else
         output += "\ns1 and s2 are not equal";

      // use String intern method to get a unique copy of
      // "hello" referred to by both s3 and s4
      s3 = s1.intern();
      s4 = s2.intern();

      // test strings to determine if they are same
      // String object in memory
      if ( s3 == s4 )
         output += "\ns3 and s4 are the same object in memory";
      else
         output +=
            "\ns3 and s4 are not the same object in memory";

      // determine if s1 and s3 refer to same object
      if ( s1 == s3 )
         output +=
            "\ns1 and s3 are the same object in memory";
      else
         output +=
            "\ns1 and s3 are not the same object in memory";

      // determine if s2 and s4 refer to same object
      if ( s2 == s4 )
         output += "\ns2 and s4 are the same object in memory";
      else
         output += 
            "\ns2 and s4 are not the same object in memory";

      // determine if s1 and s4 refer to same object
      if ( s1 == s4 )
         output += "\ns1 and s4 are the same object in memory";
      else
         output +=
            "\ns1 and s4 are not the same object in memory";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Method intern",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringIntern


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
