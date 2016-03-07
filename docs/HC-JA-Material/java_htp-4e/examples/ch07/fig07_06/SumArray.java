// Fig. 7.6: SumArray.java
// Total the values of the elements of an array.

// Java extension packages
import javax.swing.*;

public class SumArray {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      int total = 0;

      // add each element's value to total
      for ( int counter = 0; counter < array.length; counter++ )
         total += array[ counter ];

      JOptionPane.showMessageDialog( null, 
         "Total of array elements: " + total,
         "Sum the Elements of an Array",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}

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
