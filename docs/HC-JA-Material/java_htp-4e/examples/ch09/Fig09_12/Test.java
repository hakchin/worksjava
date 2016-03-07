// Fig. 9.13: Test.java
// Applet to test class Circle

// Java core packages
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.JOptionPane;

// Deitel packages
import com.deitel.jhtp4.ch09.Circle;

public class Test {

   // test class Circle
   public static void main( String args[] )
   {
      // create a Circle
      Circle circle = new Circle( 2.5, 37, 43 );
      DecimalFormat precision2 = new DecimalFormat( "0.00" );

      // get coordinates and radius
      String output = "X coordinate is " + circle.getX() +
               "\nY coordinate is " + circle.getY() +
               "\nRadius is " + circle.getRadius();

      // set coordinates and radius
      circle.setRadius( 4.25 );
      circle.setPoint( 2, 2 );

      // get String representation of Circle and calculate area
      output +=
         "\n\nThe new location and radius of c are\n" + circle +
         "\nArea is " + precision2.format( circle.area() );

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Class Circle",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class Test


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
