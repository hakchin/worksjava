// Fig. 9.20: HourlyWorker.java
// Definition of class HourlyWorker

public final class HourlyWorker extends Employee {
   private double wage;   // wage per hour
   private double hours;  // hours worked for week

   // constructor for class HourlyWorker
   public HourlyWorker( String first, String last, 
      double wagePerHour, double hoursWorked )
   {
      super( first, last );   // call superclass constructor
      setWage( wagePerHour );
      setHours( hoursWorked );
   }
   
   // Set the wage
   public void setWage( double wagePerHour )
   { 
      wage = ( wagePerHour > 0 ? wagePerHour : 0 ); 
   }
   
   // Set the hours worked
   public void setHours( double hoursWorked )
   { 
      hours = ( hoursWorked >= 0 && hoursWorked < 168 ?
         hoursWorked : 0 ); 
   }
   
   // Get the HourlyWorker's pay
   public double earnings() { return wage * hours; }
   
   public String toString() 
   {
      return "Hourly worker: " + super.toString();
   }

}  // end class HourlyWorker

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
