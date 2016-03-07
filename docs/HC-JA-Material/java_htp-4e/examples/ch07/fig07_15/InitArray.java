// Fig. 7.15: InitArray.java
// Initializing multidimensional arrays

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class InitArray extends JApplet {
   JTextArea outputArea;

   // set up GUI and initialize applet
   public void init()
   {
      outputArea = new JTextArea();
      Container container = getContentPane();
      container.add( outputArea );

      int array1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };        
      int array2[][] = { { 1, 2 }, { 3 }, { 4, 5, 6 } }; 

      outputArea.setText( "Values in array1 by row are\n" );
      buildOutput( array1 );
   
      outputArea.append( "\nValues in array2 by row are\n" );
      buildOutput( array2 );
   }

   // append rows and columns of an array to outputArea
   public void buildOutput( int array[][] )
   {
      // loop through array's rows
      for ( int row = 0; row < array.length; row++ ) {

         // loop through columns of current row
         for ( int column = 0; 
               column < array[ row ].length; 
               column++ )
            outputArea.append( array[ row ][ column ] + "  " );

         outputArea.append( "\n" );
      }
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
