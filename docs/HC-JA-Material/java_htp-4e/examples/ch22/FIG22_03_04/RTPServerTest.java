// Fig. 22.4: RTPServerTest.java
// Test class for RTPServer

// Java core packages
import java.awt.event.*;
import java.io.*;
import java.net.*;

// Java extension packages
import javax.swing.*;

public class RTPServerTest extends JFrame {

   // object handling RTP streaming
   private RTPServer rtpServer;

   // media sources and destination locations
   private int port;
   private String ip, mediaLocation;
   private File mediaFile;

   // GUI buttons
   private JButton transmitFileButton, transmitUrlButton;

   // constructor for RTPServerTest
   public RTPServerTest()
   {
      super( "RTP Server Test" );

      // register a WindowListener for frame events
      addWindowListener(

         // anonymous inner class to handle WindowEvents
         new WindowAdapter() {

            public void windowClosing(
               WindowEvent windowEvent )
            {
               if ( rtpServer != null )
                  rtpServer.stopTransmission();
            }

         }  // end WindowAdpater

      ); // end call to method addWindowListener

      // panel containing button GUI
      JPanel buttonPanel = new JPanel();
      getContentPane().add( buttonPanel );

      // transmit file button GUI
      transmitFileButton = new JButton( "Transmit File" );
      buttonPanel.add( transmitFileButton );

      // register ActionListener for transmitFileButton events
      transmitFileButton.addActionListener(
         new ButtonHandler() );

      // transmit URL button GUI
      transmitUrlButton = new JButton( "Transmit Media" );
      buttonPanel.add( transmitUrlButton );

      // register ActionListener for transmitURLButton events
      transmitUrlButton.addActionListener(
         new ButtonHandler() );

   }  // end constructor

   // inner class handles transmission button events
   private class ButtonHandler implements ActionListener {

      // open and try to send file to user-input destination
      public void actionPerformed( ActionEvent actionEvent )
      {
         // if transmitFileButton invoked, get file URL string
         if ( actionEvent.getSource() == transmitFileButton ) {

            mediaFile = getFile();

            if ( mediaFile != null )

               // obtain URL string from file
               try {
                  mediaLocation = mediaFile.toURL().toString();
               }

               // file path unresolvable
               catch ( MalformedURLException badURL ) {
                  badURL.printStackTrace();
               }

            else
               return;

         }  // end if

         // else transmitMediaButton invoked, get location
         else
            mediaLocation = getMediaLocation();

         if ( mediaLocation == null )
            return;

         // get IP address
         ip = getIP();

         if ( ip == null )
            return;

         // get port number
         port = getPort();

         // check for valid postive port number and input
         if ( port <= 0 ) {

            if ( port != -999 )
               System.err.println( "Invalid port number!" );

            return;
         }

         // instantiate new RTP streaming server
         rtpServer = new RTPServer( mediaLocation, ip, port );

         rtpServer.beginSession();

      }  // end method actionPeformed

   }  // end inner class ButtonHandler

   // get file from computer
   public File getFile()
   {
      JFileChooser fileChooser = new JFileChooser();

      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );

      int result = fileChooser.showOpenDialog( this );

      if ( result == JFileChooser.CANCEL_OPTION )
         return null;

      else
         return fileChooser.getSelectedFile();
   }

   // get media location from user
   public String getMediaLocation()
   {
      String input = JOptionPane.showInputDialog(
         this, "Enter MediaLocator" );

      // if user presses OK with no input
      if ( input != null && input.length() == 0 ) {
         System.err.println( "No input!" );
         return null;
      }

      return input;
   }

   // method getting IP string from user
   public String getIP()
   {
      String input = JOptionPane.showInputDialog(
         this, "Enter IP Address: " );

      // if user presses OK with no input
      if ( input != null && input.length() == 0 ) {
         System.err.println( "No input!" );
         return null;
      }

      return input;
   }

   // get port number
   public int getPort()
   {
      String input = JOptionPane.showInputDialog(
         this, "Enter Port Number: " );

      // return flag value if user clicks OK with no input
      if ( input != null && input.length() == 0 ) {
         System.err.println( "No input!" );
         return -999;
      }

      // return flag value if user clicked CANCEL
      if ( input == null )
         return -999;

      // else return input
      return Integer.parseInt( input );

   }  // end method getPort

   // execute application
   public static void main( String args[] )
   {
      RTPServerTest serverTest = new RTPServerTest();

      serverTest.setSize( 250, 70 );
      serverTest.setLocation( 300, 300 );
      serverTest.setDefaultCloseOperation( EXIT_ON_CLOSE );
      serverTest.setVisible( true );
   }

}  // end class RTPServerTest
