// Fig. 22.8: MidiRecord.java
// Allows for recording and playback
// of synthesized MIDI

// Java core packages
import java.io.*;

// Java extension package
import javax.sound.midi.*;

public class MidiRecord {

   // MIDI track
   private Track track;

   // MIDI sequencer to play and access music
   private Sequencer sequencer;

   // MIDI sequence
   private Sequence sequence;

   // receiver of MIDI events
   private Receiver receiver;

   // transmitter for transmitting MIDI messages
   private Transmitter transmitter;

   // constructor for MidiRecord
   public MidiRecord( Transmitter transmit )
   {
      transmitter = transmit;
   }

   // initialize recording sequencer, set up recording sequence
   public boolean initialize()
   {
      // create empty MIDI sequence and set up sequencer wiring
      try {

         // create tempo-based sequence of 10 pulses per beat
         sequence = new Sequence( Sequence.PPQ, 10 );

         // obtain sequencer and open it
         sequencer = MidiSystem.getSequencer();
         sequencer.open();

         // get receiver of sequencer
         receiver = sequencer.getReceiver();

         if ( receiver == null ) {
            System.err.println(
               "Receiver unavailable for sequencer" );
            return false;
         }

         // set receiver for transmitter to send MidiMessages
         transmitter.setReceiver( receiver );

         makeTrack();
      }

      // invalid timing division specification for new sequence
      catch ( InvalidMidiDataException invalidMidiException ) {
         invalidMidiException.printStackTrace();
         return false;
      }

      // sequencer or receiver unavailable
      catch ( MidiUnavailableException noMidiException ) {
         noMidiException.printStackTrace();
         return false;
      }

      // MIDI recorder initialization successful
      return true;

   }  // end method initialize

   // make new empty track for sequence
   public void makeTrack()
   {
      // if previous track exists, delete it first
      if ( track != null )
         sequence.deleteTrack( track );

      // create track in sequence
      track = sequence.createTrack();
   }

   // start playback of loaded sequence
   public void play()
   {
      sequencer.start();
   }

   // start recording into sequence
   public void startRecord()
   {
      // load sequence into recorder and start recording
      try {
         sequencer.setSequence( sequence );

         // set track to recording-enabled and default channel
         sequencer.recordEnable( track, 0 );

         sequencer.startRecording();
      }

      // sequence contains bad MIDI data
      catch ( InvalidMidiDataException badMidiException ) {
         badMidiException.printStackTrace();

      }

   }  // end method startRecord

   // stop MIDI recording
   public void stopRecord()
   {
      sequencer.stopRecording();
   }

   // save MIDI sequence to file
   public void saveSequence( File file )
   {
      // get all MIDI supported file types
      int[] fileTypes = MidiSystem.getMidiFileTypes( sequence );

      if ( fileTypes.length == 0 ) {
         System.err.println( "No supported MIDI file format!" );
         return;
      }

      // write recorded sequence into MIDI file
      try {
         MidiSystem.write( sequence, fileTypes[ 0 ], file );
      }

      // error writing to file
      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

   }  // end method saveSequence

}  // end class MidiRecord
