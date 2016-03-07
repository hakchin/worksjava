// Fig. 5.19: LogicalOperators.java
// Demonstrating the logical operators

// Java extension packages
import javax.swing.*;

public class LogicalOperators {

   // main method begins execution of Java application
   public static void main( String args[] )
   {
      // create JTextArea to display results
      JTextArea outputArea = new JTextArea( 17, 20 );

      // attach JTextArea to a JScrollPane so user can 
      // scroll through results 
      JScrollPane scroller = new JScrollPane( outputArea );

      String output;

      // create truth table for && operator
      output = "Logical AND (&&)" +
         "\nfalse && false: " + ( false && false ) +
         "\nfalse && true: " + ( false && true ) +
         "\ntrue && false: " + ( true && false ) +
         "\ntrue && true: " + ( true && true );

      // create truth table for || operator
      output += "\n\nLogical OR (||)" +
         "\nfalse || false: " + ( false || false ) +
         "\nfalse || true: " + ( false || true ) +
         "\ntrue || false: " + ( true || false ) +
         "\ntrue || true: " + ( true || true );

      // create truth table for & operator
      output += "\n\nBoolean logical AND (&)" +
         "\nfalse & false: " + ( false & false ) +
         "\nfalse & true: " + ( false & true ) +
         "\ntrue & false: " + ( true & false ) +
         "\ntrue & true: " + ( true & true );

      // create truth table for | operator
      output += "\n\nBoolean logical inclusive OR (|)" +
         "\nfalse | false: " + ( false | false ) +
         "\nfalse | true: " + ( false | true ) +
         "\ntrue | false: " + ( true | false ) +
         "\ntrue | true: " + ( true | true );

      // create truth table for ^ operator
      output += "\n\nBoolean logical exclusive OR (^)" +
         "\nfalse ^ false: " + ( false ^ false ) +
         "\nfalse ^ true: " + ( false ^ true ) +
         "\ntrue ^ false: " + ( true ^ false ) +
         "\ntrue ^ true: " + ( true ^ true );

      // create truth table for ! operator
      output += "\n\nLogical NOT (!)" +
         "\n!false: " + ( !false ) + 
         "\n!true: " + ( !true );

      outputArea.setText( output );  // place results in JTextArea

      JOptionPane.showMessageDialog( null, scroller,
         "Truth Tables", JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class LogicalOperators

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
