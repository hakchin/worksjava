// Fig. 8.17: ThisTest.java
// Using the this reference to refer to 
// instance variables and methods.

// Java core packages
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

public class ThisTest {

   // test class SimpleTime
   public static void main( String args[] )
   {
      SimpleTime time = new SimpleTime( 12, 30, 19 );

      JOptionPane.showMessageDialog( null, time.buildString(),
         "Demonstrating the \"this\" Reference",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class ThisTest

// class SimpleTime demonstrates the "this" reference
class SimpleTime {
   private int hour, minute, second;   

   // constructor uses parameter names identical to instance
   // variable names, so "this" reference required to distinguish
   // between instance variables and parameters
   public SimpleTime( int hour, int minute, int second )
   {
      this.hour = hour;      // set "this" object's hour
      this.minute = minute;  // set "this" object's minute
      this.second = second;  // set "this" object's second
   }

   // call toString explicitly via "this" reference, explicitly
   // via implicit "this" reference, implicitly via "this"
   public String buildString()
   {
      return "this.toString(): " + this.toString() +
         "\ntoString(): " + toString() +
         "\nthis (with implicit toString() call): " + this;
   }

   // convert SimpleTime to String format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );
      
      // "this" not required, because toString does not have
      // local variables with same names as instance variables
      return twoDigits.format( this.hour ) + ":" +
         twoDigits.format( this.minute ) + ":" +
         twoDigits.format( this.second );
   }

}  // end class SimpleTime

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
