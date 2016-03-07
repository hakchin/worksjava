// Fig. 22.9: MidiSynthesizer.java
// Accessing synthesizer resources

// Java extension package
import javax.sound.midi.*;

public class MidiSynthesizer {

   // main synthesizer accesses resources
   private Synthesizer synthesizer;

   // available instruments for synthesis use
   private Instrument instruments[];

   // channels through which notes sound
   private MidiChannel channels[];
   private MidiChannel channel;    // current channel

   // transmitter for transmitting messages
   private Transmitter transmitter;

   // receiver end of messages
   private Receiver receiver;

   // short message containing sound commands, note, volume
   private ShortMessage message;

   // constructor for MidiSynthesizer
   public MidiSynthesizer()
   {
      // open synthesizer, set receiver,
      // obtain channels and instruments
      try {
         synthesizer = MidiSystem.getSynthesizer();

         if ( synthesizer != null ) {

            synthesizer.open();

            // get transmitter of synthesizer
            transmitter = synthesizer.getTransmitter();

            if ( transmitter == null )
               System.err.println( "Transmitter unavailable" );

            // get receiver of synthesizer
            receiver = synthesizer.getReceiver();

            if ( receiver == null )
               System.out.println( "Receiver unavailable" );

            // get all available instruments in default
            // soundbank or synthesizer
            instruments = synthesizer.getAvailableInstruments();

            // get all 16 channels from synthesizer
            channels = synthesizer.getChannels();

            // assign first channel as default channel
            channel = channels[ 0 ];
         }

         else
            System.err.println( "No Synthesizer" );
      }

      // synthesizer, receiver or transmitter unavailable
      catch ( MidiUnavailableException noMidiException ) {
         noMidiException.printStackTrace();
      }

   }  // end constructor

   // return available instruments
   public Instrument[] getInstruments()
   {
      return instruments;
   }

   // return synthesizer's transmitter
   public Transmitter getTransmitter()
   {
      return transmitter;
   }

   // sound note on through channel
   public void midiNoteOn( int note, int volume )
   {
      channel.noteOn( note, volume );
   }

   // sound note off through channel
   public void midiNoteOff( int note )
   {
      channel.noteOff( note );
   }

   // change to selected instrument
   public void changeInstrument( int index )
   {
      Patch patch = instruments[ index ].getPatch();

      channel.programChange( patch.getBank(), 
         patch.getProgram() );
   }

   // send custom MIDI messages through transmitter
   public void sendMessage( int command, int note, int volume )
   {
      // send a MIDI ShortMessage using this method's parameters
      try {
         message = new ShortMessage();

         // set new message of command (NOTE_ON, NOTE_OFF),
         // note number, volume
         message.setMessage( command, note, volume );

         // send message through receiver
         receiver.send( message, -1 );
      }

      // invalid message values set
      catch ( InvalidMidiDataException badMidiException ) {
         badMidiException.printStackTrace();
      }

   }  // end method sendMessage

}  // end class MidiSynthesizer
