// Fig. 17.9: TicTacToeClient.java
// Client for the TicTacToe program

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

// Java extension packages
import javax.swing.*;

// Client class to let a user play Tic-Tac-Toe with
// another user across a network.
public class TicTacToeClient extends JApplet
   implements Runnable {

   private JTextField idField;
   private JTextArea displayArea;
   private JPanel boardPanel, panel2;
   private Square board[][], currentSquare;
   private Socket connection;
   private DataInputStream input;
   private DataOutputStream output;
   private Thread outputThread;
   private char myMark;
   private boolean myTurn;

   // Set up user-interface and board
   public void init()
   {
      Container container = getContentPane();
 
      // set up JTextArea to display messages to user
      displayArea = new JTextArea( 4, 30 );
      displayArea.setEditable( false );
      container.add( new JScrollPane( displayArea ),
         BorderLayout.SOUTH );

      // set up panel for squares in board
      boardPanel = new JPanel();
      boardPanel.setLayout( new GridLayout( 3, 3, 0, 0 ) );

      // create board
      board = new Square[ 3 ][ 3 ];

      // When creating a Square, the location argument to the
      // constructor is a value from 0 to 8 indicating the
      // position of the Square on the board. Values 0, 1,
      // and 2 are the first row, values 3, 4, and 5 are the
      // second row. Values 6, 7, and 8 are the third row.
      for ( int row = 0; row < board.length; row++ ) {

         for ( int column = 0;
                   column < board[ row ].length; column++ ) {

            // create Square
            board[ row ][ column ] =
               new Square( ' ', row * 3 + column );

            boardPanel.add( board[ row ][ column ] );        
         }

      }

      // textfield to display player's mark
      idField = new JTextField();
      idField.setEditable( false );
      container.add( idField, BorderLayout.NORTH );
      
      // set up panel to contain boardPanel (for layout purposes)
      panel2 = new JPanel();
      panel2.add( boardPanel, BorderLayout.CENTER );
      container.add( panel2, BorderLayout.CENTER );
   }

   // Make connection to server and get associated streams.
   // Start separate thread to allow this applet to
   // continually update its output in text area display.
   public void start()
   {
      // connect to server, get streams and start outputThread
      try {
         
         // make connection
         connection = new Socket(
            InetAddress.getByName( "127.0.0.1" ), 5000 );

         // get streams
         input = new DataInputStream(
            connection.getInputStream() );
         output = new DataOutputStream(
            connection.getOutputStream() );
      }

      // catch problems setting up connection and streams
      catch ( IOException ioException ) {
         ioException.printStackTrace();         
      }

      // create and start output thread
      outputThread = new Thread( this );
      outputThread.start();
   }

   // control thread that allows continuous update of the
   // text area displayArea
   public void run()
   {
      // get player's mark (X or O)
      try {
         myMark = input.readChar();
         idField.setText( "You are player \"" + myMark + "\"" );
         myTurn = ( myMark == 'X' ? true : false );
      }

      // process problems communicating with server
      catch ( IOException ioException ) {
         ioException.printStackTrace();         
      }

      // receive messages sent to client and output them
      while ( true ) {

         // read message from server and process message
         try {
            String message = input.readUTF();
            processMessage( message );
         }

         // process problems communicating with server
         catch ( IOException ioException ) {
            ioException.printStackTrace();         
         }
      }

   }  // end method run

   // process messages received by client
   public void processMessage( String message )
   {
      // valid move occurred
      if ( message.equals( "Valid move." ) ) {
         displayArea.append( "Valid move, please wait.\n" );
         
         // set mark in square from event-dispatch thread
         SwingUtilities.invokeLater(
         
            new Runnable() {
         
               public void run()
               {
                  currentSquare.setMark( myMark );
               }
         
            }
         
         ); // end call to invokeLater
      }

      // invalid move occurred
      else if ( message.equals( "Invalid move, try again" ) ) {
         displayArea.append( message + "\n" );
         myTurn = true;
      }

      // opponent moved
      else if ( message.equals( "Opponent moved" ) ) {

         // get move location and update board
         try {
            final int location = input.readInt();
         
            // set mark in square from event-dispatch thread
            SwingUtilities.invokeLater(
         
               new Runnable() {
         
                  public void run()
                  {
                     int row = location / 3;
                     int column = location % 3;
         
                     board[ row ][ column ].setMark(
                        ( myMark == 'X' ? 'O' : 'X' ) );
                     displayArea.append( 
                        "Opponent moved. Your turn.\n" );
                  }
         
               }
         
            ); // end call to invokeLater
                 
            myTurn = true;
         }

         // process problems communicating with server
         catch ( IOException ioException ) {
            ioException.printStackTrace();         
         }

      }

      // simply display message
      else
         displayArea.append( message + "\n" );

      displayArea.setCaretPosition(
         displayArea.getText().length() );

   }  // end method processMessage

   // send message to server indicating clicked square
   public void sendClickedSquare( int location )
   {
      if ( myTurn ) {

         // send location to server
         try {
            output.writeInt( location );
            myTurn = false;
         }

         // process problems communicating with server
         catch ( IOException ioException ) {
            ioException.printStackTrace();
         }
      }
   }

   // set current Square
   public void setCurrentSquare( Square square )
   {
      currentSquare = square;
   }

   // private class for the sqaures on the board
   private class Square extends JPanel {
      private char mark;
      private int location;
   
      public Square( char squareMark, int squareLocation )
      {
         mark = squareMark;
         location = squareLocation;

         addMouseListener( 

            new MouseAdapter() {

               public void mouseReleased( MouseEvent e )
               {
                  setCurrentSquare( Square.this );
                  sendClickedSquare( getSquareLocation() );
               }

            }  // end anonymous inner class

         ); // end call to addMouseListener

      }  // end Square constructor

      // return preferred size of Square
      public Dimension getPreferredSize() 
      { 
         return new Dimension( 30, 30 );
      }

      // return minimum size of Square
      public Dimension getMinimumSize() 
      {
         return getPreferredSize();
      }

      // set mark for Square
      public void setMark( char newMark ) 
      { 
         mark = newMark; 
         repaint(); 
      }
   
      // return Square location
      public int getSquareLocation() 
      {
         return location; 
      }
   
      // draw Square
      public void paintComponent( Graphics g )
      {
         super.paintComponent( g );

         g.drawRect( 0, 0, 29, 29 );
         g.drawString( String.valueOf( mark ), 11, 20 );   
      }

   }  // end class Square
 
}  // end class TicTacToeClient

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
