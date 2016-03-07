// Fig. 9.17: Boss.java
// Boss class derived from Employee.

public final class Boss extends Employee {
   private double weeklySalary; 

   // constructor for class Boss
   public Boss( String first, String last, double salary )
   {
      super( first, last );  // call superclass constructor
      setWeeklySalary( salary );
   }
   
   // set Boss's salary
   public void setWeeklySalary( double salary )
   { 
      weeklySalary = ( salary > 0 ? salary : 0 ); 
   }
   
   // get Boss's pay
   public double earnings() 
   { 
      return weeklySalary; 
   }
   
   // get String representation of Boss's name
   public String toString() 
   {
      return "Boss: " + super.toString();
   }

}  // end class Boss

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
