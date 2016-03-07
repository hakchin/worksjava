// Fig. 5.5: Sum.java
// Counter-controlled repetition with the for structure

// Java extension packages
import javax.swing.JOptionPane;

public class Sum {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int sum = 0;

      // sum even integers from 2 through 100
      for ( int number = 2; number <= 100; number += 2 )
         sum += number;

      // display results
      JOptionPane.showMessageDialog( null, "The sum is " + sum,
         "Sum Even Integers from 2 to 100",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );   // terminate the application

   }  // end method main

}  // end class Sum


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

