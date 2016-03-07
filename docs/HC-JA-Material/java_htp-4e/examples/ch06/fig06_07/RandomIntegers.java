// Fig. 6.7: RandomIntegers.java
// Shifted, scaled random integers.

// Java extension packages
import javax.swing.JOptionPane;

public class RandomIntegers {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int value;
      String output = "";

      // loop 20 times
      for ( int counter = 1; counter <= 20; counter++ ) {

         // pick random integer between 1 and 6
         value = 1 + ( int ) ( Math.random() * 6 );

         output += value + "  ";  // append value to output
         
         // if counter divisible by 5, 
         // append newline to String output
         if ( counter % 5 == 0 )
            output += "\n";

      }  // end for structure

      JOptionPane.showMessageDialog( null, output,
         "20 Random Numbers from 1 to 6",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class RandomIntegers


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
