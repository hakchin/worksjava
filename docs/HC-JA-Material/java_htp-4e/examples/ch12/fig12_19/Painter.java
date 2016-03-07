// Fig. 12.19: Painter.java
// Using class MouseMotionAdapter.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Painter extends JFrame {
   private int xValue = -10, yValue = -10;

   // set up GUI and register mouse event handler
   public Painter()
   {
      super( "A simple paint program" );

      // create a label and place it in SOUTH of BorderLayout
      getContentPane().add(
         new Label( "Drag the mouse to draw" ),
         BorderLayout.SOUTH );

      addMouseMotionListener(

         // anonymous inner class
         new MouseMotionAdapter() {

            // store drag coordinates and repaint
            public void mouseDragged( MouseEvent event )
            {
               xValue = event.getX();
               yValue = event.getY();
               repaint();
            }   
        
         }  // end anonymous inner class

      ); // end call to addMouseMotionListener

      setSize( 300, 150 );  
      setVisible( true );   
   }

   // draw oval in a 4-by-4 bounding box at the specified
   // location on the window
   public void paint( Graphics g )
   {
      // we purposely did not call super.paint( g ) here to 
      // prevent repainting

      g.fillOval( xValue, yValue, 4, 4 );
   }

   // execute application
   public static void main( String args[] )
   {
      Painter application = new Painter();

      application.addWindowListener(
         
         // adapter to handle only windowClosing event
         new WindowAdapter() {
            
            public void windowClosing( WindowEvent event )
            {
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener
   }

}  // end class Painter


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
