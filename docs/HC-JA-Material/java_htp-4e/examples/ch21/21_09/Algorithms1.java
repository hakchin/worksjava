// Fig. 21.9: Algorithms1.java
// Using algorithms reverse, fill, copy, min and max

// Java core packages
import java.util.*;

public class Algorithms1 {
   private String letters[] = { "P", "C", "M" }, lettersCopy[];
   private List list, copyList;

   // create a List and manipulate it with algorithms from 
   // class Collections
   public Algorithms1()
   {
      list = Arrays.asList( letters );     // get List
      lettersCopy = new String[ 3 ];
      copyList = Arrays.asList( lettersCopy );

      System.out.println( "Printing initial statistics: " );
      printStatistics( list );

      Collections.reverse( list );         // reverse order
      System.out.println( "\nPrinting statistics after " +
         "calling reverse: " );
      printStatistics( list );

      Collections.copy( copyList, list );  // copy List
      System.out.println( "\nPrinting statistics after " +
         "copying: " );
      printStatistics( copyList );

      System.out.println( "\nPrinting statistics after " + 
         "calling fill: " );
      Collections.fill( list, "R" );
      printStatistics( list );
   }

   // output List information
   private void printStatistics( List listRef )
   {
      System.out.print( "The list is: " );

      for ( int k = 0; k < listRef.size(); k++ )
         System.out.print( listRef.get( k ) + " " );

      System.out.print( "\nMax: " + Collections.max( listRef ) );
      System.out.println( 
         "  Min: " + Collections.min( listRef ) );
   }

   // execute application
   public static void main( String args[] )
   {
      new Algorithms1();
   } 
                                          
}  // end class Algorithms1


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
