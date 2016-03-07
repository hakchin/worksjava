// Fig. 12.14: ListTest.java
// Selecting colors from a JList.

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class ListTest extends JFrame {
   private JList colorList;
   private Container container;
 
   private String colorNames[] = { "Black", "Blue", "Cyan", 
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow" };

   private Color colors[] = { Color.black, Color.blue, 
      Color.cyan, Color.darkGray, Color.gray, Color.green,
      Color.lightGray, Color.magenta, Color.orange, Color.pink,
      Color.red, Color.white, Color.yellow };

   // set up GUI
   public ListTest()
   {
      super( "List Test" );

      // get content pane and set its layout
      container = getContentPane();
      container.setLayout( new FlowLayout() );

      // create a list with items in colorNames array
      colorList = new JList( colorNames );
      colorList.setVisibleRowCount( 5 );
      
      // do not allow multiple selections
      colorList.setSelectionMode(
         ListSelectionModel.SINGLE_SELECTION );

      // add a JScrollPane containing JList to content pane
      container.add( new JScrollPane( colorList ) );

      // set up event handler
      colorList.addListSelectionListener(

         // anonymous inner class for list selection events
         new ListSelectionListener() {

            // handle list selection events
            public void valueChanged( ListSelectionEvent event )
            {
               container.setBackground(
                  colors[ colorList.getSelectedIndex() ] );
            }

         }  // end anonymous inner class

      ); // end call to addListSelectionListener

      setSize( 350, 150 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   { 
      ListTest application = new ListTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class ListTest

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
