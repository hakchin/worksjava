// Fig. 6.16: MethodOverload.java
// Using overloaded methods

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class MethodOverload extends JApplet {

   // set up GUI and call versions of method square
   public void init()
   {
      JTextArea outputArea = new JTextArea();
      Container container = getContentPane();
      container.add( outputArea );

      outputArea.setText(
         "The square of integer 7 is " + square( 7 ) +
         "\nThe square of double 7.5 is " + square( 7.5 ) );
   }
   
   // square method with int argument
   public int square( int intValue )
   {
      System.out.println( 
         "Called square with int argument: " + intValue );

      return intValue * intValue;

   }  // end method square with int argument

   // square method with double argument
   public double square( double doubleValue )
   {
      System.out.println( 
         "Called square with double argument: " + doubleValue );

      return doubleValue * doubleValue;

   }  // end method square with double argument

}  // end class MethodOverload


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
