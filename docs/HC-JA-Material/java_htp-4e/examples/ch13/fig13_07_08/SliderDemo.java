// Fig. 13.8: SliderDemo.java
// Using JSliders to size an oval.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo extends JFrame {
   private JSlider diameterSlider;
   private OvalPanel myPanel;

   // set up GUI
   public SliderDemo() 
   {
      super( "Slider Demo" );

      // set up OvalPanel
      myPanel = new OvalPanel();
      myPanel.setBackground( Color.yellow );

      // set up JSlider to control diameter value
      diameterSlider =
         new JSlider( SwingConstants.HORIZONTAL, 0, 200, 10 );
      diameterSlider.setMajorTickSpacing( 10 );
      diameterSlider.setPaintTicks( true );

      // register JSlider event listener
      diameterSlider.addChangeListener(

         // anonymous inner class to handle JSlider events
         new ChangeListener() {

            // handle change in slider value
            public void stateChanged( ChangeEvent e )
            {
               myPanel.setDiameter( diameterSlider.getValue() );
            }

         }  // end anonymous inner class

      ); // end call to addChangeListener

      // attach components to content pane
      Container container = getContentPane();
      container.add( diameterSlider, BorderLayout.SOUTH );
      container.add( myPanel, BorderLayout.CENTER );

      setSize( 220, 270 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      SliderDemo application = new SliderDemo();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class SliderDemo

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
