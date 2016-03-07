// Fig. 8.19: TimeTest6.java
// Chaining method calls together with the this reference

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch08.Time4;

public class TimeTest6 {

   // test method call chaining with object of class Time4
   public static void main( String args[] )
   {
      Time4 time = new Time4();

      // chain calls to setHour, setMinute and setSecond
      time.setHour( 18 ).setMinute( 30 ).setSecond( 22 );

      // use method call chaining to set new time and get
      // String representation of new time
      String output = 
         "Universal time: " + time.toUniversalString() +
         "\nStandard time: " + time.toString() +
         "\n\nNew standard time: " +
         time.setTime( 20, 20, 20 ).toString();

      JOptionPane.showMessageDialog( null, output,
         "Chaining Method Calls",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class TimeTest6

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
