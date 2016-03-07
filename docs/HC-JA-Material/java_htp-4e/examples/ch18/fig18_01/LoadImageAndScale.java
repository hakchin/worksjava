// Fig. 18.1: LoadImageAndScale.java
// Load an image and display it in its original size
// and scale it to twice its original width and height.
// Load and display the same image as an ImageIcon.

// Java core packages
import java.applet.Applet;
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class LoadImageAndScale extends JApplet {
   private Image logo1;       
   private ImageIcon logo2;   

   // load image when applet is loaded
   public void init()
   {
      logo1 = getImage( getDocumentBase(), "logo.gif" );
      logo2 = new ImageIcon( "logo.gif" );
   }

   // display image
   public void paint( Graphics g )
   {
      // draw original image
      g.drawImage( logo1, 0, 0, this );

      // draw image scaled to fit width of applet
      // and height of applet minus 120 pixels
      g.drawImage( logo1, 0, 120,
         getWidth(), getHeight() - 120, this );

      // draw icon using its paintIcon method
      logo2.paintIcon( this, g, 180, 0 );
   }

} // end class LoadImageAndScale



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
