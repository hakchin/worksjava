// Fig. 13.13: DesktopTest.java
// Demonstrating JDesktopPane.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class DesktopTest extends JFrame {
   private JDesktopPane theDesktop;

   // set up GUI
   public DesktopTest()
   {
      super( "Using a JDesktopPane" );

      // create menu bar, menu and menu item
      JMenuBar bar = new JMenuBar();
      JMenu addMenu = new JMenu( "Add" );
      JMenuItem newFrame = new JMenuItem( "Internal Frame" );

      addMenu.add( newFrame );
      bar.add( addMenu );

      setJMenuBar( bar );

      // set up desktop
      theDesktop = new JDesktopPane();
      getContentPane().add( theDesktop );
    
      // set up listener for newFrame menu item
      newFrame.addActionListener(

         // anonymous inner class to handle menu item event
         new ActionListener() {

            // display new internal window
            public void actionPerformed( ActionEvent event ) {

               // create internal frame
               JInternalFrame frame = new JInternalFrame( 
                  "Internal Frame", true, true, true, true );

               // attach panel to internal frame content pane
               Container container = frame.getContentPane();
               MyJPanel panel = new MyJPanel();
               container.add( panel, BorderLayout.CENTER );

               // set size internal frame to size of its contents
               frame.pack();

               // attach internal frame to desktop and show it
               theDesktop.add( frame );
               frame.setVisible( true );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      setSize( 600, 440 );
      setVisible( true );

   }  // end constructor

   // execute application
   public static void main( String args[] )
   {     
      DesktopTest application = new DesktopTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class DesktopTest

// class to display an ImageIcon on a panel
class MyJPanel extends JPanel {
   private ImageIcon imageIcon;

   // load image
   public MyJPanel()
   {
      imageIcon = new ImageIcon( "jhtp4.png" );
   }

   // display imageIcon on panel
   public void paintComponent( Graphics g )
   {
      // call superclass paintComponent method
      super.paintComponent( g );

      // display icon
      imageIcon.paintIcon( this, g, 0, 0 );
   }

   // return image dimensions
   public Dimension getPreferredSize()
   {
      return new Dimension( imageIcon.getIconWidth(),
         imageIcon.getIconHeight() );  
   }

}  // end class MyJPanel

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
