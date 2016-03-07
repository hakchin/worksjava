// Fig. 12.24: FlowLayoutDemo.java
// Demonstrating FlowLayout alignments.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {
   private JButton leftButton, centerButton, rightButton;
   private Container container;
   private FlowLayout layout;
   
   // set up GUI and register button listeners
   public FlowLayoutDemo()
   {
      super( "FlowLayout Demo" );

      layout = new FlowLayout();

      // get content pane and set its layout
      container = getContentPane();
      container.setLayout( layout );

      // set up leftButton and register listener
      leftButton = new JButton( "Left" );

      leftButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // process leftButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.LEFT );

               // re-align attached components
               layout.layoutContainer( container );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( leftButton );

      // set up centerButton and register listener
      centerButton = new JButton( "Center" );

      centerButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // process centerButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.CENTER );

               // re-align attached components
               layout.layoutContainer( container );
            }
         }
      );

      container.add( centerButton );

      // set up rightButton and register listener
      rightButton = new JButton( "Right" );

      rightButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // process rightButton event  
            public void actionPerformed( ActionEvent event )
            {
               layout.setAlignment( FlowLayout.RIGHT );

               // re-align attached components
               layout.layoutContainer( container );
            }
         }
      );

      container.add( rightButton );

      setSize( 300, 75 );
      setVisible( true );
   }
  
   // execute application
   public static void main( String args[] )
   { 
      FlowLayoutDemo application = new FlowLayoutDemo();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class FlowLayoutDemo


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
