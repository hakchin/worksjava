// Fig. 14.9: UsingExceptions.java
// Demonstration of the try-catch-finally 
// exception handling mechanism.
public class UsingExceptions {

   // execute application
   public static void main( String args[] )
   {
      // call method throwException
      try {
         throwException();
      }

      // catch Exceptions thrown by method throwException
      catch ( Exception exception )
      {
         System.err.println( "Exception handled in main" );
      }

      doesNotThrowException();
   }

   // demonstrate try/catch/finally
   public static void throwException() throws Exception
   {
      // throw an exception and immediately catch it
      try {
         System.out.println( "Method throwException" );
         throw new Exception();  // generate exception
      }

      // catch exception thrown in try block
      catch ( Exception exception )
      {
         System.err.println(
            "Exception handled in method throwException" );
         throw exception;  // rethrow for further processing

         // any code here would not be reached
      }

      // this block executes regardless of what occurs in 
      // try/catch
      finally {
         System.err.println( 
            "Finally executed in throwException" );
      }

      // any code here would not be reached
   }

   // demonstrate finally when no exception occurs
   public static void doesNotThrowException()
   {
      // try block does not throw an exception
      try {
         System.out.println( "Method doesNotThrowException" );
      }

      // catch does not execute, because no exception thrown
      catch( Exception exception )
      {
         System.err.println( exception.toString() );
      }

      // this block executes regardless of what occurs in 
      // try/catch
      finally {
         System.err.println(
            "Finally executed in doesNotThrowException" );
      }

      System.out.println( 
         "End of method doesNotThrowException" );
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
