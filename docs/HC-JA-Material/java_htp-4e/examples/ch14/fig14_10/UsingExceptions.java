// Fig. 14.10: UsingExceptions.java
// Demonstration of stack unwinding.
public class UsingExceptions {

   // execute application
   public static void main( String args[] )
   {
      // call throwException to demonstrate stack unwinding
      try {
         throwException();
      }

      // catch exception thrown in throwException
      catch ( Exception exception ) {
         System.err.println( "Exception handled in main" );
      }
   }

   // throwException throws an exception that is not caught in 
   // the body of this method
   public static void throwException() throws Exception
   {
      // throw an exception and catch it in main
      try {
         System.out.println( "Method throwException" );
         throw new Exception();      // generate exception
      }

      // catch is incorrect type, so Exception not caught
      catch( RuntimeException runtimeException ) {
         System.err.println( 
            "Exception handled in method throwException" );
      }

      // finally block always executes 
      finally {
         System.err.println( "Finally is always executed" );
      }
   }

}  // end class UsingExceptions


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
