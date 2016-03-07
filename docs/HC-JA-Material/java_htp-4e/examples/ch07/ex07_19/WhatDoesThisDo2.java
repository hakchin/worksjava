// Exercise 7.19: WhatDoesThisDo2.java

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class WhatDoesThisDo2 extends JApplet {

   public void init()
   {
      int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      JTextArea outputArea = new JTextArea();

      someFunction( array, 0, outputArea );

      Container container = getContentPane();
      container.add( outputArea );
   }
   
   public void someFunction( int array2[], int x, JTextArea out )
   {
      if ( x < array2.length ) {
         someFunction( array2, x + 1, out );
         out.append( array2[ x ] + "  " );
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
