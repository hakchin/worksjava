// Fig. 17.8: TicTacToeServer.java
// This class maintains a game of Tic-Tac-Toe for two
// client applets.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

// Java extension packages
import javax.swing.*;

public class TicTacToeServer extends JFrame {
   private byte board[];           
   private JTextArea outputArea;
   private Player players[];
   private ServerSocket server;
   private int currentPlayer;

   // set up tic-tac-toe server and GUI that displays messages
   public TicTacToeServer()
   {
      super( "Tic-Tac-Toe Server" );

      board = new byte[ 9 ]; 
      players = new Player[ 2 ];
      currentPlayer = 0;
 
      // set up ServerSocket
      try {
         server = new ServerSocket( 5000, 2 );
      }

      // process problems creating ServerSocket
      catch( IOException ioException ) {
         ioException.printStackTrace();
         System.exit( 1 );
      }

      // set up JTextArea to display messages during execution
      outputArea = new JTextArea();
      getContentPane().add( outputArea, BorderLayout.CENTER );
      outputArea.setText( "Server awaiting connections\n" );

      setSize( 300, 300 );
      setVisible( true );
   }

   // wait for two connections so game can be played
   public void execute()
   {
      // wait for each client to connect
      for ( int i = 0; i < players.length; i++ ) {

         // wait for connection, create Player, start thread
         try {
            players[ i ] = new Player( server.accept(), i );
            players[ i ].start();
         }

         // process problems receiving connection from client
         catch( IOException ioException ) {
            ioException.printStackTrace();
            System.exit( 1 );
         }
      }

      // Player X is suspended until Player O connects.
      // Resume player X now.          
      synchronized ( players[ 0 ] ) {
         players[ 0 ].setSuspended( false );   
         players[ 0 ].notify();
      }
  
   }  // end method execute
   
   // display a message in outputArea
   public void display( String message )
   {
      outputArea.append( message + "\n" );
   }
 
   // Determine if a move is valid.
   // This method is synchronized because only one move can be
   // made at a time.
   public synchronized boolean validMove( 
      int location, int player )
   {
      boolean moveDone = false;

      // while not current player, must wait for turn
      while ( player != currentPlayer ) {
         
         // wait for turn
         try {
            wait();
         }

         // catch wait interruptions
         catch( InterruptedException interruptedException ) {
            interruptedException.printStackTrace();
         }
      }

      // if location not occupied, make move
      if ( !isOccupied( location ) ) {
  
         // set move in board array
         board[ location ] =
            ( byte ) ( currentPlayer == 0 ? 'X' : 'O' );

         // change current player
         currentPlayer = ( currentPlayer + 1 ) % 2;

         // let new current player know that move occurred
         players[ currentPlayer ].otherPlayerMoved( location );

         // tell waiting player to continue
         notify();             

         // tell player that made move that the move was valid
         return true;
      }

      // tell player that made move that the move was not valid
      else 
         return false;
   }

   // determine whether location is occupied
   public boolean isOccupied( int location )
   {
      if ( board[ location ] == 'X' || board [ location ] == 'O' )
          return true;
      else
          return false;
   }

   // place code in this method to determine whether game over 
   public boolean gameOver()
   {
      return false;
   }

   // execute application
   public static void main( String args[] )
   {
      TicTacToeServer application = new TicTacToeServer();

      application.setDefaultCloseOperation( 
         JFrame.EXIT_ON_CLOSE );

      application.execute();
   }

   // private inner class Player manages each Player as a thread
   private class Player extends Thread {
      private Socket connection;
      private DataInputStream input;
      private DataOutputStream output;
      private int playerNumber;
      private char mark;
      protected boolean suspended = true;

      // set up Player thread
      public Player( Socket socket, int number )
      {
         playerNumber = number;

         // specify player's mark
         mark = ( playerNumber == 0 ? 'X' : 'O' );

         connection = socket;
         
         // obtain streams from Socket
         try {
            input = new DataInputStream(
               connection.getInputStream() );
            output = new DataOutputStream(
               connection.getOutputStream() );
         }

         // process problems getting streams
         catch( IOException ioException ) {
            ioException.printStackTrace();
            System.exit( 1 );
         }
      }

      // send message that other player moved; message contains
      // a String followed by an int
      public void otherPlayerMoved( int location )
      {
         // send message indicating move
         try {
            output.writeUTF( "Opponent moved" );
            output.writeInt( location );
         }

         // process problems sending message
         catch ( IOException ioException ) { 
            ioException.printStackTrace();
         }
      }

      // control thread's execution
      public void run()
      {
         // send client message indicating its mark (X or O),
         // process messages from client
         try {
            display( "Player " + ( playerNumber == 0 ?
              'X' : 'O' ) + " connected" );
 
            // send player's mark
            output.writeChar( mark );

            // send message indicating connection
            output.writeUTF( "Player " +
               ( playerNumber == 0 ? "X connected\n" :
                  "O connected, please wait\n" ) );

            // if player X, wait for another player to arrive
            if ( mark == 'X' ) {
               output.writeUTF( "Waiting for another player" );
   
               // wait for player O
               try {
                  synchronized( this ) {   
                     while ( suspended )
                        wait();  
                  }
               } 

               // process interruptions while waiting
               catch ( InterruptedException exception ) {
                  exception.printStackTrace();
               }

               // send message that other player connected and
               // player X can make a move
               output.writeUTF(
                  "Other player connected. Your move." );
            }

            // while game not over
            while ( ! gameOver() ) {

               // get move location from client
               int location = input.readInt();

               // check for valid move
               if ( validMove( location, playerNumber ) ) {
                  display( "loc: " + location );
                  output.writeUTF( "Valid move." );
               }
               else 
                  output.writeUTF( "Invalid move, try again" );
            }         

            // close connection to client
            connection.close();
         }

         // process problems communicating with client
         catch( IOException ioException ) {
            ioException.printStackTrace();
            System.exit( 1 );
         }
      }

      // set whether or not thread is suspended
      public void setSuspended( boolean status )
      {
         suspended = status;
      }
   
   }  // end class Player

}  // end class TicTacToeServer

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
