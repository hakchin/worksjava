// Fig. 13.9: DrawShapes.java
// Draw random lines, rectangles and ovals

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class DrawShapes extends JApplet {
   private JButton choices[];
   private String names[] = { "Line", "Rectangle", "Oval" };
   private JPanel buttonPanel;
   private DrawPanel drawingPanel;
   private int width = 300, height = 200;

   // initialize applet; set up GUI
   public void init()
   {
      // set up DrawPanel
      drawingPanel = new DrawPanel( width, height );

      // create array of buttons
      choices = new JButton[ names.length ];

      // set up panel for buttons
      buttonPanel = new JPanel();
      buttonPanel.setLayout( 
         new GridLayout( 1, choices.length ) );

      // set up buttons and register their listeners
      ButtonHandler handler = new ButtonHandler();

      for ( int count = 0; count < choices.length; count++ ) {
         choices[ count ] = new JButton( names[ count ] );
         buttonPanel.add( choices[ count ] );
         choices[ count ].addActionListener( handler );
      }

      // attach components to content pane
      Container container = getContentPane();
      container.add( buttonPanel, BorderLayout.NORTH );
      container.add( drawingPanel, BorderLayout.CENTER );
   }

   // enables application to specify width of drawing area
   public void setWidth( int newWidth )
   {
      width = ( newWidth >= 0 ? newWidth : 300 ); 
   }

   // enables application to specify height of drawing area
   public void setHeight( int newHeight )
   { 
      height = ( newHeight >= 0 ? newHeight : 200 );
   }

   // execute applet as an application
   public static void main( String args[] )
   {
      int width, height;

      // check for command-line arguments
      if ( args.length != 2 ) {  
         width = 300;
         height = 200;
      }
      else {
         width = Integer.parseInt( args[ 0 ] );
         height = Integer.parseInt( args[ 1 ] );
      }

      // create window in which applet will execute
      JFrame applicationWindow =
         new JFrame( "An applet running as an application" );

      applicationWindow.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );

      // create one applet instance
      DrawShapes appletObject = new DrawShapes();
      appletObject.setWidth( width );
      appletObject.setHeight( height );

      // call applet's init and start methods
      appletObject.init();
      appletObject.start();

      // attach applet to center of window
      applicationWindow.getContentPane().add( appletObject );

      // set the window's size
      applicationWindow.setSize( width, height );

      // showing the window causes all GUI components
      // attached to the window to be painted
      applicationWindow.setVisible( true );
   }

   // private inner class to handle button events
   private class ButtonHandler implements ActionListener {

      // determine button user pressed and set drawing area's 
      // current choice
      public void actionPerformed( ActionEvent event )
      {
         for ( int count = 0; count < choices.length; count++ )

            if ( event.getSource() == choices[ count ] ) {
               drawingPanel.setCurrentChoice( count );
               break;
            }
      }

   }  // end private inner class ButtonHandler

}  // end class DrawShapes

// subclass of JPanel to allow drawing in a separate area
class DrawPanel extends JPanel {
   private int currentChoice = -1;  // don't draw first time
   private int width = 100, height = 100;

   // initialize width and height of DrawPanel
   public DrawPanel( int newWidth, int newHeight )
   {
      width = ( newWidth >= 0 ? newWidth : 100 );
      height = ( newHeight >= 0 ? newHeight : 100 );
   }

   // draw line, rectangle or oval based on user's choice
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      switch( currentChoice ) {

         case 0:
            g.drawLine( randomX(), randomY(),
               randomX(), randomY() );
            break;

         case 1:
            g.drawRect( randomX(), randomY(),
               randomX(), randomY() );
            break;

         case 2:
            g.drawOval( randomX(), randomY(),
               randomX(), randomY() );
            break;
      }

   }  // end method paintComponent

   // specify current shape choice and repaint
   public void setCurrentChoice( int choice )
   {
      currentChoice = choice;
      repaint();
   }

   // pick random x coordinate
   private int randomX()
   { 
      return ( int ) ( Math.random() * width ); 
   }

   // pick random y coordinate
   private int randomY()
   { 
      return ( int ) ( Math.random() * height ); 
   }

}  // end class DrawPanel

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
