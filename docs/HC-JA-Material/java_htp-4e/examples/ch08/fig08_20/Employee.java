// Fig. 8.20: Employee.java
// Employee class definition.
public class Employee extends Object {
   private String firstName;
   private String lastName;
   private static int count;  // number of objects in memory

   // initialize employee, add 1 to static count and 
   // output String indicating that constructor was called
   public Employee( String first, String last )
   {
      firstName = first;
      lastName = last;

      ++count;  // increment static count of employees
      System.out.println( "Employee object constructor: " +
         firstName + " " + lastName );
   }

   // subtract 1 from static count when garbage collector
   // calls finalize to clean up object and output String
   // indicating that finalize was called
   protected void finalize()
   {
      --count;  // decrement static count of employees
      System.out.println( "Employee object finalizer: " +
         firstName + " " + lastName + "; count = " + count );
   }

   // get first name
   public String getFirstName() 
   { 
      return firstName; 
   }

   // get last name
   public String getLastName() 
   { 
      return lastName; 
   }

   // static method to get static count value
   public static int getCount() 
   { 
      return count; 
   } 

}  // end class Employee

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
