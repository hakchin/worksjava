// Fig. 9.22: Shape.java
// Definition of abstract base class Shape

public abstract class Shape extends Object {

   // return shape's area
   public double area() 
   { 
      return 0.0; 
   }

   // return shape's volume
   public double volume() 
   { 
      return 0.0; 
   }

   // abstract method must be defined by concrete subclasses
   // to return appropriate shape name
   public abstract String getName();   

}  // end class Shape

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
