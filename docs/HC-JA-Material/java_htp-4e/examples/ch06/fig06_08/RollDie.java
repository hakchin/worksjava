// Fig. 6.8: RollDie.java
// Roll a six-sided die 6000 times.

// Java extension packages
import javax.swing.*;

public class RollDie {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int frequency1 = 0, frequency2 = 0, frequency3 = 0,
          frequency4 = 0, frequency5 = 0, frequency6 = 0, face;
   
      // summarize results
      for ( int roll = 1; roll <= 6000; roll++ ) {
         face = 1 + ( int ) ( Math.random() * 6 );
   
         // determine roll value and increment appropriate counter
         switch ( face ) {
   
            case 1:
               ++frequency1;
               break; 
   
            case 2:
               ++frequency2;
               break;
   
            case 3:
               ++frequency3;
               break;
   
            case 4:
               ++frequency4;
               break;
   
            case 5:
               ++frequency5;
               break;
   
            case 6:
               ++frequency6;
               break;

         }  // end switch structure

      }  // end for structure

      JTextArea outputArea = new JTextArea();

      outputArea.setText( "Face\tFrequency" +
         "\n1\t" + frequency1 + "\n2\t" + frequency2 +
         "\n3\t" + frequency3 + "\n4\t" + frequency4 +
         "\n5\t" + frequency5 + "\n6\t" + frequency6 );

      JOptionPane.showMessageDialog( null, outputArea,
         "Rolling a Die 6000 Times",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class RollDie

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
