// Fig. 9.16: Employee.java
// Abstract base class Employee.

public abstract class Employee {
   private String firstName;
   private String lastName;

   // constructor
   public Employee( String first, String last )
   {
      firstName = first;
      lastName = last;
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

   public String toString()
   { 
      return firstName + ' ' + lastName; 
   }

   // Abstract method that must be implemented for each 
   // derived class of Employee from which objects 
   // are instantiated.
   public abstract double earnings(); 

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
