// Fig. 5.11: BreakTest.java
// Using the break statement in a for structure

// Java extension packages
import javax.swing.JOptionPane;

public class BreakTest {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      String output = "";
      int count;

      // loop 10 times
      for ( count = 1; count <= 10; count++ ) {

         // if count is 5, terminate loop
         if ( count == 5 )
            break;  // break loop only if count == 5

         output += count + " ";

      }  // end for structure

      output += "\nBroke out of loop at count = " + count;
      JOptionPane.showMessageDialog( null, output );

      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class BreakTest



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
