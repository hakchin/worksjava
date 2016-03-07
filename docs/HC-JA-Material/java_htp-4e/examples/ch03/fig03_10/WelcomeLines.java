// Fig. 3.10: WelcomeLines.java
// Displaying text and lines

// Java core packages
import java.awt.Graphics;    // import class Graphics

// Java extension packages
import javax.swing.JApplet;  // import class JApplet

public class WelcomeLines extends JApplet {  

   // draw lines and a string on applet’s background
   public void paint( Graphics g )
   {
      // call inherited version of method paint
      super.paint( g );

      // draw horizontal line from (15, 10) to (210, 10)
      g.drawLine( 15, 10, 210, 10 ); 

      // draw horizontal line from (15, 30) to (210, 30)
      g.drawLine( 15, 30, 210, 30 ); 

      // draw String between lines at location (25, 25)
      g.drawString( "Welcome to Java Programming!", 25, 25 );

   }  // end method paint

}  // end class WelcomeLines

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