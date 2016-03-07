// Fig. 21.3: CollectionTest.java
// Using the Collection interface

// Java core packages
import java.awt.Color;
import java.util.*;

public class CollectionTest {
   private String colors[] = { "red", "white", "blue" };

   // create ArrayList, add objects to it and manipulate it
   public CollectionTest()
   {
      ArrayList list = new ArrayList();             

      // add objects to list
      list.add( Color.magenta );     // add a color object

      for ( int count = 0; count < colors.length; count++ )
         list.add( colors[ count ] );         

      list.add( Color.cyan );        // add a color object

      // output list contents
      System.out.println( "\nArrayList: " );

      for ( int count = 0; count < list.size(); count++ )
         System.out.print( list.get( count ) + " " );

      // remove all String objects
      removeStrings( list );

      // output list contents
      System.out.println( "\n\nArrayList after calling" +
         " removeStrings: " );

      for ( int count = 0; count < list.size(); count++ )
         System.out.print( list.get( count ) + " " );
   }

   // remove String objects from Collection
   public void removeStrings( Collection collection )
   {
      // get iterator
      Iterator iterator = collection.iterator(); 

      // loop while collection has items
      while ( iterator.hasNext() )         

         if ( iterator.next() instanceof String )
            iterator.remove();  // remove String object
   }

   // execute application
   public static void main( String args[] )
   {
      new CollectionTest();
   } 

}  // end class CollectionTest


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
