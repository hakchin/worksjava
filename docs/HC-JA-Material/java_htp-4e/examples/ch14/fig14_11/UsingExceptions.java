// Fig. 14.11: UsingExceptions.java
// Demonstrating the getMessage and printStackTrace
// methods inherited into all exception classes.
public class UsingExceptions {

   // execute application
   public static void main( String args[] )
   {
      // call method1 
      try {
         method1();
      }

      // catch Exceptions thrown from method1
      catch ( Exception exception ) {
         System.err.println( exception.getMessage() + "\n" );
         exception.printStackTrace();
      }
   }

   // call method2; throw exceptions back to main
   public static void method1() throws Exception
   {
      method2();
   }

   // call method3; throw exceptions back to method1
   public static void method2() throws Exception
   {
      method3();
   }

   // throw Exception back to method2
   public static void method3() throws Exception
   {
      throw new Exception( "Exception thrown in method3" );
   }

}  // end class Using Exceptions


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
