// Fig. 8.7: TimeTest4.java
// Using overloaded constructors

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch08.Time2;

public class TimeTest4 {

   // test constructors of class Time2
   public static void main( String args[] )
   {
      Time2 t1, t2, t3, t4, t5, t6;

      t1 = new Time2();               // 00:00:00
      t2 = new Time2( 2 );            // 02:00:00
      t3 = new Time2( 21, 34 );       // 21:34:00
      t4 = new Time2( 12, 25, 42 );   // 12:25:42
      t5 = new Time2( 27, 74, 99 );   // 00:00:00
      t6 = new Time2( t4 );           // 12:25:42

      String output = "Constructed with: " +
         "\nt1: all arguments defaulted" +
         "\n      " + t1.toUniversalString() +
         "\n      " + t1.toString();

      output += "\nt2: hour specified; minute and " +
         "second defaulted" +
         "\n      " + t2.toUniversalString() +
         "\n      " + t2.toString();

      output += "\nt3: hour and minute specified; " +
         "second defaulted" +
         "\n      " + t3.toUniversalString() +
         "\n      " + t3.toString();

      output += "\nt4: hour, minute, and second specified" +
         "\n      " + t4.toUniversalString() +
         "\n      " + t4.toString();

      output += "\nt5: all invalid values specified" +
         "\n      " + t5.toUniversalString() +
         "\n      " + t5.toString();

      output += "\nt6: Time2 object t4 specified" +
         "\n      " + t6.toUniversalString() +
         "\n      " + t6.toString();

      JOptionPane.showMessageDialog( null, output,
         "Demonstrating Overloaded Constructors",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class TimeTest4

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
