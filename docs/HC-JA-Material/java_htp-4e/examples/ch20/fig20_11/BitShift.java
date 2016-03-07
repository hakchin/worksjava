// Fig. 20.11: BitShift.java
// Using the bitwise shift operators.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class BitShift extends JFrame {
   private JTextField bitsField;
   private JTextField valueField;

   // set up GUI
   public BitShift()
   {
      super( "Shifting bits" );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      container.add( new JLabel( "Integer to shift " ) );

      // textfield for user to input integer
      valueField = new JTextField( 12 );
      container.add( valueField );      

      valueField.addActionListener(

         new ActionListener() {

            // read value and display its bitwise representation
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               bitsField.setText( getBits( value ) );
            }
         }
      );                   
      
      // textfield to display bitwise representation of an integer
      bitsField = new JTextField( 33 );
      bitsField.setEditable( false );
      container.add( bitsField );      

      // button to shift bits left by one position
      JButton leftButton = new JButton( "<<" );

      leftButton.addActionListener(

         new ActionListener() {

            // left shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value <<= 1;
               valueField.setText( Integer.toString( value ) );
               bitsField.setText( getBits( value ) );
            }
         }
      );

      container.add( leftButton );      

      // button to right shift value one position with sign extension
      JButton rightSignButton = new JButton( ">>" );

      rightSignButton.addActionListener(

         new ActionListener() {

            // right shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value >>= 1;
               valueField.setText( Integer.toString( value ) );
               bitsField.setText( getBits( value ) );
            }
         }
      );                    

      container.add( rightSignButton );      

      // button to right shift value one position with zero extension
      JButton rightZeroButton = new JButton( ">>>" );

      rightZeroButton.addActionListener(

         new ActionListener() {

            // right shift one position and display new value
            public void actionPerformed( ActionEvent event )
            {
               int value = Integer.parseInt( valueField.getText() );
               value >>>= 1;
               valueField.setText( Integer.toString( value ) );

               bitsField.setText( getBits( value ) );
            }
         }
      );

      container.add( rightZeroButton );

      setSize( 400, 120 );
      setVisible( true );
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
      BitShift application = new BitShift();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class BitShift

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
