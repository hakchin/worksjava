// Fig. 9.12: Circle.java
// Definition of class Circle
package com.deitel.jhtp4.ch09;

public class Circle extends Point {  // inherits from Point
   protected double radius;

   // no-argument constructor
   public Circle()
   {
      // implicit call to superclass constructor occurs here
      setRadius( 0 );  
   }

   // constructor
   public Circle( double circleRadius, int xCoordinate, 
      int yCoordinate )
   {
      // call superclass constructor to set coordinates
      super( xCoordinate, yCoordinate );  

      // set radius
      setRadius( circleRadius );  
   }

   // set radius of Circle
   public void setRadius( double circleRadius ) 
   {
      radius = ( circleRadius >= 0.0 ? circleRadius : 0.0 );
   }

   // get radius of Circle
   public double getRadius() 
   {
      return radius; 
   }

   // calculate area of Circle
   public double area()
   {
      return Math.PI * radius * radius; 
   }

   // convert the Circle to a String
   public String toString()
   {
      return "Center = " + "[" + x + ", " + y + "]" +
             "; Radius = " + radius;
   }

}  // end class Circle


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
