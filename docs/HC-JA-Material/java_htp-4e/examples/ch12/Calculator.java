// Solution exercise 10.10
// Calculator.java
// This program creates a simple GUI
// html: width = 270 height = 200
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
   private JButton keys[];
   private JPanel keyPad;
   private JTextField lcd;

   public Calculator()
   {
      super("Calculator");

      lcd = new JTextField( 20 );
      keyPad = new JPanel();
      keys = new JButton[ 16 ];

      for ( int i = 0; i <= 9; i++ )
         keys[ i ] = new JButton( String.valueOf( i ) ); 

      keys[ 10 ] = new JButton( "/" );
      keys[ 11 ] = new JButton( "*" );
      keys[ 12 ] = new JButton( "-" );
      keys[ 13 ] = new JButton( "+" );
      keys[ 14 ] = new JButton( "=" );
      keys[ 15 ] = new JButton( "." );

      // set keyPad layout to grid layout
      keyPad.setLayout( new GridLayout( 4, 4 ) );

      for ( int i = 7; i <= 10; i++ ) // 7, 8, 9, 10
         keyPad.add( keys[ i ] );   // divide

      for ( int i = 4; i <= 6; i++ ) // 4, 5, 6
         keyPad.add( keys[ i ] );

      keyPad.add( keys[ 11 ] );    // multiply

      for ( int i = 1; i <= 3; i++ ) // 1, 2, 3
         keyPad.add( keys[ i ] );

      keyPad.add( keys[ 12 ] );    // subtract

      keyPad.add( keys[ 0 ] );     // 0

      for (int i = 15; i >= 13; i--)
         keyPad.add( keys[ i ] );  // ., =, add

      getContentPane().add( lcd, BorderLayout.NORTH );
      getContentPane().add( keyPad, BorderLayout.CENTER );

      setSize( 270, 225 );
      show();
   }

   public static void main( String args[] )
   {
      new Calculator();
   }
}

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
