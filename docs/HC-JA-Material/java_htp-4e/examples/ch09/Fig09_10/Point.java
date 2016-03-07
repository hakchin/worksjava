// Fig. 9.10: Point.java
// Definition of class Point
package com.deitel.jhtp4.ch09;

public class Point {
   protected int x, y; // coordinates of Point

   // No-argument constructor
   public Point()
   {
      // implicit call to superclass constructor occurs here
      setPoint( 0, 0 );
   }

   // constructor
   public Point( int xCoordinate, int yCoordinate )
   {
      // implicit call to superclass constructor occurs here
      setPoint( xCoordinate, yCoordinate );
   }

   // set x and y coordinates of Point
   public void setPoint( int xCoordinate, int yCoordinate )
   {
      x = xCoordinate;
      y = yCoordinate;
   }

   // get x coordinate
   public int getX() 
   { 
      return x;
   }  

   // get y coordinate
   public int getY() 
   { 
      return y;
   }  

   // convert into a String representation
   public String toString()
   {
      return "[" + x + ", " + y + "]";
   }

}  // end class Point


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
