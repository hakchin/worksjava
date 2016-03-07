// Fig. 16.14: ReadRandomFile.java 
// This program reads a random-access file sequentially and
// displays the contents one record at a time in text fields.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch16.*;

public class ReadRandomFile extends JFrame {
   private BankUI userInterface;
   private RandomAccessFile input;  
   private JButton nextButton, openButton;
   
   // set up GUI
   public ReadRandomFile()
   {
      super( "Read Client File" );

      // create reusable user interface instance
      userInterface = new BankUI( 4 );  // four textfields
      getContentPane().add( userInterface );

      // configure generic doTask1 button from BankUI
      openButton = userInterface.getDoTask1Button();
      openButton.setText( "Open File for Reading..." );

      // register listener to call openFile when button pressed
      openButton.addActionListener(

         // anonymous inner class to handle openButton event
         new ActionListener() {

            // enable user to select file to open
            public void actionPerformed( ActionEvent event )
            {      
               openFile();
            }

         }  // end anonymous inner class    

      ); // end call to addActionListener  

      // configure generic doTask2 button from BankUI
      nextButton = userInterface.getDoTask2Button();
      nextButton.setText( "Next" );
      nextButton.setEnabled( false );

      // register listener to call readRecord when button pressed
      nextButton.addActionListener(

         // anonymous inner class to handle nextButton event
         new ActionListener() {

            // read a record when user clicks nextButton
            public void actionPerformed( ActionEvent event )
            {
               readRecord();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
   
      // register listener for window closing event
      addWindowListener(

         // anonymous inner class to handle windowClosing event
         new WindowAdapter() {

            // close file and terminate application
            public void windowClosing( WindowEvent event )
            {
               closeFile();
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

      setSize( 300, 150 );
      show();  
   }
   
   // enable user to select file to open
   private void openFile()
   {
      // display file dialog so user can select file
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );
   
      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();

      // display error is file name invalid
      if ( fileName == null ||
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {
            input = new RandomAccessFile( fileName, "r" );
            nextButton.setEnabled( true );
            openButton.setEnabled( false );
         }

         // catch exception while opening file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
               "File does not exist", "Invalid File Name",
               JOptionPane.ERROR_MESSAGE );
         }      
      }

   }  // end method openFile
   
   // read one record
   public void readRecord()
   {
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );
      RandomAccessAccountRecord record = 
         new RandomAccessAccountRecord();
   
      // read a record and display
      try {

         do {
            record.read( input );
         } while ( record.getAccount() == 0 );

         String values[] = {
            String.valueOf( record.getAccount() ),
            record.getFirstName(),
            record.getLastName(),
            String.valueOf( record.getBalance() ) };
         userInterface.setFieldValues( values );
      }

      // close file when end-of-file reached
      catch ( EOFException eofException ) {
         JOptionPane.showMessageDialog( this, "No more records",
            "End-of-file reached", 
            JOptionPane.INFORMATION_MESSAGE );
         closeFile();
      }

      // process exceptions from problem with file
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error Reading File", "Error",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }

   }  // end method readRecord
   
   // close file and terminate application
   private void closeFile() 
   {
      // close file and exit
      try {
         if ( input != null )
            input.close();

         System.exit( 0 );
      }

      // process exception closing file
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }
   }
      
   // execute application
   public static void main( String args[] )
   {
      new ReadRandomFile();
   }

}  // end class ReadRandomFile

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
