// Fig. 8.18: Time4.java
// Time4 class definition
package com.deitel.jhtp4.ch08;  

// Java core packages
import java.text.DecimalFormat;  

public class Time4 extends Object {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time4 constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time4() 
   { 
      this.setTime( 0, 0, 0 ); 
   }

   // Time4 constructor: hour supplied, minute and second
   // defaulted to 0
   public Time4( int hour ) 
   { 
      this.setTime( hour, 0, 0 ); 
   }

   // Time4 constructor: hour and minute supplied, second
   // defaulted to 0
   public Time4( int hour, int minute ) 
   { 
      this.setTime( hour, minute, 0 ); 
   }

   // Time4 constructor: hour, minute and second supplied
   public Time4( int hour, int minute, int second )
   { 
      this.setTime( hour, minute, second ); 
   }

   // Time4 constructor: another Time4 object supplied.
   public Time4( Time4 time )
   {
      this.setTime( time.getHour(), time.getMinute(),
         time.getSecond() );
   }

   // Set Methods
   // set a new Time value using universal time
   public Time4 setTime( int hour, int minute, int second )
   {
      this.setHour( hour );      // set hour
      this.setMinute( minute );  // set minute
      this.setSecond( second );  // set second

      return this;     // enables chaining
   }

   // validate and set hour 
   public Time4 setHour( int hour ) 
   { 
      this.hour = ( hour >= 0 && hour < 24 ? hour : 0 ); 

      return this;     // enables chaining
   }

   // validate and set minute 
   public Time4 setMinute( int minute ) 
   { 
      this.minute = 
         ( minute >= 0 && minute < 60 ) ? minute : 0;

      return this;     // enables chaining
   }

   // validate and set second 
   public Time4 setSecond( int second ) 
   { 
      this.second = 
         ( second >= 0 && second < 60 ) ? second : 0;

      return this;     // enables chaining
   }

   // Get Methods
   // get value of hour
   public int getHour() { return this.hour; }

   // get value of minute
   public int getMinute() { return this.minute; }

   // get value of second
   public int getSecond() { return this.second; }

   // convert to String in universal-time format
   public String toUniversalString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return twoDigits.format( this.getHour() ) + ":" +
         twoDigits.format( this.getMinute() ) + ":" +
         twoDigits.format( this.getSecond() );
   }

   // convert to String in standard-time format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return ( this.getHour() == 12 || this.getHour() == 0 ?
         12 : this.getHour() % 12 ) + ":" +
         twoDigits.format( this.getMinute() ) + ":" +
         twoDigits.format( this.getSecond() ) +
         ( this.getHour() < 12 ? " AM" : " PM" );
   }

}  // end class Time4

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
