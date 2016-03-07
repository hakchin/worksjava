// Fig. 6.3: SquareIntegers.java
// A programmer-defined square method

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class SquareIntegers extends JApplet {

   // set up GUI and calculate squares of integers from 1 to 10
   public void init()
   {
      // JTextArea to display results
      JTextArea outputArea = new JTextArea();

      // get applet's content pane (GUI component display area)
      Container container = getContentPane();

      // attach outputArea to container
      container.add( outputArea ); 

      int result;  // store result of call to method square
      String output = "";  // String containing results

      // loop 10 times
      for ( int counter = 1; counter <= 10; counter++ ) {

         // calculate square of counter and store in result
         result = square( counter );

         // append result to String output 
         output += "The square of " + counter +
                   " is " + result + "\n";

      }  // end for structure

      outputArea.setText( output );  // place results in JTextArea

   }  // end method init
   
   // square method definition 
   public int square( int y )
   {
      return y * y;  // return square of y

   }  // end method square

}  // end class SquareIntegers

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
