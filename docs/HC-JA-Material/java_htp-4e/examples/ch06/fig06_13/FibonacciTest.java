// Fig. 6.13: FibonacciTest.java
// Recursive fibonacci method

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class FibonacciTest extends JApplet
   implements ActionListener {

   JLabel numberLabel, resultLabel;
   JTextField numberField, resultField;

   // set up applet’s GUI
   public void init()
   {
      // obtain content pane and set its layout to FlowLayout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // create numberLabel and attach it to content pane
      numberLabel = 
         new JLabel( "Enter an integer and press Enter" );
      container.add( numberLabel );

      // create numberField and attach it to content pane
      numberField = new JTextField( 10 );
      container.add( numberField );

      // register this applet as numberField’s ActionListener
      numberField.addActionListener( this );

      // create resultLabel and attach it to content pane
      resultLabel = new JLabel( "Fibonacci value is" );
      container.add( resultLabel );

      // create numberField, make it uneditable
      // and attach it to content pane
      resultField = new JTextField( 15 );
      resultField.setEditable( false );
      container.add( resultField );

   }  // end method init

   // obtain user input and call method fibonacci
   public void actionPerformed( ActionEvent e )
   {  
      long number, fibonacciValue;

      // obtain user’s input and conver to long
      number = Long.parseLong( numberField.getText() );

      showStatus( "Calculating ..." ); 

      // calculate fibonacci value for number user input
      fibonacciValue = fibonacci( number );

      // indicate processing complete and display result
      showStatus( "Done." );   
      resultField.setText( Long.toString( fibonacciValue ) );

   }  // end method actionPerformed
  
   // Recursive definition of method fibonacci
   public long fibonacci( long n )
   {
      // base case
      if ( n == 0 || n == 1 )  
         return n;

      // recursive step
      else
         return fibonacci( n - 1 ) + fibonacci( n - 2 );

   }  // end method fibonacci

}  // end class FibonacciTest

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
