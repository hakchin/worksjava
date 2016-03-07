// Fig. 9.7: Point.java
// Definition of class Point
public class Point extends Object {
   protected int x, y; // coordinates of the Point

   // no-argument constructor
   public Point() 
   { 
      x = 0;
      y = 0;
      System.out.println( "Point constructor: " + this );
   }

   // constructor
   public Point( int xCoordinate, int yCoordinate ) 
   { 
      x = xCoordinate;
      y = yCoordinate;
      System.out.println( "Point constructor: " + this );
   }

   // finalizer
   protected void finalize() 
   {
      System.out.println( "Point finalizer: " + this );
   }

   // convert Point into a String representation
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
