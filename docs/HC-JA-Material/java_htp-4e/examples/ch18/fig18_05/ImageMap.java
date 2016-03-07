// Fig. 18.5: ImageMap.java
// Demonstrating an image map.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class ImageMap extends JApplet {
   private ImageIcon mapImage;

   private String captions[] = { "Common Programming Error",
      "Good Programming Practice", 
      "Graphical User Interface Tip", "Performance Tip", 
      "Portability Tip", "Software Engineering Observation",
      "Testing and Debugging Tip" };

   // set up mouse listeners
   public void init()
   {
      addMouseListener(

         new MouseAdapter() {

            // indicate when mouse pointer exits applet area
            public void mouseExited( MouseEvent event )
            {
               showStatus( "Pointer outside applet" );
            }

         }  // end anonymous inner class

      ); // end addMouseListener method call

      addMouseMotionListener(

         new MouseMotionAdapter() {

            // determine icon over which mouse appears
            public void mouseMoved( MouseEvent event )
            {
               showStatus( translateLocation( 
                  event.getX(), event.getY() ) );
            }

         }  // end anonymous inner class

      ); // end addMouseMotionListener method call

      mapImage = new ImageIcon( "icons.png" ); 

   }  // end method init

   // display mapImage
   public void paint( Graphics g )
   {
      mapImage.paintIcon( this, g, 0, 0 );
   }

   // return tip caption based on mouse coordinates
   public String translateLocation( int x, int y )
   {
      // if coordinates outside image, return immediately
      if ( x >= mapImage.getIconWidth() || 
           y >= mapImage.getIconHeight() ) 
         return "";

      // determine icon number (0 - 6)
      int iconWidth = mapImage.getIconWidth() / 7;
      int iconNumber = x / iconWidth;

      // return appropriate icon caption
      return captions[ iconNumber ];
   }

}  // end class ImageMap

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
