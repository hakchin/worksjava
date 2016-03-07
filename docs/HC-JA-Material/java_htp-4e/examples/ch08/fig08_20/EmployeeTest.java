// Fig. 8.21: EmployeeTest.java
// Test Employee class with static class variable,
// static class method, and dynamic memory.
import javax.swing.*;

public class EmployeeTest {

   // test class Employee
   public static void main( String args[] )
   {
      // prove that count is 0 before creating Employees
      String output = "Employees before instantiation: " +
         Employee.getCount();

      // create two Employees; count should be 2
      Employee e1 = new Employee( "Susan", "Baker" );
      Employee e2 = new Employee( "Bob", "Jones" );
   
      // Prove that count is 2 after creating two Employees.
      // Note: static methods should be called only via the
      // class name for the class in which they are defined.
      output += "\n\nEmployees after instantiation: " +
         "\nvia e1.getCount(): " + e1.getCount() +
         "\nvia e2.getCount(): " + e2.getCount() +
         "\nvia Employee.getCount(): " + Employee.getCount();
   
      // get names of Employees
      output += "\n\nEmployee 1: " + e1.getFirstName() +
         " " + e1.getLastName() + "\nEmployee 2: " + 
         e2.getFirstName() + " " + e2.getLastName();

      // If there is only one reference to each employee (as
      // on this example), the following statements mark 
      // those objects for garbage collection. Otherwise, 
      // these statement simply decrement the reference count
      // for each object.
      e1 = null;  
      e2 = null;  

      System.gc(); // suggest call to garbage collector

      // Show Employee count after calling garbage collector.
      // Count displayed may be 0, 1 or 2 depending on 
      // whether garbage collector executed immediately and 
      // number of Employee objects it collects.
      output += "\n\nEmployees after System.gc(): " +
         Employee.getCount();

      JOptionPane.showMessageDialog( null, output,
         "Static Members and Garbage Collection",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }

}  // end class EmployeeTest

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
