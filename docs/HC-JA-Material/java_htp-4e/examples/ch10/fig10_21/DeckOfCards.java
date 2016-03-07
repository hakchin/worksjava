// Fig. 10.21: DeckOfCards.java
// Card shuffling and dealing program

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class DeckOfCards extends JFrame {
   private Card deck[];
   private int currentCard;
   private JButton dealButton, shuffleButton;
   private JTextField displayField;
   private JLabel statusLabel;

   // set up deck of cards and GUI
   public DeckOfCards()
   {
      super( "Card Dealing Program" );

      String faces[] = { "Ace", "Deuce", "Three", "Four", 
         "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
         "Jack", "Queen", "King" };
      String suits[] = 
         { "Hearts", "Diamonds", "Clubs", "Spades" };

      deck = new Card[ 52 ];
      currentCard = -1;
      
      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = new Card( faces[ count % 13 ],
            suits[ count / 13 ] );

      // set up GUI and event handling
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );     

      dealButton = new JButton( "Deal card" );
      dealButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // deal one card
            public void actionPerformed( ActionEvent actionEvent )
            {
               Card dealt = dealCard();

               if ( dealt != null ) {
                  displayField.setText( dealt.toString() );
                  statusLabel.setText( "Card #: " + currentCard );
               }
               else {
                  displayField.setText(
                     "NO MORE CARDS TO DEAL" );
                  statusLabel.setText(
                     "Shuffle cards to continue" );
               }
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( dealButton );

      shuffleButton = new JButton( "Shuffle cards" );
      shuffleButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // shuffle deck
            public void actionPerformed( ActionEvent actionEvent )
            {
               displayField.setText( "SHUFFLING ..." );
               shuffle();
               displayField.setText( "DECK IS SHUFFLED" );
            }

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( shuffleButton );

      displayField = new JTextField( 20 );
      displayField.setEditable( false );
      container.add( displayField );

      statusLabel = new JLabel();
      container.add( statusLabel );

      setSize( 275, 120 );  // set window size
      show();               // show window
   }

   // shuffle deck of cards with one-pass algorithm
   public void shuffle()
   {
      currentCard = -1;

      // for each card, pick another random card and swap them
      for ( int first = 0; first < deck.length; first++ ) {
         int second =  ( int ) ( Math.random() * 52 );
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      }

      dealButton.setEnabled( true );
   }

   // deal one card
   public Card dealCard()
   {
      if ( ++currentCard < deck.length )
         return deck[ currentCard ];
      else {        
         dealButton.setEnabled( false );
         return null;
      }
   }

   // execute application
   public static void main( String args[] )
   {
      DeckOfCards app = new DeckOfCards();

      app.addWindowListener(

         // anonymous inner class
         new WindowAdapter() {

            // terminate application when user closes window
            public void windowClosing( WindowEvent windowEvent )
            {
               System.exit( 0 );
            }

         }  // end anonymous inner class

      ); // end call to addWindowListener

   }  // end method main

}  // end class DeckOfCards

// class to represent a card
class Card {
   private String face;
   private String suit;

   // constructor to initialize a card
   public Card( String cardFace, String cardSuit )
   {
      face = cardFace;
      suit = cardSuit;
   }

   // return String represenation of Card
   public String toString() 
   { 
      return face + " of " + suit; 
   }

}  // end class Card

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
