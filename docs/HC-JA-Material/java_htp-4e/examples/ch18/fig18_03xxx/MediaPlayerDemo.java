// Fig. 16.3: MediaPlayerDemo.java
// Uses a Java Media Player to play media files.
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.media.*;

public class MediaPlayerDemo extends JFrame {
   private Player player;
   private File file;

   public MediaPlayerDemo()
   {
      super( "Demonstrating the Java Media Player" );

      JButton openFile = new JButton( "Open file to play" );
      openFile.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               openFile();
               createPlayer();
            }
         }
      );
      getContentPane().add( openFile, BorderLayout.NORTH );
  
      setSize( 300, 300 );
      show();
   }

   private void openFile()
   {      
      JFileChooser fileChooser = new JFileChooser();

      fileChooser.setFileSelectionMode(
         JFileChooser.FILES_ONLY );
      int result = fileChooser.showOpenDialog( this );

      // user clicked Cancel button on dialog
      if ( result == JFileChooser.CANCEL_OPTION )
         file = null;
      else
         file = fileChooser.getSelectedFile();
   }

   private void createPlayer()
   {
      if ( file == null )
         return;

      removePreviousPlayer();

      try {
         // create a new player and add listener
         player = Manager.createPlayer( file.toURL() );
         player.addControllerListener( new EventHandler() );
         player.start();  // start player
      }
      catch ( Exception e ){
         JOptionPane.showMessageDialog( this,
            "Invalid file or location", "Error loading file",
            JOptionPane.ERROR_MESSAGE );
      }
   }

   private void removePreviousPlayer()
   {
      if ( player == null )
         return;

      player.close();

      Component visual = player.getVisualComponent();
      Component control = player.getControlPanelComponent();

      Container c = getContentPane();
     
      if ( visual != null ) 
         c.remove( visual );

      if ( control != null ) 
         c.remove( control );
   }

   public static void main(String args[])
   {
      MediaPlayerDemo app = new MediaPlayerDemo();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit(0);
            }
         }
      );
   }

   // inner class to handler events from media player
   private class EventHandler implements ControllerListener {
      public void controllerUpdate( ControllerEvent e ) {
         if ( e instanceof RealizeCompleteEvent ) {
            Container c = getContentPane();
         
            // load Visual and Control components if they exist
            Component visualComponent =
               player.getVisualComponent();

            if ( visualComponent != null )
               c.add( visualComponent, BorderLayout.CENTER );

            Component controlsComponent =
               player.getControlPanelComponent();

            if ( controlsComponent != null )
               c.add( controlsComponent, BorderLayout.SOUTH );

            c.doLayout();
         }
      }
   }
}

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
