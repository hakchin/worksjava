// Fig. 19.5: ListTest.java
// Class ListTest

// Deitel packages
import com.deitel.jhtp4.ch19.List;
import com.deitel.jhtp4.ch19.EmptyListException;

public class ListTest {

   // test class List
   public static void main( String args[] )
   {
      List list = new List();  // create the List container

      // create objects to store in List
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use List insert methods
      list.insertAtFront( bool );
      list.print();
      list.insertAtFront( character );
      list.print();
      list.insertAtBack( integer );
      list.print();
      list.insertAtBack( string );
      list.print();

      // use List remove methods
      Object removedObject;

      // remove objects from list; print after each removal
      try {
         removedObject = list.removeFromFront();
         System.out.println(
            removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromFront();
         System.out.println(
            removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromBack();
         System.out.println(
            removedObject.toString() + " removed" );
         list.print();

         removedObject = list.removeFromBack();
         System.out.println(
            removedObject.toString() + " removed" );
         list.print();
      }

      // process exception if List is empty when attempt is 
      // made to remove an item
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }

   }  // end method main

}  // end class ListTest


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
