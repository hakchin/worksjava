// Fig. 13.16: CardDeck.java
// Demonstrating CardLayout.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class CardDeck extends JFrame implements ActionListener {

   private CardLayout cardManager;
   private JPanel deck;
   private JButton controls[];
   private String names[] = { "First card", "Next card",
      "Previous card", "Last card" };

   // set up GUI
   public CardDeck()
   {
      super( "CardLayout " );

      Container container = getContentPane();

      // create the JPanel with CardLayout
      deck = new JPanel();
      cardManager = new CardLayout(); 
      deck.setLayout( cardManager );  

      // set up card1 and add it to JPanel deck
      JLabel label1 =
         new JLabel( "card one", SwingConstants.CENTER );
      JPanel card1 = new JPanel();
      card1.add( label1 ); 
      deck.add( card1, label1.getText() ); // add card to deck
      
      // set up card2 and add it to JPanel deck
      JLabel label2 =
         new JLabel( "card two", SwingConstants.CENTER );
      JPanel card2 = new JPanel();
      card2.setBackground( Color.yellow );
      card2.add( label2 );
      deck.add( card2, label2.getText() ); // add card to deck

      // set up card3 and add it to JPanel deck
      JLabel label3 = new JLabel( "card three" );
      JPanel card3 = new JPanel();
      card3.setLayout( new BorderLayout() );  
      card3.add( new JButton( "North" ), BorderLayout.NORTH );
      card3.add( new JButton( "West" ), BorderLayout.WEST );
      card3.add( new JButton( "East" ), BorderLayout.EAST );
      card3.add( new JButton( "South" ), BorderLayout.SOUTH );
      card3.add( label3, BorderLayout.CENTER );
      deck.add( card3, label3.getText() ); // add card to deck

      // create and layout buttons that will control deck
      JPanel buttons = new JPanel();
      buttons.setLayout( new GridLayout( 2, 2 ) );
      controls = new JButton[ names.length ];

      for ( int count = 0; count < controls.length; count++ ) {
         controls[ count ] = new JButton( names[ count ] );
         controls[ count ].addActionListener( this );
         buttons.add( controls[ count ] );
      }

      // add JPanel deck and JPanel buttons to the applet
      container.add( buttons, BorderLayout.WEST );
      container.add( deck, BorderLayout.EAST );

      setSize( 450, 200 );
      setVisible( true );

   }  // end constructor

   // handle button events by switching cards
   public void actionPerformed( ActionEvent event )
   {
      // show first card
      if ( event.getSource() == controls[ 0 ] )    
         cardManager.first( deck ); 

      // show next card
      else if ( event.getSource() == controls[ 1 ] )    
         cardManager.next( deck );  

      // show previous card
      else if ( event.getSource() == controls[ 2 ] )
         cardManager.previous( deck );  

      // show last card  
      else if ( event.getSource() == controls[ 3 ] )
         cardManager.last( deck );            
   }

   // execute application
   public static void main( String args[] )
   {
      CardDeck cardDeckDemo = new CardDeck();

      cardDeckDemo.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class CardDeck

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
