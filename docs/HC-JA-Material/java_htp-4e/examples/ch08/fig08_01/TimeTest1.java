// Fig. 8.2: TimeTest1.java
// Class TimeTest1 to exercise class Time1

// Java extension packages
import javax.swing.JOptionPane;

public class TimeTest1 {

   // create Time1 object and manipulate it
   public static void main( String args[] )
   {
      Time1 time = new Time1();  // calls Time1 constructor

      // append String version of time to String output
      String output = "The initial universal time is: " +
         time.toUniversalString() + 
         "\nThe initial standard time is: " +  time.toString() +
         "\nImplicit toString() call: " + time;

      // change time and append String version of time to output
      time.setTime( 13, 27, 6 ); 
      output += "\n\nUniversal time after setTime is: " + 
         time.toUniversalString() +
         "\nStandard time after setTime is: " + time.toString();

      // use invalid values to change time and append String 
      // version of time to output
      time.setTime( 99, 99, 99 ); 
      output += "\n\nAfter attempting invalid settings: " + 
         "\nUniversal time: " + time.toUniversalString() +
         "\nStandard time: " + time.toString();

      JOptionPane.showMessageDialog( null, output,
         "Testing Class Time1",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class TimeTest1


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
