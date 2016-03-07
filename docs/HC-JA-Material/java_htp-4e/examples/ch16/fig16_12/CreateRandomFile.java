// Fig. 16.12: CreateRandomFile.java
// This program creates a random access file sequentially
// by writing 100 empty records to disk.

// Java core packages
import java.io.*;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch16.RandomAccessAccountRecord;

public class CreateRandomFile {

   // enable user to select file to open
   private void createFile()
   {
      // display dialog so user can choose file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showSaveDialog( null );
   
      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();

      // display error if file name invalid
      if ( fileName == null || 
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( null,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {           
            RandomAccessFile file =
               new RandomAccessFile( fileName, "rw" );

            RandomAccessAccountRecord blankRecord = 
               new RandomAccessAccountRecord();

            // write 100 blank records
            for ( int count = 0; count < 100; count++ )
               blankRecord.write( file );

            // close file
            file.close();

            // display message that file was created
            JOptionPane.showMessageDialog( null,
               "Created file " + fileName, "Status",
               JOptionPane.INFORMATION_MESSAGE );

            System.exit( 0 );  // terminate program
         }

         // process exceptions during open, write or 
         // close file operations
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( null,
               "Error processing file", "Error processing file",
               JOptionPane.ERROR_MESSAGE );

            System.exit( 1 );
         }
      }

   }  // end method openFile

   // execute application to create file user specifies
   public static void main( String args[] )
   {
      CreateRandomFile application = new CreateRandomFile();

      application.createFile();
   }   

}  // end class CreateRandomFile


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
