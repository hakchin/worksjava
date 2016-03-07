// Fig. 7.7: Histogram.java
// Histogram printing program.

// Java extension packages
import javax.swing.*;

public class Histogram {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int array[] = { 19, 3, 15, 7, 11, 9, 13, 5, 17, 1 };

      String output = "Element\tValue\tHistogram";

      // for each array element, output a bar in histogram
      for ( int counter = 0; counter < array.length; counter++ ) {
         output += 
            "\n" + counter + "\t" + array[ counter ] + "\t";

         // print bar of asterisks
         for ( int stars = 0; stars < array[ counter ]; stars++ )
            output += "*";
      }

      JTextArea outputArea = new JTextArea();
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Histogram Printing Program",
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
