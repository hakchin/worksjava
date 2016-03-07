// Fig. 22.2: CapturePlayer.java
// Presents and saves captured media

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;
import javax.media.*;
import javax.media.protocol.*;
import javax.media.format.*;
import javax.media.control.*;
import javax.media.datasink.*;

public class CapturePlayer extends JFrame {

   // capture and save button
   private JButton captureButton;

   // componenet for save capture GUI
   private Component saveProgress;

   // formats of device's media, user-chosen format
   private Format formats[], selectedFormat;

   // controls of device's media formats
   private FormatControl formatControls[];

   // specification information of device
   private CaptureDeviceInfo deviceInfo;

   // vector containing all devices' information
   private Vector deviceList;

   // input and output data sources
   private DataSource inSource, outSource;

   // file writer for captured media
   private DataSink dataSink;

   // processor to render and save captured media
   private Processor processor;

   // constructor for CapturePlayer
   public CapturePlayer()
   {
      super( "Capture Player" );

      // panel containing buttons
      JPanel buttonPanel = new JPanel();
      getContentPane().add( buttonPanel );

      // button for accessing and initializing capture devices
      captureButton = new JButton( "Capture and Save File" );
      buttonPanel.add( captureButton, BorderLayout.CENTER );

      // register an ActionListener for captureButton events
      captureButton.addActionListener( new CaptureHandler() );

      // turn on light rendering to enable capatibility
      // with lightweight GUI components
      Manager.setHint( Manager.LIGHTWEIGHT_RENDERER,
         Boolean.TRUE );

      // register a WindowListener to frame events
      addWindowListener(

         // anonymous inner class to handle WindowEvents
         new WindowAdapter() {

            // dispose processor
            public void windowClosing(
               WindowEvent windowEvent )
            {
               if ( processor != null )
                  processor.close();
            }

         }  // end WindowAdpater

      ); // end call to method addWindowListener

   }  // end constructor

   // action handler class for setting up device
   private class CaptureHandler implements ActionListener {

      // initialize and configure capture device
      public void actionPerformed( ActionEvent actionEvent )
      {
         // put available devices' information into vector
         deviceList =
            CaptureDeviceManager.getDeviceList( null );

         // if no devices found, display error message
         if ( ( deviceList == null ) ||
            ( deviceList.size() == 0 ) ) {

            showErrorMessage( "No capture devices found!" );

            return;
         }

         // array of device names
         String deviceNames[] = new String[ deviceList.size() ];

         // store all device names into array of
         // string for display purposes
         for ( int i = 0; i < deviceList.size(); i++ ){

            deviceInfo =
               ( CaptureDeviceInfo ) deviceList.elementAt( i );

            deviceNames[ i ] = deviceInfo.getName();
         }

         // get vector index of selected device
         int selectDeviceIndex =
            getSelectedDeviceIndex( deviceNames );

         if ( selectDeviceIndex == -1 )
            return;

         // get device information of selected device
         deviceInfo = ( CaptureDeviceInfo )
            deviceList.elementAt( selectDeviceIndex );

         formats = deviceInfo.getFormats();

         // if previous capture device opened, disconnect it
         if ( inSource != null )
            inSource.disconnect();

         // obtain device and set its format
         try {

            // create data source from MediaLocator of device
            inSource = Manager.createDataSource(
               deviceInfo.getLocator() );

            // get format setting controls for device
            formatControls = ( ( CaptureDevice )
               inSource ).getFormatControls();

            // get user's desired device format setting
            selectedFormat = getSelectedFormat( formats );

            if ( selectedFormat == null )
               return;

            setDeviceFormat( selectedFormat );

            captureSaveFile();

         }  // end try

         // unable to find DataSource from MediaLocator
         catch ( NoDataSourceException noDataException ) {
            noDataException.printStackTrace();
         }

         // device connection error
         catch ( IOException ioException ) {
            ioException.printStackTrace();
         }

      }  // end method actionPeformed

   }  // end inner class CaptureHandler

   // set output format of device-captured media
   public void setDeviceFormat( Format currentFormat )
   {
      // set desired format through all format controls
      for ( int i = 0; i < formatControls.length; i++ ) {

         // make sure format control is configurable
         if ( formatControls[ i ].isEnabled() ) {

            formatControls[ i ].setFormat( currentFormat );

            System.out.println (
               "Presentation output format currently set as "+
               formatControls[ i ].getFormat() );
         }

      }  // end for loop
   }

   // get selected device vector index
   public int getSelectedDeviceIndex( String[] names )
   {
      // get device name from dialog box of device choices
      String name = ( String ) JOptionPane.showInputDialog(
         this, "Select a device:", "Device Selection",
         JOptionPane.QUESTION_MESSAGE,
         null, names, names[ 0 ] );

      // if format selected, get index of name in array names
      if ( name != null )
         return Arrays.binarySearch( names, name );

      // else return bad selection value
      else
         return -1;
   }

   // return user-selected format for device
   public Format getSelectedFormat( Format[] showFormats )
   {
      return ( Format ) JOptionPane.showInputDialog( this,
         "Select a format: ", "Format Selection",
         JOptionPane.QUESTION_MESSAGE,
         null, showFormats, null );
   }

   // pop up error messages
   public void showErrorMessage( String error )
   {
      JOptionPane.showMessageDialog( this, error, "Error",
         JOptionPane.ERROR_MESSAGE );
   }

   // get desired file for saved captured media
   public File getSaveFile()
   {
      JFileChooser fileChooser = new JFileChooser();

      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );
      int result = fileChooser.showSaveDialog( this );

      if ( result == JFileChooser.CANCEL_OPTION )
         return null;

      else
         return fileChooser.getSelectedFile();
   }

   // show saving monitor of captured media
   public void showSaveMonitor()
   {
      // show saving monitor dialog
      int result = JOptionPane.showConfirmDialog( this,
         saveProgress, "Save capture in progress...",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.INFORMATION_MESSAGE );

      // terminate saving if user presses "OK" or closes dialog
      if ( ( result == JOptionPane.OK_OPTION ) ||
         ( result == JOptionPane.CLOSED_OPTION ) ) {

         processor.stop();
         processor.close();

         System.out.println ( "Capture closed." );
      }
   }

   // process captured media and save to file
   public void captureSaveFile()
   {
      // array of desired saving formats supported by tracks
      Format outFormats[] = new Format[ 1 ];

      outFormats[ 0 ] = selectedFormat;

      // file output format
      FileTypeDescriptor outFileType =
         new FileTypeDescriptor( FileTypeDescriptor.QUICKTIME );

      // set up and start processor and monitor capture
      try {

         // create processor from processor model
         // of specific data source, track output formats,
         // and file output format
         processor = Manager.createRealizedProcessor(
            new ProcessorModel( inSource, outFormats,
               outFileType ) );

         // try to make a data writer for media output
         if ( !makeDataWriter() )
            return;

         // call start on processor to start captured feed
         processor.start();

         // get monitor control for capturing and encoding
         MonitorControl monitorControl =
            ( MonitorControl ) processor.getControl(
            "javax.media.control.MonitorControl" );

         // get GUI component of monitoring control
         saveProgress = monitorControl.getControlComponent();

         showSaveMonitor();

      }  // end try

      // no processor could be found for specific
      // data source
      catch ( NoProcessorException processorException ) {
         processorException.printStackTrace();
      }

      // unable to realize through
      // createRealizedProcessor method
      catch ( CannotRealizeException realizeException ) {
         realizeException.printStackTrace();
      }

      // device connection error
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

   }  // end method captureSaveFile

   // method initializing media file writer
   public boolean makeDataWriter()
   {
      File saveFile = getSaveFile();

      if ( saveFile == null )
         return false;

      // get output data source from processor
      outSource = processor.getDataOutput();

      if ( outSource == null ) {
         showErrorMessage( "No output from processor!" );
         return false;
      }

      // start data writing process
      try {

         // create new MediaLocator from saveFile URL
         MediaLocator saveLocator =
            new MediaLocator ( saveFile.toURL() );

         // create DataSink from output data source
         // and user-specified save destination file
         dataSink = Manager.createDataSink(
            outSource, saveLocator );

         // register a DataSinkListener for DataSinkEvents
         dataSink.addDataSinkListener(

            // anonymous inner class to handle DataSinkEvents
            new DataSinkListener () {

               // if end of media, close data writer
               public void dataSinkUpdate(
                  DataSinkEvent dataEvent )
               {
                  // if capturing stopped, close DataSink
                  if ( dataEvent instanceof EndOfStreamEvent )
                     dataSink.close();
               }

            }  // end DataSinkListener

         ); // end call to method addDataSinkListener

         // start saving
         dataSink.open();
         dataSink.start();

      }  // end try

      // DataSink could not be found for specific
      // save file and data source
      catch ( NoDataSinkException noDataSinkException ) {
         noDataSinkException.printStackTrace();
         return false;
      }

      // violation while acessing MediaLocator
      // destination
      catch ( SecurityException securityException ) {
         securityException.printStackTrace();
         return false;
      }

      // problem opening and starting DataSink
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      return true;

   }  // end method MakeDataWriter

   // main method
   public static void main( String args[] )
   {
      CapturePlayer testPlayer = new CapturePlayer();

      testPlayer.setSize( 200, 70 );
      testPlayer.setLocation( 300, 300 );
      testPlayer.setDefaultCloseOperation( EXIT_ON_CLOSE );
      testPlayer.setVisible( true );
   }

}  // end class CapturePlayer
