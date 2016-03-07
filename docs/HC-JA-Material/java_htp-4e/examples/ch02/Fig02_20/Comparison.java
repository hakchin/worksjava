// Fig. 2.20: Comparison.java
// Compare integers using if structures, relational operators 
// and equality operators.

// Java extension packages
import javax.swing.JOptionPane;

public class Comparison {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      String firstNumber;   // first string entered by user
      String secondNumber;  // second string entered by user
      String result;        // a string containing the output
      int number1;          // first number to compare
      int number2;          // second number to compare

      // read first number from user as a String
      firstNumber =
         JOptionPane.showInputDialog( "Enter first integer:" );

      // read second number from user as a String
      secondNumber =
         JOptionPane.showInputDialog( "Enter second integer:" );
      
      // convert numbers from type String to type int
      number1 = Integer.parseInt( firstNumber );
      number2 = Integer.parseInt( secondNumber );

      // initialize result to empty String
      result = "";

      if ( number1 == number2 )
         result = number1 + " == " + number2;

      if ( number1 != number2 )
         result = number1 + " != " + number2;

      if ( number1 < number2 )
         result = result + "\n" + number1 + " < " + number2;

      if ( number1 > number2 )
         result = result + "\n" + number1 + " > " + number2;

      if ( number1 <= number2 )
         result = result + "\n" + number1 + " <= " + number2;

      if ( number1 >= number2 )
         result = result + "\n" + number1 + " >= " + number2;

      // Display results
      JOptionPane.showMessageDialog(
         null, result, "Comparison Results",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class Comparison


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
