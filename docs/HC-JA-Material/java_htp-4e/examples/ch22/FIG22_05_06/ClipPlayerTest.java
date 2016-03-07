// Fig. 22.6: ClipPlayerTest.java
// Test file for ClipPlayer

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Java extension packages
import javax.swing.*;

public class ClipPlayerTest extends JFrame {

   // object to play audio clips
   private ClipPlayer clipPlayer;

   // constructor for ClipPlayerTest
   public ClipPlayerTest()
   {
      super( "Clip Player" );

      // panel containing buttons
      JPanel buttonPanel = new JPanel();
      getContentPane().add( buttonPanel );

      // open file button
      JButton openFile = new JButton( "Open Audio Clip" );
      buttonPanel.add( openFile, BorderLayout.CENTER );

      // register ActionListener for openFile events
      openFile.addActionListener(

         // inner anonymous class to handle openFile ActionEvent
         new ActionListener() {

            // try to open and play an audio clip file
            public void actionPerformed( ActionEvent actEvent )
            {
               File mediaFile = getFile();

               if ( mediaFile != null ) {

                  // instantiate new clip player with mediaFile
                  clipPlayer = new ClipPlayer( mediaFile );

                  // if clip player opened correctly
                  if ( clipPlayer.openFile() == true ) {

                     // play loaded clip
                     clipPlayer.play();

                     // no replay
                     clipPlayer.setReplay( false );
                  }

               }  // end if mediaFile

            }  // end actionPerformed

         }  // end ActionListener

      ); // end call to addActionListener

   }  // end constructor

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
   public static void main( String args[] )
   {
      ClipPlayerTest test = new ClipPlayerTest();

      test.setSize( 150, 70 );
      test.setLocation( 300, 300 );
      test.setDefaultCloseOperation( EXIT_ON_CLOSE );
      test.setVisible( true );
   }

}  // end class ClipPlayerTest
