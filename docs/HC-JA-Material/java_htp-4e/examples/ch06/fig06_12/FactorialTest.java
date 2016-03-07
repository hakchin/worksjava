// Fig. 6.12: FactorialTest.java
// Recursive factorial method

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class FactorialTest extends JApplet {
   JTextArea outputArea;

   // initialize applet by creating GUI and calculating factorials
   public void init()
   {
      outputArea = new JTextArea();

      Container container = getContentPane();
      container.add( outputArea );

      // calculate the factorials of 0 through 10
      for ( long counter = 0; counter <= 10; counter++ )
         outputArea.append( counter + "! = " + 
            factorial( counter ) + "\n" );

   }  // end method init
   
   // Recursive definition of method factorial
   public long factorial( long number )
   {                  
      // base case
      if ( number <= 1 )  
         return 1;

      // recursive step
      else                
         return number * factorial( number - 1 );

   }  // end method factorial

}  // end class FactorialTest

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
