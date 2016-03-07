// Fig. 10.3: StringCompare.java
// This program demonstrates the methods equals, 
// equalsIgnoreCase, compareTo, and regionMatches 
// of the String class.

// Java extension packages
import javax.swing.JOptionPane;

public class StringCompare {

   // test String class comparison methods
   public static void main( String args[] )
   {
      String s1, s2, s3, s4, output;

      s1 = new String( "hello" );
      s2 = new String( "good bye" );
      s3 = new String( "Happy Birthday" );
      s4 = new String( "happy birthday" );

      output = "s1 = " + s1 + "\ns2 = " + s2 +
         "\ns3 = " + s3 + "\ns4 = " + s4 + "\n\n";

      // test for equality
      if ( s1.equals( "hello" ) )
         output += "s1 equals \"hello\"\n";
      else
         output += "s1 does not equal \"hello\"\n"; 

      // test for equality with ==
      if ( s1 == "hello" )
         output += "s1 equals \"hello\"\n";
      else
         output += "s1 does not equal \"hello\"\n";

      // test for equality (ignore case)
      if ( s3.equalsIgnoreCase( s4 ) )
         output += "s3 equals s4\n";
      else
         output += "s3 does not equal s4\n";

      // test compareTo
      output +=
         "\ns1.compareTo( s2 ) is " + s1.compareTo( s2 ) +
         "\ns2.compareTo( s1 ) is " + s2.compareTo( s1 ) +
         "\ns1.compareTo( s1 ) is " + s1.compareTo( s1 ) +
         "\ns3.compareTo( s4 ) is " + s3.compareTo( s4 ) +
         "\ns4.compareTo( s3 ) is " + s4.compareTo( s3 ) +
         "\n\n";

      // test regionMatches (case sensitive)
      if ( s3.regionMatches( 0, s4, 0, 5 ) )
         output += "First 5 characters of s3 and s4 match\n";
      else
         output +=
            "First 5 characters of s3 and s4 do not match\n";

      // test regionMatches (ignore case)
      if ( s3.regionMatches( true, 0, s4, 0, 5 ) )
         output += "First 5 characters of s3 and s4 match";
      else
         output +=
            "First 5 characters of s3 and s4 do not match";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class Constructors",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringCompare

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
