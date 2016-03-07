// Fig. 9.34: TimeTestWindow.java
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

   // set up GUI
   public TimeTestWindow()
   {
      super( "Inner Class Demonstration" );

      // create Time object
      time = new Time();

      // create GUI
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      hourLabel = new JLabel( "Set Hour" );
      hourField = new JTextField( 10 );

      // register hourField event handler
      hourField.addActionListener( 

         // anonymous inner class
         new ActionListener() {  

            public void actionPerformed( ActionEvent event )
            {
               time.setHour(
                  Integer.parseInt( event.getActionCommand() ) );
               hourField.setText( "" );
               displayTime();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( hourLabel );
      container.add( hourField );

      minuteLabel = new JLabel( "Set minute" );
      minuteField = new JTextField( 10 );

      // register minuteField event handler
      minuteField.addActionListener( 

         // anonymous inner class
         new ActionListener() {  

            public void actionPerformed( ActionEvent event )
            {
               time.setMinute(
                  Integer.parseInt( event.getActionCommand() ) );
               minuteField.setText( "" );
               displayTime();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( minuteLabel );
      container.add( minuteField );

      secondLabel = new JLabel( "Set Second" );
      secondField = new JTextField( 10 );

      secondField.addActionListener( 

         // anonymous inner class
         new ActionListener() {  

            public void actionPerformed( ActionEvent event )
            {
               time.setSecond(
                  Integer.parseInt( event.getActionCommand() ) );
               secondField.setText( "" );
               displayTime();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( secondLabel );
      container.add( secondField );

      displayField = new JTextField( 30 );
      displayField.setEditable( false );
      container.add( displayField );
   }

   // display time in displayField
   public void displayTime()
   {
      displayField.setText( "The time is: " + time );
   }

   // create TimeTestWindow, register for its window events
   // and display it to begin application's execution
   public static void main( String args[] )
   {
      TimeTestWindow window = new TimeTestWindow();

      // register listener for windowClosing event
      window.addWindowListener(

         // anonymous inner class for windowClosing event
         new WindowAdapter() {

            // terminate application when user closes window
            public void windowClosing( WindowEvent event )
            {
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

      window.setSize( 400, 120 );
      window.show();
   }

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
