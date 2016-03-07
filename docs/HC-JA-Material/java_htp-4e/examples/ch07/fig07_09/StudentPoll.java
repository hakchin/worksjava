// Fig. 7.9: StudentPoll.java
// Student poll program

// Java extension packages
import javax.swing.*;

public class StudentPoll {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      int responses[] = { 1, 2, 6, 4, 8, 5, 9, 7, 8, 10,
                          1, 6, 3, 8, 6, 10, 3, 8, 2, 7,
                          6, 5, 7, 6, 8, 6, 7, 5, 6, 6,
                          5, 6, 7, 5, 6, 4, 8, 6, 8, 10 };
      int frequency[] = new int[ 11 ];

      // for each answer, select value of an element of 
      // responses array and use that value as subscript in 
      // frequency array to determine element to increment
      for ( int answer = 0; answer < responses.length; answer++ )
         ++frequency[ responses[ answer ] ];

      String output = "Rating\tFrequency\n";
   
      // append frequencies to String output
      for ( int rating = 1; rating < frequency.length; rating++ )
         output += rating + "\t" + frequency[ rating ] + "\n";

      JTextArea outputArea = new JTextArea();
      outputArea.setText( output );

      JOptionPane.showMessageDialog( null, outputArea,
         "Student Poll Program",
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
