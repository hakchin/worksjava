// Fig. 20.8: MiscBitOps.java
// Using the bitwise AND, bitwise inclusive OR, bitwise
// exclusive OR, and bitwise complement operators.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class MiscBitOps extends JFrame {
   private JTextField input1Field, input2Field, 
      bits1Field, bits2Field, bits3Field, resultField;
   private int value1, value2;

   // set up GUI
   public MiscBitOps()
   {
      super( "Bitwise operators" );

      JPanel inputPanel = new JPanel();
      inputPanel.setLayout( new GridLayout( 4, 2 ) );

      inputPanel.add( new JLabel( "Enter 2 ints" ) );
      inputPanel.add( new JLabel( "" ) );

      inputPanel.add( new JLabel( "Value 1" ) );
      input1Field = new JTextField( 8 );
      inputPanel.add( input1Field );

      inputPanel.add( new JLabel( "Value 2" ) );
      input2Field = new JTextField( 8 );
      inputPanel.add( input2Field );

      inputPanel.add( new JLabel( "Result" ) );
      resultField = new JTextField( 8 );
      resultField.setEditable( false );
      inputPanel.add( resultField );

      JPanel bitsPanel = new JPanel();
      bitsPanel.setLayout( new GridLayout( 4, 1 ) );
      bitsPanel.add( new JLabel( "Bit representations" ) );

      bits1Field = new JTextField( 33 );
      bits1Field.setEditable( false );
      bitsPanel.add( bits1Field );

      bits2Field = new JTextField( 33 );
      bits2Field.setEditable( false );
      bitsPanel.add( bits2Field );

      bits3Field = new JTextField( 33 );
      bits3Field.setEditable( false );
      bitsPanel.add( bits3Field );

      JPanel buttonPanel = new JPanel();

      // button to perform bitwise AND
      JButton andButton = new JButton( "AND" );

      andButton.addActionListener(

         new ActionListener() {

            // perform bitwise AND and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( 
                  Integer.toString( value1 & value2 ) );
               bits3Field.setText( getBits( value1 & value2 ) );
            }
         }
      );

      buttonPanel.add( andButton );

      // button to perform bitwise inclusive OR
      JButton inclusiveOrButton = new JButton( "Inclusive OR" );

      inclusiveOrButton.addActionListener(

         new ActionListener() {

            // perform bitwise inclusive OR and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( 
                  Integer.toString( value1 | value2 ) );
               bits3Field.setText( getBits( value1 | value2 ) );
            }
         }
      );

      buttonPanel.add( inclusiveOrButton );

      // button to perform bitwise exclusive OR
      JButton exclusiveOrButton = new JButton( "Exclusive OR" );

      exclusiveOrButton.addActionListener(

         new ActionListener() {

            // perform bitwise exclusive OR and display results
            public void actionPerformed( ActionEvent event )
            {
               setFields();
               resultField.setText( 
                  Integer.toString( value1 ^ value2 ) );
               bits3Field.setText( getBits( value1 ^ value2 ) );
            }
         }
      );

      buttonPanel.add( exclusiveOrButton );
               
      // button to perform bitwise complement
      JButton complementButton = new JButton( "Complement" );

      complementButton.addActionListener(

         new ActionListener() {

            // perform bitwise complement and display results
            public void actionPerformed( ActionEvent event )
            {
               input2Field.setText( "" );
               bits2Field.setText( "" );

               int value = Integer.parseInt( input1Field.getText() );

               resultField.setText( Integer.toString( ~value ) );
               bits1Field.setText( getBits( value ) );
               bits3Field.setText( getBits( ~value ) );
            }
         }
      );

      buttonPanel.add( complementButton );

      Container container = getContentPane();
      container.add( inputPanel, BorderLayout.WEST );
      container.add( bitsPanel, BorderLayout.EAST );
      container.add( buttonPanel, BorderLayout.SOUTH );

      setSize( 600, 150 );
      setVisible( true );
   }

   // display numbers and their bit form
   private void setFields()
   {
      value1 = Integer.parseInt( input1Field.getText() );
      value2 = Integer.parseInt( input2Field.getText() );

      bits1Field.setText( getBits( value1 ) );
      bits2Field.setText( getBits( value2 ) );
   }

   // display bit representation of specified int value
   private String getBits( int value )
   {
      // create int value with 1 in leftmost bit and 0s elsewhere
      int displayMask = 1 << 31;

      // buffer to build output
      StringBuffer buffer = new StringBuffer( 35 );

      // for each bit append 0 or 1 to buffer
      for ( int bit = 1; bit <= 32; bit++ ) {

         // use displayMask to isolate bit and determine whether
         // bit has value of 0 or 1
         buffer.append( 
            ( value & displayMask ) == 0 ? '0' : '1' );

         // shift value one position to left 
         value <<= 1;

         // append space to buffer every 8 bits
         if ( bit % 8 == 0 )
            buffer.append( ' ' );
      }

      return buffer.toString();
   }

   // execute application
   public static void main( String args[] )
   {
      MiscBitOps application = new MiscBitOps();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class MiscBitOps

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
