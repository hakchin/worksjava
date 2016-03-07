// Name.java
// Printing "Sean Santry" using Unicode.

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class Name extends JFrame {
   private JLabel uppercase,lowercase;

   // Name constructor
   public Name()
   {
      super( "Demonstrating Name" );

      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new FlowLayout () );

      // JLabel constructor with a string argument
      uppercase = new JLabel( "\u0053\u0045\u0041\u004E\u0020" +
         "\u0053\u0041\u004E\u0054\u0052\u0059" );
      uppercase.setToolTipText( "ALL UPPERCASE" );
      container.add( uppercase );
      
      lowercase = new JLabel( "\u0073\u0065\u0061\u006E\u0020" +
         "\u0073\u0061\u006E\u0074\u0072\u0079" );
      lowercase.setToolTipText( "all lowercase" );
      container.add( lowercase );
      
      setSize( 145, 75 );
      setVisible( true );
      
   } // end Name constructor

   // execute application
   public static void main( String args[] )
   { 
      Name application = new Name();
      
      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
      
   } // end method main

}  // end class Name


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
