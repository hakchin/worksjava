// Fig. 7.8: RollDie.java
// Roll a six-sided die 6000 times

// Java extension packages
import javax.swing.*;

public class RollDie {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int face, frequency[] = new int[ 7 ];

      // roll die 6000 times
      for ( int roll = 1; roll <= 6000; roll++ ) {
         face = 1 + ( int ) ( Math.random() * 6 );

         // use face value as subscript for frequency array
         ++frequency[ face ];
      }

      String output = "Face\tFrequency";
   
      // append frequencies to String output
      for ( face = 1; face < frequency.length; face++ )
         output += "\n" + face + "\t" + frequency[ face ];

      JTextArea outputArea = new JTextArea();
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Rolling a Die 6000 Times",
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
