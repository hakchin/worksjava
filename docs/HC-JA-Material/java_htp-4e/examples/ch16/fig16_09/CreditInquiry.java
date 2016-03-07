// Fig. 16.9: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents in a text area based on the type of account the
// user requests (credit balance, debit balance or
// zero balance).

// Java core packages
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

// Java extension packages
import javax.swing.*;

// Deitel packages
import com.deitel.jhtp4.ch16.AccountRecord;

public class CreditInquiry extends JFrame {  
   private JTextArea recordDisplayArea;
   private JButton openButton,  
      creditButton, debitButton, zeroButton;
   private JPanel buttonPanel; 
        
   private ObjectInputStream input;
   private FileInputStream fileInput;
   private File fileName;
   private String accountType;

   // set up GUI
   public CreditInquiry()
   {
      super( "Credit Inquiry Program" );

      Container container = getContentPane();

      // set up panel for buttons
      buttonPanel = new JPanel();
      
      // create and configure button to open file
      openButton = new JButton( "Open File" );
      buttonPanel.add( openButton );

      // register openButton listener
      openButton.addActionListener(

         // anonymous inner class to handle openButton event
         new ActionListener() {

            // open file for processing
            public void actionPerformed( ActionEvent event )
            {
               openFile( true );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      // create and configure button to get 
      // accounts with credit balances
      creditButton = new JButton( "Credit balances" );
      buttonPanel.add( creditButton );
      creditButton.addActionListener( new ButtonHandler() );

      // create and configure button to get 
      // accounts with debit balances
      debitButton = new JButton( "Debit balances" );
      buttonPanel.add( debitButton );
      debitButton.addActionListener( new ButtonHandler() );

      // create and configure button to get 
      // accounts with credit balances
      zeroButton = new JButton( "Zero balances" );
      buttonPanel.add( zeroButton );
      zeroButton.addActionListener( new ButtonHandler() );

      // set up display area
      recordDisplayArea = new JTextArea();
      JScrollPane scroller = 
         new JScrollPane( recordDisplayArea );

      // attach components to content pane
      container.add( scroller, BorderLayout.CENTER );
      container.add( buttonPanel, BorderLayout.SOUTH );

      // disable creditButton, debitButton and zeroButton 
      creditButton.setEnabled( false );
      debitButton.setEnabled( false );
      zeroButton.setEnabled( false );

      // register window listener
      addWindowListener(

         // anonymous inner class for windowClosing event
         new WindowAdapter() {

            // close file and terminate program
            public void windowClosing( WindowEvent event )
            {
               closeFile();
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

      // pack components and display window
      pack();
      setSize( 600, 250 );
      show();

   }  // end CreditInquiry constructor

   // enable user to choose file to open first time; 
   // otherwise, reopen chosen file
   private void openFile( boolean firstTime )
   {
      if ( firstTime ) {

         // display dialog, so user can choose file
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setFileSelectionMode(
            JFileChooser.FILES_ONLY );

         int result = fileChooser.showOpenDialog( this );

         // if user clicked Cancel button on dialog, return
         if ( result == JFileChooser.CANCEL_OPTION )
            return;

         // obtain selected file
         fileName = fileChooser.getSelectedFile();
      }

      // display error if file name invalid
      if ( fileName == null ||
           fileName.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this,
            "Invalid File Name", "Invalid File Name",
            JOptionPane.ERROR_MESSAGE );

      else {

         // open file
         try {

            // close file from previous operation
            if ( input != null )  
               input.close();   

            fileInput = new FileInputStream( fileName );
            input = new ObjectInputStream( fileInput );
            openButton.setEnabled( false );
            creditButton.setEnabled( true );
            debitButton.setEnabled( true );
            zeroButton.setEnabled( true );
         }

         // catch problems manipulating file
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this,
               "File does not exist", "Invalid File Name",
               JOptionPane.ERROR_MESSAGE );
         }      
      }

   }  // end method openFile
  
   // close file before application terminates
   private void closeFile()
   {
      // close file
      try {
         input.close();
      }

      // process exception from closing file
      catch ( IOException ioe ) {
         JOptionPane.showMessageDialog( this,
            "Error closing file",
            "Error", JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }
   }

   // read records from file and display only records of
   // appropriate type
   private void readRecords()
   {      
      AccountRecord record;
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );
      openFile( false );

      // read records
      try {   
         recordDisplayArea.setText( "The accounts are:\n" );

         // input the values from the file
         while ( true ) {

            // read one AccountRecord
            record = ( AccountRecord ) input.readObject();

            // if proper acount type, display record
            if ( shouldDisplay( record.getBalance() ) )
               recordDisplayArea.append( record.getAccount() +
                  "\t" + record.getFirstName() + "\t" + 
                  record.getLastName() + "\t" +
                  twoDigits.format( record.getBalance() ) +
                  "\n" );
         }    
      }

      // close file when end-of-file reached
      catch ( EOFException eofException ) {
         closeFile();
      }

      // display error if cannot read object 
      // because class not found
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( this,
            "Unable to create object",
            "Class Not Found", JOptionPane.ERROR_MESSAGE );
      }

      // display error if cannot read  
      // because problem with file
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error reading from file",
            "Error", JOptionPane.ERROR_MESSAGE );
      }

   }  // end method readRecords

   // uses record ty to determine if a record should be displayed
   private boolean shouldDisplay( double balance )
   {
      if ( accountType.equals( "Credit balances" ) &&
         balance < 0 )

         return true;

      else if ( accountType.equals( "Debit balances" ) &&
         balance > 0 )

         return true;

      else if ( accountType.equals( "Zero balances" ) &&
         balance == 0 )

         return true;

      return false;
   }
   
   // execute application
   public static void main( String args[] )
   {
      new CreditInquiry();
   }
 
   // private inner class for creditButton, debitButton and
   // zeroButton event handling
   private class ButtonHandler implements ActionListener {

      // read records from file
      public void actionPerformed( ActionEvent event )
      {
         accountType = event.getActionCommand();
         readRecords();
      }

   }  // end class ButtonHandler

}  // end class CreditInquiry

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
