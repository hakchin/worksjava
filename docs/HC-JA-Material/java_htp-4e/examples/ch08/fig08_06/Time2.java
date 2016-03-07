// Fig. 8.6: Time2.java
// Time2 class definition with overloaded constructors.
package com.deitel.jhtp4.ch08;   

// Java core packages
import java.text.DecimalFormat;  

public class Time2 extends Object {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time2 constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time2() 
   { 
      setTime( 0, 0, 0 ); 
   }

   // Time2 constructor: hour supplied, minute and second
   // defaulted to 0
   public Time2( int h ) 
   { 
      setTime( h, 0, 0 ); 
   }

   // Time2 constructor: hour and minute supplied, second
   // defaulted to 0
   public Time2( int h, int m ) 
   { 
      setTime( h, m, 0 );
   }

   // Time2 constructor: hour, minute and second supplied
   public Time2( int h, int m, int s ) 
   { 
      setTime( h, m, s ); 
   }

   // Time2 constructor: another Time2 object supplied
   public Time2( Time2 time )
   {
      setTime( time.hour, time.minute, time.second );
   }

   // Set a new time value using universal time. Perform 
   // validity checks on data. Set invalid values to zero.
   public void setTime( int h, int m, int s )
   {
      hour = ( ( h >= 0 && h < 24 ) ? h : 0 );
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
      second = ( ( s >= 0 && s < 60 ) ? s : 0 );
   }

   // convert to String in universal-time format
   public String toUniversalString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return twoDigits.format( hour ) + ":" +
         twoDigits.format( minute ) + ":" +
         twoDigits.format( second );
   }

   // convert to String in standard-time format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );
      
      return ( (hour == 12 || hour == 0) ? 12 : hour % 12 ) +
         ":" + twoDigits.format( minute ) +
         ":" + twoDigits.format( second ) +
         ( hour < 12 ? " AM" : " PM" );
   }

}  // end class Time2

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
