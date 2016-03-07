// Fig. 13.11: PopupTest.java
// Demonstrating JPopupMenus

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class PopupTest extends JFrame {

   private JRadioButtonMenuItem items[];
   private Color colorValues[] = 
      { Color.blue, Color.yellow, Color.red };

   private JPopupMenu popupMenu;

   // set up GUI
   public PopupTest()
   {
      super( "Using JPopupMenus" );

      ItemHandler handler = new ItemHandler();
      String colors[] = { "Blue", "Yellow", "Red" };

      // set up popup menu and its items
      ButtonGroup colorGroup = new ButtonGroup();
      popupMenu = new JPopupMenu();
      items = new JRadioButtonMenuItem[ 3 ];

      // construct each menu item and add to popup menu; also
      // enable event handling for each menu item
      for ( int count = 0; count < items.length; count++ ) {
         items[ count ] = 
            new JRadioButtonMenuItem( colors[ count ] );

         popupMenu.add( items[ count ] );
         colorGroup.add( items[ count ] );

         items[ count ].addActionListener( handler );
      }

      getContentPane().setBackground( Color.white );

      // define a MouseListener for the window that displays
      // a JPopupMenu when the popup trigger event occurs
      addMouseListener(

         // anonymous inner class to handle mouse events
         new MouseAdapter() {

            // handle mouse press event
            public void mousePressed( MouseEvent event )
            { 
               checkForTriggerEvent( event ); 
            } 

            // handle mouse release event
            public void mouseReleased( MouseEvent event )
            { 
               checkForTriggerEvent( event ); 
            } 

            // determine whether event should trigger popup menu
            private void checkForTriggerEvent( MouseEvent event )
            {
               if ( event.isPopupTrigger() ) 
                  popupMenu.show( event.getComponent(),
                     event.getX(), event.getY() );  
            }

         }  // end anonymous inner clas

      ); // end call to addMouseListener

      setSize( 300, 200 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      PopupTest application = new PopupTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

   // private inner class to handle menu item events
   private class ItemHandler implements ActionListener {

      // process menu item selections
      public void actionPerformed( ActionEvent event )
      {
         // determine which menu item was selected
         for ( int i = 0; i < items.length; i++ )
            if ( event.getSource() == items[ i ] ) {
               getContentPane().setBackground(
                  colorValues[ i ] );
               repaint();
               return;
            }
      }

   }  // end private inner class ItemHandler

}  // end class PopupTest

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
