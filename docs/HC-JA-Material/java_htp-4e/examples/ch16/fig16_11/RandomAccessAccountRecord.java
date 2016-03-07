// Fig. 16.11: RandomAccessAccountRecord.java
// Subclass of AccountRecord for random access file programs.
package com.deitel.jhtp4.ch16;

// Java core packages
import java.io.*;

public class RandomAccessAccountRecord extends AccountRecord {
  
   // no-argument constructor calls other constructor
   // with default values
   public RandomAccessAccountRecord()
   {
      this( 0, "", "", 0.0 );
   }

   // initialize a RandomAccessAccountRecord
   public RandomAccessAccountRecord( int account, 
      String firstName, String lastName, double balance )
   {
      super( account, firstName, lastName, balance );
   }

   // read a record from specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException
   {
      setAccount( file.readInt() );
      setFirstName( padName( file ) );
      setLastName( padName( file ) );
      setBalance( file.readDouble() );
   }

   // ensure that name is proper length
   private String padName( RandomAccessFile file )
      throws IOException
   {
      char name[] = new char[ 15 ], temp;

      for ( int count = 0; count < name.length; count++ ) {
         temp = file.readChar();
         name[ count ] = temp;
      }     
      
      return new String( name ).replace( '\0', ' ' );
   }

   // write a record to specified RandomAccessFile
   public void write( RandomAccessFile file ) throws IOException
   {
      file.writeInt( getAccount() );
      writeName( file, getFirstName() );
      writeName( file, getLastName() );
      file.writeDouble( getBalance() );
   }

   // write a name to file; maximum of 15 characters
   private void writeName( RandomAccessFile file, String name )
      throws IOException
   {
      StringBuffer buffer = null;

      if ( name != null ) 
         buffer = new StringBuffer( name );
      else 
         buffer = new StringBuffer( 15 );

      buffer.setLength( 15 );
      file.writeChars( buffer.toString() );
   }

   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public static int size() 
   { 
      return 72; 
   }

}  // end class RandomAccessAccountRecord

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
