// Fig. 15.17: RandomCharacters.java
// Demonstrating the Runnable interface.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class RandomCharacters extends JApplet 
   implements ActionListener {

   // declare variables used by applet and 
   // inner class RunnableObject
   private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private final static int SIZE = 3;

   private JLabel outputs[];
   private JCheckBox checkboxes[];   

   private Thread threads[];
   private boolean suspended[];

   // set up GUI and arrays
   public void init()
   {
      outputs = new JLabel[ SIZE ];
      checkboxes = new JCheckBox[ SIZE ];
      threads = new Thread[ SIZE ];
      suspended = new boolean[ SIZE ];

      Container container = getContentPane();
      container.setLayout( new GridLayout( SIZE, 2, 5, 5 ) );

      // create GUI components, register listeners and attach 
      // components to content pane
      for ( int count = 0; count < SIZE; count++ ) {
         outputs[ count ] = new JLabel();
         outputs[ count ].setBackground( Color.green );
         outputs[ count ].setOpaque( true );
         container.add( outputs[ count ] );

         checkboxes[ count ] = new JCheckBox( "Suspended" );
         checkboxes[ count ].addActionListener( this );
         container.add( checkboxes[ count ] );
      }
   }
  
   // Create and start threads. This method called after init 
   // and when user revists Web page containing this applet
   public void start()
   {
      // create threads and start every time start is called
      for ( int count = 0; count < threads.length; count++ ) {

         // create Thread and initialize it with object that 
         // implements Runnable
         threads[ count ] = new Thread( new RunnableObject(), 
            "Thread " + ( count + 1 ) );

         // begin executing Thread
         threads[ count ].start();
      }
   }

   // determine thread location in threads array
   private int getIndex( Thread current )
   {
      for ( int count = 0; count < threads.length; count++ )

         if ( current == threads[ count ] )
            return count;

      return -1; 
   }

   // called when user switches Web pages; stops all threads
   public synchronized void stop()
   {
      // Indicate that each thread should terminate. Setting 
	  // these references to null causes each thread's run
	  // method to complete execution.
      for ( int count = 0; count < threads.length; count++ ) 
         threads[ count ] = null;

      // make all waiting threads ready to execute, so they
      // can terminate themselves
      notifyAll();
   }

   // handle button events
   public synchronized void actionPerformed( ActionEvent event )
   {
      for ( int count = 0; count < checkboxes.length; count++ ) {

         if ( event.getSource() == checkboxes[ count ] ) {
            suspended[ count ] = !suspended[ count ];

            // change label color on suspend/resume
            outputs[ count ].setBackground(
               !suspended[ count ] ? Color.green : Color.red );

            // if thread resumed, make sure it starts executing
            if ( !suspended[ count ] )
               notifyAll();

            return;
         }
      }
   }

   // private inner class that implements Runnable so objects
   // of this class can control threads
   private class RunnableObject implements Runnable {
   
      // Place random characters in GUI. Local variables
      // currentThread and index are declared final so 
      // they can be used in an anonymous inner class.
      public void run()
      {
         // get reference to executing thread
         final Thread currentThread = Thread.currentThread();

         // determine thread's position in array
         final int index = getIndex( currentThread );

         // loop condition determines when thread should stop
         while ( threads[ index ] == currentThread ) {

            // sleep from 0 to 1 second
            try {
               Thread.sleep( ( int ) ( Math.random() * 1000 ) );

               // Determine whether thread should suspend 
               // execution. Use applet as monitor.
               synchronized( RandomCharacters.this ) {

                  while ( suspended[ index ] &&
                     threads[ index ] == currentThread ) {

                     // Temporarily stop thread execution. Use
                     // applet as monitor.
                     RandomCharacters.this.wait();  
                  }

               }  // end synchronized block
            }

            // process InterruptedExceptions during sleep or wait
            catch ( InterruptedException interruptedException ) {
               System.err.println( "sleep interrupted" );
            }
            
            // display character on corresponding label
            SwingUtilities.invokeLater(
            
               // anonymous inner class used by SwingUtilities 
               // method invokeLater to ensure GUI 
               // updates properly
               new Runnable() {

                  // updates Swing GUI component
                  public void run() 
                  {
                     // pick random character
                     char displayChar = alphabet.charAt( 
                        ( int ) ( Math.random() * 26 ) );

                     outputs[ index ].setText( 
                        currentThread.getName() + ": " + 
                        displayChar );
                  }

               }  // end anonymous inner class

            ); // end call to SwingUtilities.invokeLater
            
         }  // end while

         System.err.println(
            currentThread.getName() + " terminating" );
      }

   }  // end private inner class RunnableObject

}  // end class RandomCharacters

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
