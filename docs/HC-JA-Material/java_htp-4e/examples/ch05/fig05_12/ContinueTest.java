// Fig. 5.12: ContinueTest.java
// Using the continue statement in a for structure

// Java extension packages
import javax.swing.JOptionPane;

public class ContinueTest {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      String output = "";

      // loop 10 times
      for ( int count = 1; count <= 10; count++ ) {

         // if count is 5, continue with next iteration of loop
         if ( count == 5 )
            continue;  // skip remaining code in loop
                       // only if count == 5

         output += count + " ";

      }  // end for structure

      output += "\nUsed continue to skip printing 5";
      JOptionPane.showMessageDialog( null, output );

      System.exit( 0 );  // terminate application

   } // end method main

}  // end class ContinueTest

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
