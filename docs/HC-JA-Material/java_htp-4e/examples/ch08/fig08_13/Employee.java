// Fig. 8.14: Employee.java
// Definition of class Employee.
package com.deitel.jhtp4.ch08;

public class Employee extends Object {
   private String firstName;
   private String lastName;
   private Date birthDate;
   private Date hireDate;

   // constructor to initialize name, birth date and hire date
   public Employee( String first, String last, 
     int birthMonth, int birthDay, int birthYear, 
     int hireMonth, int hireDay, int hireYear )
   {
      firstName = first;
      lastName = last;
      birthDate = new Date( birthMonth, birthDay, birthYear );
      hireDate = new Date( hireMonth, hireDay, hireYear );
   }

   // convert Employee to String format
   public String toString()
   {
      return lastName + ", " + firstName +
         "  Hired: " + hireDate.toString() +
         "  Birthday: " + birthDate.toString();
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
