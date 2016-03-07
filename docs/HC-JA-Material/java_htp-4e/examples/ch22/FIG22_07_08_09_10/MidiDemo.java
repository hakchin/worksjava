// Fig. 22.10: MidiDemo.java
// Simulates a musical keyboard with various
// instruments to play, also featuring recording, MIDI file
// playback and simulating MIDI playback with the keyboard

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;
import javax.sound.midi.*;

public class MidiDemo extends JFrame {

   // recording MIDI data
   private MidiRecord midiRecord;

   // synthesize MIDI functioning
   private MidiSynthesizer midiSynthesizer;

   // MIDI data in MIDI file
   private MidiData midiData;

   // timer for simulating MIDI on piano
   private Timer pianoTimer;

   // piano keys
   private JButton noteButton[];

   // volume, tempo sliders
   private JSlider volumeSlider, resolutionSlider;

   // containers and panels holding GUI
   private Container container;
   private JPanel controlPanel, buttonPanel;

   // instrument selector and buttons GUI
   private JComboBox instrumentBox;
   private JButton playButton, recordButton,
      saveButton, pianoPlayerButton, listenButton;

   // tempo, last piano key invoked, volume of MIDI
   private int resolution, lastKeyOn = -1, midiVolume = 40;

   // boolean value indicating if program is in recording mode
   private boolean recording = false;

   // first note number of first piano key, max number of keys
   private static int FIRST_NOTE = 32, MAX_KEYS = 64;

   // constructor for MidiDemo
   public MidiDemo()
   {
      super( "MIDI Demo" );

      container = getContentPane();
      container.setLayout( new BorderLayout() );

      // synthesizer must be instantiated to enable synthesis
      midiSynthesizer = new MidiSynthesizer();

      // make piano keys
      makeKeys();

      // add control panel to frame
      controlPanel = new JPanel( new BorderLayout() );
      container.add( controlPanel, BorderLayout.NORTH );

      makeConfigureControls();

      // add button panel to frame
      buttonPanel = new JPanel( new GridLayout( 5, 1 ) );
      controlPanel.add( buttonPanel, BorderLayout.EAST );

      // make GUI
      makePlaySaveButtons();
      makeRecordButton();
      makePianoPlayerButton();

   }  // end constructor

   // utility method making piano keys
   private void makeKeys()
   {
      // panel containing keys
      JPanel keyPanel = new JPanel( null );
      container.add( keyPanel, BorderLayout.CENTER );

      // piano keys
      noteButton = new JButton[ MAX_KEYS ];

      // add MAX_KEYS buttons and what note they sound
      for ( int i = 0; i < MAX_KEYS; i++ ) {

         final int note = i;

         noteButton[ i ] = new JButton();

         // setting white keys
         noteButton[ i ].setBackground( Color.white );

         // set correct spacing for buttons
         noteButton[ i ].setBounds( ( i * 11 ), 1, 11, 40 );
         keyPanel.add( noteButton[ i ] );

         // register a mouse listener for mouse events
         noteButton[ i ].addMouseListener(

            // anonymous inner class to handle mouse events
            new MouseAdapter() {

               // invoke key note when mouse touches key
               public void mouseEntered( MouseEvent mouseEvent )
               {
                  // if recording, send message to receiver
                  if ( recording )
                     midiSynthesizer.sendMessage(
                        ShortMessage.NOTE_ON,
                        note + FIRST_NOTE, midiVolume );

                  // else just sound the note
                  else
                     midiSynthesizer.midiNoteOn(
                        note + FIRST_NOTE, midiVolume );

                  // turn key color to blue
                  noteButton[ note ].setBackground(
                     Color.blue );
               }

               // turn key note off when mouse leaves key
               public void mouseExited( MouseEvent mouseEvent )
               {
                  if ( recording )
                     midiSynthesizer.sendMessage(
                        ShortMessage.NOTE_OFF,
                        note + FIRST_NOTE, midiVolume );
                  else
                     midiSynthesizer.midiNoteOff(
                        note + FIRST_NOTE );

                  noteButton[ note ].setBackground(
                     Color.white );
               }

            }  // end MouseAdapter

         ); // end call to addMouseListener

      }  // end for loop

   }  // end method makeKeys

   // set up configuration controls
   private void makeConfigureControls()
   {
      JPanel configurePanel =
         new JPanel( new GridLayout( 5, 1 ) );

      controlPanel.add( configurePanel, BorderLayout.WEST );

      instrumentBox = new JComboBox(
         midiSynthesizer.getInstruments() );

      configurePanel.add( instrumentBox );

      // register an ActionListener for instrumentBox events
      instrumentBox.addActionListener(

         // anonymous inner class to handle instrument selector
         new ActionListener() {

            // change current instrument program
            public void actionPerformed( ActionEvent event )
            {
               // change instrument in synthesizer
               midiSynthesizer.changeInstrument(
                  instrumentBox.getSelectedIndex() );
            }

         }  // end ActionListener

      ); // end call to method addActionListener

      JLabel volumeLabel = new JLabel( "volume" );
      configurePanel.add( volumeLabel );

      volumeSlider = new JSlider(
         SwingConstants.HORIZONTAL, 5, 80, 30 );

      // register a ChangeListener for slider change events
      volumeSlider.addChangeListener(

         // anonymous inner class to handle volume slider events
         new ChangeListener() {

            // change volume
            public void stateChanged( ChangeEvent changeEvent )
            {
               midiVolume = volumeSlider.getValue();
            }

         }  // end class ChangeListener

      ); // end call to method addChangeListener

      configurePanel.add( volumeSlider );

      JLabel tempLabel = new JLabel( "tempo" );
      configurePanel.add( tempLabel );

      resolutionSlider = new JSlider(
         SwingConstants.HORIZONTAL, 1, 10, 1 );

      // register a ChangeListener slider for change events
      resolutionSlider.addChangeListener(

         // anonymous inner class to handle tempo slider events
         new ChangeListener() {

            // change resolution if value changed
            public void stateChanged( ChangeEvent changeEvent )
            {
               resolution = resolutionSlider.getValue();
            }

         }  // end ChangeListener

      ); // end call to method addChangeListener

      resolutionSlider.setEnabled( false );
      configurePanel.add( resolutionSlider );

   }  // end method makeConfigureControls

   // set up play and save buttons
   private void makePlaySaveButtons()
   {
      playButton = new JButton( "Playback" );

      // register an ActionListener for playButton events
      playButton.addActionListener(

         // anonymous inner class to handle playButton event
         new ActionListener() {

            // playback last recorded MIDI
            public void actionPerformed( ActionEvent event )
            {
               if ( midiRecord != null )
                  midiRecord.play();
            }

         }  // end ActionListener

      ); // end call to method addActionListener

      buttonPanel.add( playButton );
      playButton.setEnabled( false );

      listenButton = new JButton( "Play MIDI" );

      // register an ActionListener for listenButton events
      listenButton.addActionListener(

         // anonymous inner class to handle listenButton events
         new ActionListener() {

            // playback MIDI file
            public void actionPerformed( ActionEvent event )
            {
               File midiFile = getFile();

               if ( midiFile == null )
                  return;

               midiData = new MidiData();

               // prepare MIDI track
               if ( midiData.initialize( midiFile ) == false )
                  return;

               // play MIDI data
               midiData.play();
            }

         }  // end ActionListener

      ); // end call to method addActionListener

      buttonPanel.add( listenButton );

      saveButton = new JButton( "Save MIDI" );

      // register an ActionListener for saveButton events
      saveButton.addActionListener(

         // anonymous inner class to handle saveButton events
         new ActionListener() {

            // get save file and save recorded MIDI
            public void actionPerformed( ActionEvent event )
            {
                File saveFile = getSaveFile();

                if ( saveFile != null )
                   midiRecord.saveSequence( saveFile );
            }

         }  // end ActionListener

      ); // end call to method addActionListener

      buttonPanel.add( saveButton );
      saveButton.setEnabled( false );

   }  // end method makePlaySaveButtons

   // make recording button
   private void makeRecordButton()
   {
      recordButton = new JButton( "Record" );

      // register an ActionListener for recordButton events
      recordButton.addActionListener(

         // anonymous inner class to handle recordButton events
         new ActionListener() {

            // start or stop recording
            public void actionPerformed( ActionEvent event )
            {
               // record MIDI when button is "record" button
               if ( recordButton.getText().equals("Record") ) {

                  if ( midiRecord == null ) {

                     // create new instance of recorder
                     // by passing in synthesizer transmitter
                     midiRecord = new MidiRecord(
                        midiSynthesizer.getTransmitter() );

                     if ( midiRecord.initialize() == false )
                        return;
                  }

                  else
                     midiRecord.makeTrack();

                  midiRecord.startRecord();

                  // disable playback during recording
                  playButton.setEnabled( false );

                  // change recording button to stop
                  recordButton.setText( "Stop" );
                  recording = true;

               }  // end if

               // stop recording when button is "stop" button
               else {
                  midiRecord.stopRecord();

                  recordButton.setText( "Record" );
                  recording = false;

                  playButton.setEnabled( true );
                  saveButton.setEnabled( true );
               }

            }  // end method actionPerformed

         }  // end ActionListener

      ); // end call to method addActionListener

      buttonPanel.add( recordButton );

   } // end method makeRecordButton

   // create Piano Player button and functionality
   private void makePianoPlayerButton()
   {
      pianoPlayerButton = new JButton( "Piano Player" );

      // register an ActionListener for pianoPlayerButton events
      pianoPlayerButton.addActionListener(

         // anonymous inner class to handle pianoPlayerButton
         new ActionListener() {

            // initialize MIDI data and piano player timer
            public void actionPerformed( ActionEvent event )
            {
               File midiFile = getFile();

               if ( midiFile == null )
                  return;

               midiData = new MidiData();

               // prepare MIDI track
               if ( midiData.initialize( midiFile ) == false )
                  return;

               if ( midiData.initializeTrack() == false )
                  return;

               // set initial resolution from MIDI
               resolution = midiData.getResolution();

               // new instance of timer for handling
               // piano sounds and key pressing with tempo
               pianoTimer = new Timer(
                  midiData.getEventDelay() * resolution,
                  new TimerHandler() );

               listenButton.setEnabled( false );
               pianoPlayerButton.setEnabled( false );
               resolutionSlider.setEnabled( true );

               pianoTimer.start();

            }  // method end actionPerformed

         }  // end ActionListener

      ); // end call to method addActionListener

      buttonPanel.add( pianoPlayerButton );

   }  // end method makePianoPlayerButton

   // inner class handles MIDI timed events
   private class TimerHandler implements ActionListener {

      // simulate key note of event if present, jump to next
      // event in track and set next delay interval of timer
      // method invoked when timer reaches next event time
      public void actionPerformed( ActionEvent actionEvent )
      {
         // if valid last key on, set it white
         if ( lastKeyOn != -1 )
            noteButton[ lastKeyOn ].setBackground(
               Color.white );

         noteAction();
         midiData.goNextEvent();

         // stop piano player when end of MIDI track
         if ( midiData.isTrackEnd() == true ) {

            if ( lastKeyOn != -1 )
               noteButton[ lastKeyOn ].setBackground(
                  Color.white );

            pianoTimer.stop();

            listenButton.setEnabled( true );
            pianoPlayerButton.setEnabled( true );
            resolutionSlider.setEnabled( false );

            return;

         }  // end if isTrackEnd

         // set interval before next sounding event
         pianoTimer.setDelay(
            midiData.getEventDelay() * resolution );

      }  // end actionPerformed method

   }  // end inner class TimerHandler

   // determine which note to sound
   // according to MIDI messages
   private void noteAction()
   {
      // during Note On message, sound note and press key
      if ( midiData.getEventCommand() ==
         ShortMessage.NOTE_ON ) {

         // make sure valid note is in range of keys
         if ( ( midiData.getNote() >= FIRST_NOTE ) &&
            ( midiData.getNote() < FIRST_NOTE + MAX_KEYS ) ) {

            lastKeyOn = midiData.getNote() - FIRST_NOTE;

            // set key color to red
            noteButton[ lastKeyOn ].setBackground( Color.red );

            // send and sound note through synthesizer
            midiSynthesizer.sendMessage( 144,
               midiData.getNote(), midiData.getVolume() );

         }  // end if

         // else no last key pressed
         else
            lastKeyOn = -1;

      }  // end if

      // receiving Note Off message will sound off note
      // and change key color back to white
      else

         // if message command is note off
         if ( midiData.getEventCommand() ==
            ShortMessage.NOTE_OFF ) {

            if ( ( midiData.getNote() >= FIRST_NOTE ) &&
               ( midiData.getNote() < FIRST_NOTE + MAX_KEYS ) ) {

               // set appropriate key to white
               noteButton[ midiData.getNote() -
                  FIRST_NOTE ].setBackground( Color.white );

               // send note off message to receiver
               midiSynthesizer.sendMessage( 128,
                  midiData.getNote(), midiData.getVolume() );
            }  

         }  // end if

   }     // end method noteAction

   // get save file from computer
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

   // execute application
   public static void main( String[] args )
   {
      MidiDemo midiTest = new MidiDemo();

      midiTest.setSize( 711, 225 );
      midiTest.setDefaultCloseOperation ( EXIT_ON_CLOSE );
      midiTest.setVisible( true );
   }

}  // end class MidiDemo
