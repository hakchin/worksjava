// Fig. 21.13: MapTest.java
// Using a HashMap to store the number of words that
// begin with a given letter

// Java core packages
import java.util.*;

public class MapTest {
   private static String names[] = { "one", "two", "three",
      "four", "five", "six", "seven", "two", "ten", "four" };

   // build a HashMap and output contents
   public MapTest()
   {
      HashMap map = new HashMap();
      Integer i;

      for ( int count = 0; count < names.length; count++ ) {
         i = ( Integer ) map.get( 
            new Character( names[ count ].charAt( 0 ) ) );

         // if key is not in map then give it value one
         // otherwise increment its value by 1
         if ( i == null )
            map.put( 
               new Character( names[ count ].charAt( 0 ) ),
               new Integer( 1 ) );
         else
            map.put( 
               new Character( names[ count ].charAt( 0 ) ),
               new Integer( i.intValue() + 1 ) );
      }

      System.out.println( 
         "\nnumber of words beginning with each letter:    " );
      printMap( map );
   }

   // output map contents
   public void printMap( Map mapRef )
   {
      System.out.println( mapRef.toString() );
      System.out.println( "size: " + mapRef.size() );
      System.out.println( "isEmpty: " + mapRef.isEmpty() );  
   }                     
                               
   // execute application
   public static void main( String args[] )
   {
      new MapTest();
   }                     
                      
}  // end class MapTest


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
