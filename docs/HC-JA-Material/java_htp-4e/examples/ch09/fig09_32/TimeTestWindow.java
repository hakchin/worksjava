// Fig. 9.33: TimeTestWindow.java
// Demonstrating the Time class set and get methods

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class TimeTestWindow extends JFrame {
   private Time time;
   private JLabel hourLabel, minuteLabel, secondLabel;
   private JTextField hourField, minuteField,
      secondField, displayField;
   private JButton exitButton;

   // set up GUI
   public TimeTestWindow()
   {
      super( "Inner Class Demonstration" );

      time = new Time();

      // create an instance of inner class ActionEventHandler
      ActionEventHandler handler = new ActionEventHandler();

      // set up GUI
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );
      
      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );
      hourField.addActionListener( handler );
      container.add( hourLabel );
      container.add( hourField );

      minuteLabel = new JLabel( "Set minute" );
      minuteField = new JTextField( 10 );
      minuteField.addActionListener( handler );
      container.add( minuteLabel );
      container.add( minuteField );

      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );
      secondField.addActionListener( handler );
      container.add( secondLabel );
      container.add( secondField );

      displayField = new JTextField( 30 );
      displayField.setEditable( false );
      container.add( displayField );

      exitButton = new JButton( "Exit" );
      exitButton.addActionListener( handler );
      container.add( exitButton );

   }  // end constructor

   // display time in displayField
   public void displayTime()
   {
      displayField.setText( "The time is: " + time );
   }

   // create TimeTestWindow and display it
   public static void main( String args[] )
   {
      TimeTestWindow window = new TimeTestWindow();

      window.setSize( 400, 140 );
      window.show();
   }

   // inner class definition for handling JTextField and 
   // JButton events
   private class ActionEventHandler 
      implements ActionListener {

      // method to handle action events 
      public void actionPerformed( ActionEvent event )
      {
         // user pressed exitButton
         if ( event.getSource() == exitButton )
            System.exit( 0 );   // terminate the application

         // user pressed Enter key in hourField
         else if ( event.getSource() == hourField ) {
            time.setHour(
               Integer.parseInt( event.getActionCommand() ) );
            hourField.setText( "" );
         }

         // user pressed Enter key in minuteField
         else if ( event.getSource() == minuteField ) {
            time.setMinute(
               Integer.parseInt( event.getActionCommand() ) );
            minuteField.setText( "" );
         }

         // user pressed Enter key in secondField
         else if ( event.getSource() == secondField ) {
            time.setSecond(
               Integer.parseInt( event.getActionCommand() ) );
            secondField.setText( "" );
         }

         displayTime();
      }

   }  // end inner class ActionEventHandler

}  // end class TimeTestWindow

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
