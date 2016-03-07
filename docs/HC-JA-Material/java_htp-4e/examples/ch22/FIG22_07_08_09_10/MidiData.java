// Fig. 22.7: MidiData.java
// Contains MIDI sequence information
// with acessor methods and MIDI playback methods

// Java core package
import java.io.*;

// Java extension package
import javax.sound.midi.*;

public class MidiData {

   // MIDI track data
   private Track track;

   // player for MIDI sequences
   private Sequencer sequencer;

   // MIDI sequence
   private Sequence sequence;

   // MIDI events containing time and MidiMessages
   private MidiEvent currentEvent, nextEvent;

   // MIDI message usually containing sounding messages
   private ShortMessage noteMessage;

   // short, meta, or sysex MIDI messages
   private MidiMessage message;

   // index of MIDI event in track, command in MIDI message
   private int eventIndex = 0, command;

   // method to play MIDI sequence via sequencer
   public void play()
   {
      // initiate default sequencer
      try {

         // get sequencer from MidiSystem
         sequencer = MidiSystem.getSequencer();

         // open sequencer resources
         sequencer.open();

         // load MIDI into sequencer
         sequencer.setSequence( sequence );

         // play sequence
         sequencer.start();
      }

      // MIDI resource availability error
      catch ( MidiUnavailableException noMidiException ) {
         noMidiException.printStackTrace();
      }

      // corrupted MIDI or invalid MIDI file encountered
      catch ( InvalidMidiDataException badMidiException ) {
         badMidiException.printStackTrace();

      }

   }  // end method play

   // method returning adjusted tempo/resolution of MIDI
   public int getResolution()
   {
      return 500 / sequence.getResolution();
   }

   // obtain MIDI and prepare track in MIDI to be accessed
   public boolean initialize( File file )
   {
      // get valid MIDI from file into sequence
      try {
         sequence = MidiSystem.getSequence( file );
      }

      // unreadable MIDI file or unsupported MIDI
      catch ( InvalidMidiDataException badMIDI ) {
         badMIDI.printStackTrace();
         return false;
      }

      // I/O error generated during file reading
      catch ( IOException ioException ) {
         ioException.printStackTrace();
         return false;
      }

      return true;

   }  // end method initialize

   // prepare longest track to be read and get first MIDI event
   public boolean initializeTrack()
   {
      // get all tracks from sequence
      Track tracks[] = sequence.getTracks();

      if ( tracks.length == 0 ) {
         System.err.println( "No tracks in MIDI sequence!" );

         return false;
      }

      track = tracks[ 0 ];

      // find longest track
      for ( int i = 0; i < tracks.length; i++ )

         if ( tracks[ i ].size() > track.size() )
            track = tracks[ i ];

      // set current MIDI event to first event in track
      currentEvent = track.get( eventIndex );

      // get MIDI message from event
      message = currentEvent.getMessage();

      // track initialization successful
      return true;

   }  // end method initializeTrack

   // move to next event in track
   public void goNextEvent()
   {
      eventIndex++;
      currentEvent = track.get( eventIndex );
      message = currentEvent.getMessage();
   }

   // get time interval between events
   public int getEventDelay()
   {
      // first event's time interval is its duration
      if ( eventIndex == 0 )
         return ( int ) currentEvent.getTick();

      // time difference between current and next event
      return ( int ) ( track.get( eventIndex + 1 ).getTick() -
         currentEvent.getTick() );
   }

   // return if track has ended
   public boolean isTrackEnd()
   {
      // if eventIndex is less than track's number of events
      if ( eventIndex + 1 < track.size() )
         return false;

      return true;
   }

   // get current ShortMessage command from event
   public int getEventCommand()
   {
      if ( message instanceof ShortMessage ) {

         // obtain MidiMessage for accessing purposes
         noteMessage = ( ShortMessage ) message;
         return noteMessage.getCommand();
      }

      return -1;
   }

   // get note number of current event
   public int getNote()
   {
      if ( noteMessage != null )
         return noteMessage.getData1();

      return -1;
   }

   // get volume of current event
   public int getVolume()
   {
      return noteMessage.getData2();
   }

}  // end class MidiData
