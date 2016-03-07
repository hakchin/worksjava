// Fig. 22.3: RTPServer.java
// Provides configuration and sending capabilities
// for RTP-supported media files

// Java core packages
import java.io.*;
import java.net.*;

// Java extension packages
import javax.media.*;
import javax.media.protocol.*;
import javax.media.control.*;
import javax.media.rtp.*;
import javax.media.format.*;

public class RTPServer {

   // IP address, file or medialocator name, port number
   private String ipAddress, fileName;
   private int port;

   // processor controlling data flow
   private Processor processor;

   // data output from processor to be sent
   private DataSource outSource;

   // media tracks' configurable controls
   private TrackControl tracks[];

   // RTP session manager
   private RTPManager rtpManager[];

   // constructor for RTPServer
   public RTPServer( String locator, String ip, int portNumber )
   {
      fileName = locator;
      port = portNumber;
      ipAddress = ip;
   }

   // initialize and set up processor
   // return true if sucessful, false if not
   public boolean beginSession()
   {
      // get MediaLocator from specific location
      MediaLocator mediaLocator = new MediaLocator( fileName );

      if ( mediaLocator == null ) {
         System.err.println(
            "No MediaLocator found for " + fileName );

         return false;
      }

      // create processor from MediaLocator
      try {
         processor = Manager.createProcessor( mediaLocator );

         // register a ControllerListener for processor
         // to listen for state and transition events
         processor.addControllerListener(
            new ProcessorEventHandler() );

         System.out.println( "Processor configuring..." );

         // configure processor before setting it up
         processor.configure();
      }

      // source connection error
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      // exception thrown when no processor could
      // be found for specific data source
      catch ( NoProcessorException noProcessorException ) {
         noProcessorException.printStackTrace();
         return false;
      }

      return true;

   }  // end method beginSession

   // ControllerListener handler for processor
   private class ProcessorEventHandler
      extends ControllerAdapter {

      // set output format and realize 
      // configured processor
      public void configureComplete(
         ConfigureCompleteEvent configureCompleteEvent )
      {
         System.out.println( "\nProcessor configured." );

         setOutputFormat();

         System.out.println( "\nRealizing Processor...\n" );

         processor.realize();
      }

      // start sending when processor is realized
      public void realizeComplete(
         RealizeCompleteEvent realizeCompleteEvent )
      {
         System.out.println(
            "\nInitialization successful for " + fileName );

         if ( transmitMedia() == true )
            System.out.println( "\nTransmission setup OK" );

         else
            System.out.println( "\nTransmission failed." );
      }

      // stop RTP session when there is no media to send
      public void endOfMedia( EndOfMediaEvent mediaEndEvent )
      {
          stopTransmission();
          System.out.println ( "Transmission completed." );
      }

   }  // end inner class ProcessorEventHandler

   // set output format of all tracks in media
   public void setOutputFormat()
   {
      // set output content type to RTP capable format
      processor.setContentDescriptor(
         new ContentDescriptor( ContentDescriptor.RAW_RTP ) );

      // get all track controls of processor
      tracks = processor.getTrackControls();

      // supported RTP formats of a track
      Format rtpFormats[];

      // set each track to first supported RTP format
      // found in that track
      for ( int i = 0; i < tracks.length; i++ ) {

         System.out.println( "\nTrack #" +
            ( i + 1 ) +   " supports " );

         if ( tracks[ i ].isEnabled() ) {

            rtpFormats = tracks[ i ].getSupportedFormats();

            // if supported formats of track exist,
            // display all supported RTP formats and set
            // track format to be first supported format
            if ( rtpFormats.length > 0 ) {

               for ( int j = 0; j < rtpFormats.length; j++ )
                  System.out.println( rtpFormats[ j ] );

               tracks[ i ].setFormat( rtpFormats[ 0 ] );

               System.out.println ( "Track format set to " +
                  tracks[ i ].getFormat() );
            }

            else
               System.err.println (
                  "No supported RTP formats for track!" );

         }  // end if

      }  // end for loop

   }  // end method setOutputFormat

   // send media with boolean success value
   public boolean transmitMedia()
   {
      outSource = processor.getDataOutput();

      if ( outSource == null ) {
         System.out.println ( "No data source from media!" );

         return false;
      }

      // rtp stream managers for each track
      rtpManager = new RTPManager[ tracks.length ];

      // destination and local RTP session addresses
      SessionAddress localAddress, remoteAddress;

      // RTP stream being sent
      SendStream sendStream;

      // IP address
      InetAddress ip;

      // initialize transmission addresses and send out media
      try {

         // transmit every track in media
         for ( int i = 0; i < tracks.length; i++ ) {

            // instantiate a RTPManager
            rtpManager[ i ] = RTPManager.newInstance();

            // add 2 to specify next control port number;
            // (RTP Session Manager uses 2 ports)
            port += ( 2 * i );

            // get IP address of host from ipAddress string
            ip = InetAddress.getByName( ipAddress );

            // encapsulate pair of IP addresses for control and
            // data with 2 ports into local session address
            localAddress = new SessionAddress(
               ip.getLocalHost(), port );

            // get remoteAddress session address
            remoteAddress = new SessionAddress( ip, port );

            // initialize the session
            rtpManager[ i ].initialize( localAddress );

            // open RTP session for destination
            rtpManager[ i ].addTarget( remoteAddress );

            System.out.println( "\nStarted RTP session: "
               + ipAddress + " " + port);

            // create send stream in RTP session
            sendStream =
               rtpManager[ i ].createSendStream( outSource, i );

            // start sending the stream
            sendStream.start();

            System.out.println( "Transmitting Track #" +
               ( i + 1 ) + " ... " );

         }  // end for loop

         // start media feed
         processor.start();

      }  // end try

      // unknown local or unresolvable remote address
      catch ( InvalidSessionAddressException addressError ) {
         addressError.printStackTrace();
         return false;
      }

      // DataSource connection error
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      // format not set or invalid format set on stream source
      catch ( UnsupportedFormatException formatException ) {
         formatException.printStackTrace();
         return false;
      }

      // transmission initialized successfully
      return true;

   }  // end method transmitMedia

   // stop transmission and close resources
   public void stopTransmission()
   {
      if ( processor != null ) {

         // stop processor
         processor.stop();

         // dispose processor
         processor.close();

         if ( rtpManager != null )

            // close destination targets
            // and dispose RTP managers
            for ( int i = 0; i < rtpManager.length; i++ ) {

               // close streams to all destinations
               // with a reason for termination
               rtpManager[ i ].removeTargets(
                  "Session stopped." );

               // release RTP session resources
               rtpManager[ i ].dispose();
            }

      }  // end if

      System.out.println ( "Transmission stopped." );

   }  // end method stopTransmission

}  // end class RTPServer
