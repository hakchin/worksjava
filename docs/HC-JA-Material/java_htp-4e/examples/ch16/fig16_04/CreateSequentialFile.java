// Fig. 16.6: CreateSequentialFile.java
// Demonstrating object output with class ObjectOutputStream.
// The objects are written sequentially to a file.

// Java core packages
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch16.BankUI;
import com.deitel.jhtp4.ch16.AccountRecord;

public class CreateSequentialFile extends JFrame {
   private ObjectOutputStream output;
   private BankUI userInterface;
   private JButton enterButton, openButton;

   // set up GUI
   public CreateSequentialFile()
   {
      super( "Creating a Sequential File of Objects" );

      // create instance of reusable user interface
      userInterface = new BankUI( 4 );  // four textfields
      getContentPane().add( 
         userInterface, BorderLayout.CENTER );
      
      // get reference to generic task button doTask1 in BankUI
      // and configure button for use in this program
      openButton = userInterface.getDoTask1Button();
      openButton.setText( "Save into File ..." );

      // register listener to call openFile when button pressed
      openButton.addActionListener(

         // anonymous inner class to handle openButton event
         new ActionListener() {

            // call openFile when button pressed
            public void actionPerformed( ActionEvent event )
            {
               openFile();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // get reference to generic task button doTask2 in BankUI
      // and configure button for use in this program
      enterButton = userInterface.getDoTask2Button();
      enterButton.setText( "Enter" );
      enterButton.setEnabled( false );  // disable button

      // register listener to call addRecord when button pressed
      enterButton.addActionListener(

         // anonymous inner class to handle enterButton event
         new ActionListener() {

            // call addRecord when button pressed
            public void actionPerformed( ActionEvent event )
            {
               addRecord();
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // register window listener to handle window closing event
      addWindowListener(

         // anonymous inner class to handle windowClosing event
         new WindowAdapter() {

            // add current record in GUI to file, then close file
            public void windowClosing( WindowEvent event )
            {
               if ( output != null )
                  addRecord();

               closeFile();
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

      setSize( 300, 200 );
      show();

   }  // end CreateSequentialFile constructor

   // allow user to specify file name
   private void openFile()
   {
      // display file dialog, so user can choose file to open
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );
      
      int result = fileChooser.showSaveDialog( this );

      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         return;

      // get selected file 
      File fileName = fileChooser.getSelectedFile();
      
      // display error if invalid 
      if ( fileName == null ||
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this, 
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {
            output = new ObjectOutputStream(
               new FileOutputStream( fileName ) );

            openButton.setEnabled( false );
            enterButton.setEnabled( true );
         }

         // process exceptions from opening file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
               "Error Opening File", "Error",
               JOptionPane.ERROR_MESSAGE );
         }      
      }
  
   }  // end method openFile

   // close file and terminate application 
   private void closeFile() 
   {
      // close file 
      try {
         output.close();

         System.exit( 0 );
      }

      // process exceptions from closing file 
      catch( IOException ioException ) {
         JOptionPane.showMessageDialog( this, 
            "Error closing file", "Error", 
            JOptionPane.ERROR_MESSAGE );
         System.exit( 1 );
      }
   }

   // add record to file
   public void addRecord()
   {
      int accountNumber = 0;
      AccountRecord record;
      String fieldValues[] = userInterface.getFieldValues();
     
      // if account field value is not empty
      if ( ! fieldValues[ BankUI.ACCOUNT ].equals( "" ) ) {

         // output values to file
         try {
            accountNumber = Integer.parseInt( 
               fieldValues[ BankUI.ACCOUNT ] );

            if ( accountNumber > 0 ) {

               // create new record
               record = new AccountRecord( accountNumber, 
                  fieldValues[ BankUI.FIRSTNAME ],
                  fieldValues[ BankUI.LASTNAME ],
                  Double.parseDouble( 
                     fieldValues[ BankUI.BALANCE ] ) );

               // output record and flush buffer
               output.writeObject( record );
               output.flush();
            }

            // clear textfields
            userInterface.clearFields();
         }

         // process invalid account number or balance format
         catch ( NumberFormatException formatException ) {
            JOptionPane.showMessageDialog( this,
               "Bad account number or balance",
               "Invalid Number Format",
               JOptionPane.ERROR_MESSAGE );
         }

         // process exceptions from file output
         catch ( IOException ioException ) {
            closeFile();
         }

      }  // end if

   }  // end method addRecord

   // execute application; CreateSequentialFile constructor
   // displays window
   public static void main( String args[] )
   {
      new CreateSequentialFile();
   }

}  // end class CreateSequentialFile

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
