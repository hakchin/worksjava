// Fig. 3.8: WelcomeApplet2.java
// Displaying multiple strings in an applet.

// Java core packages
import java.awt.Graphics;    // import class Graphics

// Java extension packages
import javax.swing.JApplet;  // import class JApplet

public class WelcomeApplet2 extends JApplet {  

   // draw text on applet’s background
   public void paint( Graphics g )
   {
      // call inherited version of method paint
      super.paint( g );

      // draw two Strings at different locations
      g.drawString( "Welcome to", 25, 25 );
      g.drawString( "Java Programming!", 25, 40 );

   }  // end method paint

}  // end class WelcomeApplet2

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