// Fig. 12.20: MouseDetails.java
// Demonstrating mouse clicks and
// distinguishing between mouse buttons.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class MouseDetails extends JFrame {
   private int xPos, yPos;

   // set title bar String, register mouse listener and size
   // and show window
   public MouseDetails()
   {
      super( "Mouse clicks and buttons" );

      addMouseListener( new MouseClickHandler() ); 

      setSize( 350, 150 );
      setVisible( true );
   }

   // draw String at location where mouse was clicked
   public void paint( Graphics g )
   {
      // call superclass's paint method
      super.paint( g );

      g.drawString( "Clicked @ [" + xPos + ", " + yPos + "]",
         xPos, yPos );
   }

   // execute application
   public static void main( String args[] )
   {
      MouseDetails application = new MouseDetails();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

   // inner class to handle mouse events
   private class MouseClickHandler extends MouseAdapter {

      // handle mouse click event and determine which mouse
      // button was pressed
      public void mouseClicked( MouseEvent event )
      {
         xPos = event.getX();
         yPos = event.getY();

         String title =
            "Clicked " + event.getClickCount() + " time(s)";
      
         // right mouse button
         if ( event.isMetaDown() )      
            title += " with right mouse button";
      
         // middle mouse button
         else if ( event.isAltDown() )  
            title += " with center mouse button";
      
         // left mouse button
         else                           
            title += " with left mouse button";

         setTitle( title );  // set title bar of window
         repaint();
      }

   }  // end private inner class MouseClickHandler

}  // end class MouseDetails




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
