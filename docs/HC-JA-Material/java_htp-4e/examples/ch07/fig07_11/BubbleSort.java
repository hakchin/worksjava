// Fig. 7.11: BubbleSort.java
// Sort an array's values into ascending order.

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class BubbleSort extends JApplet {

   // initialize applet 
   public void init()
   {
      JTextArea outputArea = new JTextArea();
      Container container = getContentPane();
      container.add( outputArea );

      int array[] = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };

      String output = "Data items in original order\n";

      // append original array values to String output
      for ( int counter = 0; counter < array.length; counter++ )
         output += "   " + array[ counter ];
 
      bubbleSort( array );  // sort array

      output += "\n\nData items in ascending order\n";

      // append sorted\ array values to String output
      for ( int counter = 0; counter < array.length; counter++ ) 
         output += "   " + array[ counter ];

      outputArea.setText( output );
   }

   // sort elements of array with bubble sort
   public void bubbleSort( int array2[] )
   {   
      // loop to control number of passes
      for ( int pass = 1; pass < array2.length; pass++ ) { 

         // loop to control number of comparisons
         for ( int element = 0; 
               element < array2.length - 1;
               element++ ) {

            // compare side-by-side elements and swap them if 
            // first element is greater than second element
            if ( array2[ element ] > array2[ element + 1 ] )
               swap( array2, element, element + 1 );

         }  // end loop to control comparisons

      }  // end loop to control passes

   }  // end method bubbleSort

   // swap two elements of an array
   public void swap( int array3[], int first, int second )
   {
      int hold;  // temporary holding area for swap

      hold = array3[ first ];         
      array3[ first ] = array3[ second ];  
      array3[ second ] = hold;
   }

}  // end class BubbleSort

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
