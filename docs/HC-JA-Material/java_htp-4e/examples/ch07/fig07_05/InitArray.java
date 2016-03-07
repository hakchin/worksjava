// Fig. 7.5: InitArray.java
// Initialize array with the even integers from 2 to 20.

// Java extension packages
import javax.swing.*;

public class InitArray {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      final int ARRAY_SIZE = 10;
      int array[];                    // reference to int array

      array = new int[ ARRAY_SIZE ];  // allocate array

      // calculate value for each array element
      for ( int counter = 0; counter < array.length; counter++ )
         array[ counter ] = 2 + 2 * counter;

      String output = "Subscript\tValue\n";
   
      for ( int counter = 0; counter < array.length; counter++ )
         output += counter + "\t" + array[ counter ] + "\n";

      JTextArea outputArea = new JTextArea();
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Initializing to Even Numbers from 2 to 20",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
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
