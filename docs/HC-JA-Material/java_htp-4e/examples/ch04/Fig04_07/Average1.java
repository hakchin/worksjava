// Fig. 4.7: Average1.java
// Class average program with counter-controlled repetition.

// Java extension packages
import javax.swing.JOptionPane;

public class Average1 {

   // main method begins execution of Java application
   public static void main( String args[] ) 
   {
      int total,          // sum of grades input by user
          gradeCounter,   // number of grades entered
          gradeValue,     // grade value
          average;        // average of all grades
      String grade;       // grade typed by user
   
      // Initialization Phase
      total = 0;          // clear total
      gradeCounter = 1;   // prepare to loop
   
      // Processing Phase
      while ( gradeCounter <= 10 ) {  // loop 10 times

         // prompt for input and read grade from user
         grade = JOptionPane.showInputDialog(
            "Enter integer grade: " );

         // convert grade from a String to an integer
         gradeValue = Integer.parseInt( grade );

         // add gradeValue to total
         total = total + gradeValue;  

         // add 1 to gradeCounter
         gradeCounter = gradeCounter + 1;

      }  // end while structure
   
      // Termination Phase
      average = total / 10;  // perform integer division

      // display average of exam grades
      JOptionPane.showMessageDialog( null, 
         "Class average is " + average, "Class Average",
         JOptionPane.INFORMATION_MESSAGE );

       System.exit( 0 );     // terminate the program

   }  // end method main

}  // end class Average1

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