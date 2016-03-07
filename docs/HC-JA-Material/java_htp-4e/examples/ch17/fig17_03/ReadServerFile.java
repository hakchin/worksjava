// Fig. 17.3: ReadServerFile.java
// This program uses a JEditorPane to display the
// contents of a file on a Web server.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class ReadServerFile extends JFrame {
   private JTextField enterField;
   private JEditorPane contentsArea;

   // set up GUI
   public ReadServerFile()
   {
      super( "Simple Web Browser" );

      Container container = getContentPane();

      // create enterField and register its listener
      enterField = new JTextField( "Enter file URL here" );

      enterField.addActionListener(

         new ActionListener() {

            // get document specified by user
            public void actionPerformed( ActionEvent event )
            {
               getThePage( event.getActionCommand() );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( enterField, BorderLayout.NORTH );

      // create contentsArea and register HyperlinkEvent listener
      contentsArea = new JEditorPane();
      contentsArea.setEditable( false );

      contentsArea.addHyperlinkListener(

         new HyperlinkListener() {

            // if user clicked hyperlink, go to specified page
            public void hyperlinkUpdate( HyperlinkEvent event )
            {
               if ( event.getEventType() ==
                    HyperlinkEvent.EventType.ACTIVATED )
                  getThePage( event.getURL().toString() );
            }

         }  // end anonymous inner class

      ); // end call to addHyperlinkListener

      container.add( new JScrollPane( contentsArea ),
         BorderLayout.CENTER );

      setSize( 400, 300 );
      setVisible( true );
   }

   // load document; change mouse cursor to indicate status
   private void getThePage( String location )
   {
      // change mouse cursor to WAIT_CURSOR
      setCursor( Cursor.getPredefinedCursor(
         Cursor.WAIT_CURSOR ) );

      // load document into contentsArea and display location in
      // enterField
      try {
         contentsArea.setPage( location );
         enterField.setText( location );
      }

      // process problems loading document
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "Error retrieving specified URL",
            "Bad URL", JOptionPane.ERROR_MESSAGE );
      }

      setCursor( Cursor.getPredefinedCursor(
         Cursor.DEFAULT_CURSOR ) );
   }

   // begin application execution
   public static void main( String args[] )
   {
      ReadServerFile application = new ReadServerFile();

      application.setDefaultCloseOperation( 
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class ReadServerFile


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
