// Fig. 13.15: BoxLayoutDemo.java
// Demonstrating BoxLayout.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class BoxLayoutDemo extends JFrame {

   // set up GUI
   public BoxLayoutDemo()
   {
      super( "Demostrating BoxLayout" );
      final int SIZE = 3;

      Container container = getContentPane();
      container.setLayout( new BorderLayout( 30, 30 ) );

      // create Box containers with BoxLayout
      Box boxes[] = new Box[ 4 ];

      boxes[ 0 ] = Box.createHorizontalBox();
      boxes[ 1 ] = Box.createVerticalBox();
      boxes[ 2 ] = Box.createHorizontalBox();
      boxes[ 3 ] = Box.createVerticalBox();

      // add buttons to boxes[ 0 ]
      for ( int count = 0; count < SIZE; count++ )
         boxes[ 0 ].add( new JButton( "boxes[0]: " + count ) );

      // create strut and add buttons to boxes[ 1 ]
      for ( int count = 0; count < SIZE; count++ ) {
         boxes[ 1 ].add( Box.createVerticalStrut( 25 ) );
         boxes[ 1 ].add( new JButton( "boxes[1]: " + count ) );
      }

      // create horizontal glue and add buttons to boxes[ 2 ]
      for ( int count = 0; count < SIZE; count++ ) {
         boxes[ 2 ].add( Box.createHorizontalGlue() );
         boxes[ 2 ].add( new JButton( "boxes[2]: " + count ) );
      }

      // create rigid area and add buttons to boxes[ 3 ]
      for ( int count = 0; count < SIZE; count++ ) {
         boxes[ 3 ].add(
            Box.createRigidArea( new Dimension( 12, 8 ) ) );
         boxes[ 3 ].add( new JButton( "boxes[3]: " + count ) );
      }

      // create vertical glue and add buttons to panel
      JPanel panel = new JPanel();
      panel.setLayout(
         new BoxLayout( panel, BoxLayout.Y_AXIS ) );

      for ( int count = 0; count < SIZE; count++ ) {
         panel.add( Box.createGlue() );
         panel.add( new JButton( "panel: " + count ) );
      }

      // place panels on frame
      container.add( boxes[ 0 ], BorderLayout.NORTH );
      container.add( boxes[ 1 ], BorderLayout.EAST );
      container.add( boxes[ 2 ], BorderLayout.SOUTH );
      container.add( boxes[ 3 ], BorderLayout.WEST );
      container.add( panel, BorderLayout.CENTER );

      setSize( 350, 300 );
      setVisible( true );

   }  // end constructor

   // execute application
   public static void main( String args[] )
   {
      BoxLayoutDemo application = new BoxLayoutDemo();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class BoxLayoutDemo

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
