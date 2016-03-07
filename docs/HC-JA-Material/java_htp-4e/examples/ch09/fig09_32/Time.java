// Fig. 9.32: Time.java
// Time class definition.

// Java core packages
import java.text.DecimalFormat;  

// This class maintains the time in 24-hour format
public class Time extends Object {
   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59

   // Time constructor initializes each instance variable
   // to zero. Ensures that Time object starts in a 
   // consistent state.
   public Time() 
   {
      setTime( 0, 0, 0 ); 
   }

   // Set a new time value using universal time. Perform 
   // validity checks on the data. Set invalid values to zero.
   public void setTime( int hour, int minute, int second )
   {
      setHour( hour );      
      setMinute( minute );  
      setSecond( second );  
   }

   // validate and set hour 
   public void setHour( int h ) 
   { 
      hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
   }

   // validate and set minute 
   public void setMinute( int m ) 
   { 
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
   }

   // validate and set second 
   public void setSecond( int s ) 
   {
      second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
   }

   // get hour
   public int getHour()
   {
      return hour;
   }

   // get minute
   public int getMinute()
   {
      return minute;
   }

   // get second
   public int getSecond()
   {
      return second;
   }

   // convert to String in standard-time format
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return ( ( getHour() == 12 || getHour() == 0 ) ? 
         12 : getHour() % 12 ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() ) +
         ( getHour() < 12 ? " AM" : " PM" );
   }

}  // end class Time

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
