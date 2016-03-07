// Fig. 9.18: CommissionWorker.java
// CommissionWorker class derived from Employee

public final class CommissionWorker extends Employee {
   private double salary;      // base salary per week
   private double commission;  // amount per item sold
   private int quantity;       // total items sold for week

   // constructor for class CommissionWorker
   public CommissionWorker( String first, String last,
      double salary, double commission, int quantity )
   {
      super( first, last );  // call superclass constructor
      setSalary( salary );
      setCommission( commission );
      setQuantity( quantity );
   }
   
   // set CommissionWorker's weekly base salary
   public void setSalary( double weeklySalary )
   { 
      salary = ( weeklySalary > 0 ? weeklySalary : 0 ); 
   }
   
   // set CommissionWorker's commission
   public void setCommission( double itemCommission ) 
   { 
      commission = ( itemCommission > 0 ? itemCommission : 0 );
   }
   
   // set CommissionWorker's quantity sold
   public void setQuantity( int totalSold )
   { 
      quantity = ( totalSold > 0 ? totalSold : 0 ); 
   }
   
   // determine CommissionWorker's earnings
   public double earnings()
   {
      return salary + commission * quantity; 
   }
   
   // get String representation of CommissionWorker's name 
   public String toString() 
   {
      return "Commission worker: " + super.toString();
   }

}  // end class CommissionWorker

   
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
