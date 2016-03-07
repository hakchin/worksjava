// Fig. 8.9: TimeTest5.java
// Demonstrating the Time3 class set and get methods.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch08.Time3;

public class TimeTest5 extends JApplet
   implements ActionListener {

   private Time3 time;
   private JLabel hourLabel, minuteLabel, secondLabel;
   private JTextField hourField, minuteField,
      secondField, displayField;
   private JButton tickButton;

   // Create Time3 object and set up GUI
   public void init()
   {
      time = new Time3();

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // set up hourLabel and hourField
      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );
      hourField.addActionListener( this );
      container.add( hourLabel );
      container.add( hourField );

      // set up minuteLabel and minuteField
      minuteLabel = new JLabel( "Set minute" );
      minuteField = new JTextField( 10 );
      minuteField.addActionListener( this );
      container.add( minuteLabel );
      container.add( minuteField );

      // set up secondLabel and secondField
      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );
      secondField.addActionListener( this );
      container.add( secondLabel );
      container.add( secondField );

      // set up displayField
      displayField = new JTextField( 30 );
      displayField.setEditable( false );
      container.add( displayField );

      // set up tickButton
      tickButton = new JButton( "Add 1 to Second" );
      tickButton.addActionListener( this );
      container.add( tickButton );

      updateDisplay();  // update text in displayField
   }

   // handle button and text field events
   public void actionPerformed( ActionEvent actionEvent )
   {
      // process tickButton event
      if ( actionEvent.getSource() == tickButton )
         tick();

      // process hourField event
      else if ( actionEvent.getSource() == hourField ) {
         time.setHour(
            Integer.parseInt( actionEvent.getActionCommand() ) );
         hourField.setText( "" );
      }

      // process minuteField event
      else if ( actionEvent.getSource() == minuteField ) {
         time.setMinute(
            Integer.parseInt( actionEvent.getActionCommand() ) );
         minuteField.setText( "" );
      }

      // process secondField event
      else if ( actionEvent.getSource() == secondField ) {
         time.setSecond(
            Integer.parseInt( actionEvent.getActionCommand() ) );
         secondField.setText( "" );
      }

      updateDisplay();  // update displayField and status bar
   }

   // update displayField and applet container's status bar
   public void updateDisplay()
   {
      displayField.setText( "Hour: " + time.getHour() +
         "; Minute: " + time.getMinute() +
         "; Second: " + time.getSecond() );

      showStatus( "Standard time is: " + time.toString() +
         "; Universal time is: " + time.toUniversalString() );
   }

   // add one to second and update hour/minute if necessary 
   public void tick()
   {
      time.setSecond( ( time.getSecond() + 1 ) % 60 );

      if ( time.getSecond() == 0 ) {
         time.setMinute( ( time.getMinute() + 1 ) % 60 );

         if ( time.getMinute() == 0 )
            time.setHour( ( time.getHour() + 1 ) % 24 );
      }
   }

}  // end class TimeTest5

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
