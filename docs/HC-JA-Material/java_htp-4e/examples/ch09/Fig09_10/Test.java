// Fig. 9.11: Test.java
// Applet to test class Point

// Java extension packages
import javax.swing.JOptionPane;

// Deitel packages
import com.deitel.jhtp4.ch09.Point;

public class Test {

   // test class Point
   public static void main( String args[] )
   {
      Point point = new Point( 72, 115 );

      // get coordinates
      String output = "X coordinate is " + point.getX() +
               "\nY coordinate is " + point.getY();

      // set coordinates
      point.setPoint( 10, 10 );

      // use implicit call to point.toString()
      output += "\n\nThe new location of point is " + point;

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Class Point",
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
