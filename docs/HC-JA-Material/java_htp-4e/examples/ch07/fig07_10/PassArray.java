// Fig. 7.10: PassArray.java
// Passing arrays and individual array elements to methods

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class PassArray extends JApplet {

   // initialize applet 
   public void init()
   {
      JTextArea outputArea = new JTextArea();
      Container container = getContentPane();
      container.add( outputArea );

      int array[] = { 1, 2, 3, 4, 5 };
      
      String output = 
         "Effects of passing entire array by reference:\n" +
         "The values of the original array are:\n";

      // append original array elements to String output 
      for ( int counter = 0; counter < array.length; counter++ )
         output += "   " + array[ counter ];
   
      modifyArray( array );  // array passed by reference
   
      output += "\n\nThe values of the modified array are:\n";

      // append modified array elements to String output 
      for ( int counter = 0; counter < array.length; counter++ )
         output += "   " + array[ counter ];
   
      output += "\n\nEffects of passing array " +
                "element by value:\n" +
                "a[3] before modifyElement: " + array[ 3 ];
   
      // attempt to modify array[ 3 ]
      modifyElement( array[ 3 ] );
   
      output += "\na[3] after modifyElement: " + array[ 3 ];
      outputArea.setText( output );
     
   }  // end method init
   
   // multiply each element of an array by 2 
   public void modifyArray( int array2[] )
   {
      for ( int counter = 0; counter < array2.length; counter++ )
         array2[ counter ] *= 2;
   }
   
   // multiply argument by 2
   public void modifyElement( int element )
   {
      element *= 2;
   }   
     
}  // end class PassArray


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
