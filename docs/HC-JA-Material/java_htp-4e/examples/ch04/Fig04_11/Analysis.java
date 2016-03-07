// Fig. 4.11: Analysis.java
// Analysis of examination results.

// Java extension packages
import javax.swing.JOptionPane;

public class Analysis {

   // main method begins execution of Java application
   public static void main( String args[] ) 
   {
      // initializing variables in declarations
      int passes = 0,             // number of passes
          failures = 0,           // number of failures
          student = 1,            // student counter
          result;                 // one exam result
      String input,               // user-entered value
             output;              // output string

      // process 10 students; counter-controlled loop
      while ( student <= 10 ) {

         // obtain result from user
         input = JOptionPane.showInputDialog(
            "Enter result (1=pass,2=fail)" );

         // convert result to int
         result = Integer.parseInt( input );

         // process result
         if ( result == 1 )
            passes = passes + 1;
         else
            failures = failures + 1;

         student = student + 1;
      }

      // termination phase
      output = "Passed: " + passes +
         "\nFailed: " + failures;

      if ( passes > 8 )
         output = output + "\nRaise Tuition";

      JOptionPane.showMessageDialog( null, output,
         "Analysis of Examination Results",
         JOptionPane.INFORMATION_MESSAGE );
      
      System.exit( 0 );  // terminate application

   }  // end method main

}  // end class Analysis


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
