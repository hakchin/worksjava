// Fig. 19.11: StackInheritanceTest.java
// Class StackInheritanceTest

// Deitel packages
import com.deitel.jhtp4.ch19.StackInheritance;
import com.deitel.jhtp4.ch19.EmptyListException;

public class StackInheritanceTest {

   // test class StackInheritance
   public static void main( String args[] )
   {
      StackInheritance stack = new StackInheritance();  

      // create objects to store in the stack
      Boolean bool = Boolean.TRUE;
      Character character = new Character( '$' );
      Integer integer = new Integer( 34567 );
      String string = "hello";

      // use push method
      stack.push( bool );
      stack.print();
      stack.push( character );
      stack.print();
      stack.push( integer );
      stack.print();
      stack.push( string );
      stack.print();

      // remove items from stack
      try {

         // use pop method
         Object removedObject = null;

         while ( true ) {
            removedObject = stack.pop();
            System.out.println( removedObject.toString() +
               " popped" );
            stack.print();
         }
      }

      // catch exception if stack empty when item popped
      catch ( EmptyListException emptyListException ) {
         emptyListException.printStackTrace();
      }

   }  // end method main

}  // end class StackInheritanceTest


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
