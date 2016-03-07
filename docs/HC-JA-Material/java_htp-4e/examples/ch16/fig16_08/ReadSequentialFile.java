// Fig. 16.8: ReadSequentialFile.java
// This program reads a file of objects sequentially
// and displays each record.

// Java core packages
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch16.*;

public class ReadSequentialFile extends JFrame {
   private ObjectInputStream input;
   private BankUI userInterface;
   private JButton nextButton, openButton;

   // Constructor -- initialize the Frame 
   public ReadSequentialFile()
   {
      super( "Reading a Sequential File of Objects" );

      // create instance of reusable user interface
      userInterface = new BankUI( 4 );  // four textfields
      getContentPane().add( 
         userInterface, BorderLayout.CENTER );

      // get reference to generic task button doTask1 from BankUI
      openButton = userInterface.getDoTask1Button();
      openButton.setText( "Open File" );

      // register listener to call openFile when button pressed
      openButton.addActionListener(

         // anonymous inner class to handle openButton event
         new ActionListener() {

            // close file and terminate application
            public void actionPerformed( ActionEvent event )
            {
               openFile();
            }

         }  // end anonymous inner class
 
      ); // end call to addActionListener
      
      // register window listener for window closing event
      addWindowListener(

         // anonymous inner class to handle windowClosing event
         new WindowAdapter() {

            // close file and terminate application
            public void windowClosing( WindowEvent event )
            {
               if ( input != null )
                  closeFile();

               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

      // get reference to generic task button doTask2 from BankUI
      nextButton = userInterface.getDoTask2Button();
      nextButton.setText( "Next Record" );
      nextButton.setEnabled( false );  
 
      // register listener to call readRecord when button pressed
      nextButton.addActionListener(

         // anonymous inner class to handle nextRecord event
         new ActionListener() {

            // call readRecord when user clicks nextRecord
            public void actionPerformed( ActionEvent event )
            {               
               readRecord();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener
 
      pack();
      setSize( 300, 200 );
      show();

   }  // end ReadSequentialFile constructor

   // enable user to select file to open
   private void openFile()
   {
      // display file dialog so user can select file to open
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );
 
      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // obtain selected file
      File fileName = fileChooser.getSelectedFile();
 
      // display error if file name invalid
      if ( fileName == null ||
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {
            input = new ObjectInputStream(
               new FileInputStream( fileName ) );

            openButton.setEnabled( false );
            nextButton.setEnabled( true );
         }

         // process exceptions opening file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
               "Error Opening File", "Error",
               JOptionPane.ERROR_MESSAGE );
         }      

      }  // end else

   }  // end method openFile

   // read record from file
   public void readRecord()
   {
      AccountRecord record;

      // input the values from the file
      try {
         record = ( AccountRecord ) input.readObject();

         // create array of Strings to display in GUI
         String values[] = {
            String.valueOf( record.getAccount() ),
            record.getFirstName(),
            record.getLastName(),
            String.valueOf( record.getBalance() ) };

         // display record contents
         userInterface.setFieldValues( values );
      }

      // display message when end-of-file reached
      catch ( EOFException endOfFileException ) {
         nextButton.setEnabled( false );

         JOptionPane.showMessageDialog( this,
            "No more records in file",
            "End of File", JOptionPane.ERROR_MESSAGE );
      }

      // display error message if cannot read object 
      // because class not found
      catch ( ClassNotFoundException classNotFoundException ) {
         JOptionPane.showMessageDialog( this,
            "Unable to create object",
            "Class Not Found", JOptionPane.ERROR_MESSAGE );
      }

      // display error message if cannot read 
      // due to problem with file
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error during read from file",
            "Read Error", JOptionPane.ERROR_MESSAGE );
      }
   }

   // close file and terminate application
   private void closeFile()
   {
      // close file and exit
      try {
         input.close();
         System.exit( 0 );
      }

      // process exception while closing file
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }
   }

   // execute application; ReadSequentialFile constructor
   // displays window
   public static void main( String args[] )
   {
      new ReadSequentialFile();
   }

}  // end class ReadSequentialFile

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
