// Fig. 14.2: DivideByZeroTest.java
// A simple exception handling example.
// Checking for a divide-by-zero-error.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

public class DivideByZeroTest extends JFrame
   implements ActionListener {

   private JTextField inputField1, inputField2, outputField;
   private int number1, number2;
   private double result;

   // set up GUI
   public DivideByZeroTest()
   {
      super( "Demonstrating Exceptions" );

      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new GridLayout( 3, 2 ) );

      // set up label and inputField1
      container.add( 
         new JLabel( "Enter numerator ", SwingConstants.RIGHT ) );
      inputField1 = new JTextField( 10 );
      container.add( inputField1 );

      // set up label and inputField2; register listener
      container.add( 
         new JLabel( "Enter denominator and press Enter ",
            SwingConstants.RIGHT ) );
      inputField2 = new JTextField( 10 );
      container.add( inputField2 );
      inputField2.addActionListener( this );

      // set up label and outputField
      container.add( 
         new JLabel( "RESULT ", SwingConstants.RIGHT ) );
      outputField = new JTextField();
      container.add( outputField );

      setSize( 425, 100 );
      setVisible( true );
   }

   // process GUI events
   public void actionPerformed( ActionEvent event )
   {
      DecimalFormat precision3 = new DecimalFormat( "0.000" );

      outputField.setText( "" );   // clear outputField

      // read two numbers and calculate quotient
      try {         
         number1 = Integer.parseInt( inputField1.getText() );
         number2 = Integer.parseInt( inputField2.getText() );

         result = quotient( number1, number2 );
         outputField.setText( precision3.format( result ) );
      }

      // process improperly formatted input
      catch ( NumberFormatException numberFormatException ) {
         JOptionPane.showMessageDialog( this,
            "You must enter two integers",
            "Invalid Number Format",
            JOptionPane.ERROR_MESSAGE );
      }

      // process attempts to divide by zero
      catch ( ArithmeticException arithmeticException ) {
         JOptionPane.showMessageDialog( this, 
            arithmeticException.toString(),
            "Arithmetic Exception",
            JOptionPane.ERROR_MESSAGE );
      }
   }

   // method quotient demonstrates throwing an exception
   // when a divide-by-zero error occurs
   public double quotient( int numerator, int denominator )
      throws DivideByZeroException
   {
      if ( denominator == 0 )
         throw new DivideByZeroException();

      return ( double ) numerator / denominator;
   }

   // execute application
   public static void main( String args[] )
   {
      DivideByZeroTest application = new DivideByZeroTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class DivideByZeroTest

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
