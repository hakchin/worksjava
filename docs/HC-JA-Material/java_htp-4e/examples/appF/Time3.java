// Fig. F.2: Time3.java
// Time3 class definition with set and get methods
package com.deitel.jhtp4.appenF;   

// Java core packages
import java.text.DecimalFormat;  

/** 
 * This class maintains the time in 24-hour format.
 * @see java.lang.Object
 * @author Deitel & Associates, Inc.
 */
public class Time3 extends Object {

   private int hour;     // 0 - 23
   private int minute;   // 0 - 59
   private int second;   // 0 - 59


   /** 
    * Time3 constructor initializes each instance variable
    * to zero. Ensures that Time object starts in a 
    * consistent state.
    * @throws <code>Exception</code> in the case of an invalid time
    */   
   public Time3() throws Exception
   { 
      setTime( 0, 0, 0 ); 
   }
    

   /** 
    * Time3 constructor: hour supplied, minute and second
    * defaulted to 0
    * @param h the hour
    * @throws <code>Exception</code> in the case of an invalid time
    */  
   public Time3( int h ) throws Exception 
   { 
      setTime( h, 0, 0 ); 
   }

   /** 
    * Time3 constructor: hour and minute supplied, second
    * defaulted to 0
    * @param h the hour
    * @param m the minute
    * @throws <code>Exception</code> in the case of an invalid time
    */   
   public Time3( int h, int m ) throws Exception 
   { 
      setTime( h, m, 0 ); 
   }

   /**
    * Time3 constructor: hour, minute and second supplied
    * @param h the hour
    * @param m the minute
    * @param s the second
    * @throws <code>Exception</code> in the case of an invalid time
    */
   public Time3( int h, int m, int s ) throws Exception
   { 
      setTime( h, m, s ); 
   }

   /**
    * Time3 constructor: another Time3 object supplied
    * @param time Time3 object
    * @throws <code>Exception</code> in the case of an invalid time
    */
   public Time3( Time3 time ) throws Exception
   {
      setTime( time.getHour(), time.getMinute(),
         time.getSecond() );
   }

   // Set Methods
   /**
    * Set a new time value using universal time. Perform 
    * validity checks on data. Set invalid values to zero.
    * @param h the hour
    * @param m the minute
    * @param s the second
    * @see com.deitel.jhtp4.appenF.Time3#setHour
    * @see Time3#setMinute
    * @see #setSecond
    * @throws <code>Exception</code> in the case of an invalid time 
    */
   public void setTime( int h, int m, int s ) throws Exception
   {
      setHour( h );    // set the hour
      setMinute( m );  // set the minute
      setSecond( s );  // set the second
   }

   /** 
    * Sets the hour 
    * @param h the hour
    * @throws Exception in the case of an invalid time
    */
   public void setHour( int h ) throws Exception
   { 
      if ( h >= 0 && h < 24 )
          hour = h;
      else 
          throw( new Exception() );
   }

   /**
    * Sets the minute 
    * @param m the minute
    * @throws Exception in the case of an invalid time
    */
    public void setMinute( int m ) throws Exception
   { 
      if ( m >= 0 && h < 60 )
          minute = m;
      else 
          throw( new Exception() );
   }

   /**
    * Sets the second
    * @param m the minute
    * @throws Exception in the case of an invalid time
    */
    public void setSecond( int s ) throws Exception
   { 
      if ( s >= 0 && s < 60 )
          second = s;
      else 
          throw( new Exception() );
   }

   // Get Methods
   /**
    * Gets the hour
    * @return an <code>int</code> specifying the hour.
    */
   public int getHour() 
   { 
      return hour; 
   }
   /**
    * Gets the minute
    * @return an <code>int</code> specifying the minute.
    */
   public int getMinute() 
   { 
      return minute; 
   }

   /**
    * Gets the second
    * @return an <code>int</code> specifying the second.
    */
   public int getSecond() 
   { 
      return second; 
   }
    
   /** 
    * Convert to <code>String</code> in universal-time format
    * @return a <code>String</code> representation
    * of the time in universal-time format
    */
   public String toUniversalString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return twoDigits.format( getHour() ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() );
   }

   /** 
    * Convert to <code>String</code> in standard-time format
    * @return a <code>String</code> representation
    * of the time in standard-time format
    */
   public String toString()
   {
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      return ( ( getHour() == 12 || getHour() == 0 ) ? 
         12 : getHour() % 12 ) + ":" +
         twoDigits.format( getMinute() ) + ":" +
         twoDigits.format( getSecond() ) +
         ( getHour() < 12 ? " AM" : " PM" );
   }

} 

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
