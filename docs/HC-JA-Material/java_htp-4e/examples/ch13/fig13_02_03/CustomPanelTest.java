// Fig. 13.3: CustomPanelTest.java
// Using a customized Panel object.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class CustomPanelTest extends JFrame {
   private JPanel buttonPanel;
   private CustomPanel myPanel;
   private JButton circleButton, squareButton;

   // set up GUI
   public CustomPanelTest()
   {
      super( "CustomPanel Test" );

      // create custom drawing area
      myPanel = new CustomPanel();   
      myPanel.setBackground( Color.green );

      // set up squareButton
      squareButton = new JButton( "Square" );
      squareButton.addActionListener(

         // anonymous inner class to handle squareButton events
         new ActionListener() {

            // draw a square
            public void actionPerformed( ActionEvent event )
            {
               myPanel.draw( CustomPanel.SQUARE );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      circleButton = new JButton( "Circle" );
      circleButton.addActionListener(

         // anonymous inner class to handle circleButton events
         new ActionListener() {

            // draw a circle
            public void actionPerformed( ActionEvent event )
            {
               myPanel.draw( CustomPanel.CIRCLE );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // set up panel containing buttons
      buttonPanel = new JPanel();
      buttonPanel.setLayout( new GridLayout( 1, 2 ) );
      buttonPanel.add( circleButton );
      buttonPanel.add( squareButton );

      // attach button panel & custom drawing area to content pane
      Container container = getContentPane();
      container.add( myPanel, BorderLayout.CENTER );  
      container.add( buttonPanel, BorderLayout.SOUTH );

      setSize( 300, 150 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      CustomPanelTest application = new CustomPanelTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class CustomPanelTest

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
