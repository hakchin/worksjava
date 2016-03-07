// Fig. 9.15: Test.java
// Application to test class Cylinder

// Java core packages
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.JOptionPane;

// Deitel packages
import com.deitel.jhtp4.ch09.Cylinder;

public class Test {

   // test class Cylinder
   public static void main( String args[] )
   {
      // create Cylinder
      Cylinder cylinder = new Cylinder( 5.7, 2.5, 12, 23 );
      DecimalFormat precision2 = new DecimalFormat( "0.00" );

      // get coordinates, radius and height
      String output = "X coordinate is " + cylinder.getX() +
         "\nY coordinate is " + cylinder.getY() +
         "\nRadius is " + cylinder.getRadius() +
         "\nHeight is " + cylinder.getHeight();

      // set coordinates, radius and height
      cylinder.setHeight( 10 );
      cylinder.setRadius( 4.25 );
      cylinder.setPoint( 2, 2 );

      // get String representation of Cylinder and calculate
      // area and volume
      output += "\n\nThe new location, radius " +
         "and height of cylinder are\n" + cylinder +
         "\nArea is " + precision2.format( cylinder.area() ) +
         "\nVolume is " + precision2.format( cylinder.volume() );

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Class Cylinder",
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
