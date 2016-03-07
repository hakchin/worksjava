// Exercise 7.16: WhatDoesThisDo.java

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class WhatDoesThisDo extends JApplet {
   int result;

   public void init()
   {
      int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
   
      result = whatIsThis( array, array.length );

      Container container = getContentPane();
      JTextArea output = new JTextArea();
      output.setText( "Result is: " + result );
      container.add( output );
   }

   public int whatIsThis( int array2[], int size )
   {
      if ( size == 1 )
         return array2[ 0 ];
      else
         return array2[ size - 1 ] + 
            whatIsThis( array2, size - 1 );
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
