// Fig. 22.5: ClipPlayer.java
// Plays sound clip files of type WAV, AU, AIFF

// Java core packages
import java.io.*;

// Java extension packages
import javax.sound.sampled.*;

public class ClipPlayer implements LineListener {

   // audio input stream
   private AudioInputStream soundStream;

   // audio sample clip line
   private Clip clip;

   // Audio clip file
   private File soundFile;

   // boolean indicating replay of audio
   private boolean replay = false;

   // constructor for ClipPlayer
   public ClipPlayer( File audioFile )
   {
      soundFile = audioFile;
   }

   // open music file, returning true if successful
   public boolean openFile()
   {
      // get audio stream from file
      try {
         soundStream =
            AudioSystem.getAudioInputStream( soundFile );
      }

      // audio file not supported by JavaSound
      catch ( UnsupportedAudioFileException audioException ) {
         audioException.printStackTrace();
         return false;
      }

      // I/O error attempting to get stream
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      // invoke loadClip, returning true if load sucessful
      return loadClip();

   }  // end method openFile

   // load sound clip
   public boolean loadClip ()
   {
      // get clip line for file
      try {

         // get audio format of sound file
         AudioFormat audioFormat = soundStream.getFormat();

          // define line information based on line type,
          // encoding and frame sizes of audio file
         DataLine.Info dataLineInfo = new DataLine.Info(
            Clip.class, AudioSystem.getTargetFormats(
               AudioFormat.Encoding.PCM_SIGNED, audioFormat ),
               audioFormat.getFrameSize(),
               audioFormat.getFrameSize() * 2 );

         // make sure sound system supports data line
         if ( !AudioSystem.isLineSupported( dataLineInfo ) ) {

            System.err.println( "Unsupported Clip File!" );
            return false;
         }

         // get clip line resource
         clip = ( Clip ) AudioSystem.getLine( dataLineInfo );

         // listen to clip line for events
         clip.addLineListener( this );

         // open audio clip and get required system resources
         clip.open( soundStream );

      }  // end try

      // line resource unavailable
      catch ( LineUnavailableException noLineException ) {
         noLineException.printStackTrace();
         return false;
      }

      // I/O error during interpretation of audio data
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      // clip file loaded successfully
      return true;

   }  // end method loadClip

   // start playback of audio clip
   public void play()
   {
      clip.start();
   }

   // line event listener method to stop or replay at clip end
   public void update( LineEvent lineEvent )
   {
      // if clip reaches end, close clip
      if ( lineEvent.getType() == LineEvent.Type.STOP && 
         !replay )
         close();

      // if replay set, replay forever
      else

         if ( lineEvent.getType() == LineEvent.Type.STOP &&  
            replay ) {

            System.out.println( "replay" );

            // replay clip forever
            clip.loop( Clip.LOOP_CONTINUOUSLY );
         }
   }

   // set replay of clip
   public void setReplay( boolean value )
   {
      replay = value;
   }

   // stop and close clip, returning system resources
   public void close()
   {
      if ( clip != null ) {
         clip.stop();
         clip.close();
      }
   }

}  // end class ClipPlayer
