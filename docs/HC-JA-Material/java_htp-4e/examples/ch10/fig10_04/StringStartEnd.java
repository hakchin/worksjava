// Fig. 10.4: StringStartEnd.java
// This program demonstrates the methods startsWith and
// endsWith of the String class.

// Java extension packages
import javax.swing.*;

public class StringStartEnd {

   // test String comparison methods for beginning and end 
   // of a String
   public static void main( String args[] )
   {
      String strings[] = 
         { "started", "starting", "ended", "ending" };
      String output = "";

      // test method startsWith
      for ( int count = 0; count < strings.length; count++ )

         if ( strings[ count ].startsWith( "st" ) )
            output += "\"" + strings[ count ] +
               "\" starts with \"st\"\n";

      output += "\n";

      // test method startsWith starting from position
      // 2 of the string
      for ( int count = 0; count < strings.length; count++ )

         if ( strings[ count ].startsWith( "art", 2 ) ) 
            output += "\"" + strings[ count ] +
               "\" starts with \"art\" at position 2\n";

      output += "\n";

      // test method endsWith
      for ( int count = 0; count < strings.length; count++ )

         if ( strings[ count ].endsWith( "ed" ) )
            output += "\"" + strings[ count ] + 
               "\" ends with \"ed\"\n";

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating String Class Comparisons",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class StringStartEnd

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
