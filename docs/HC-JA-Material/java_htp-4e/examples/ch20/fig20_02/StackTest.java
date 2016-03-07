// Fig. 20.2: StackTest.java
// Testing the Stack class of the java.util package

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Java extension packages
import javax.swing.*;

public class StackTest extends JFrame {
   private JLabel statusLabel;
   private JTextField inputField;
   private Stack stack;

   // create GUI to manipulate a Stack
   public StackTest()
   {
      super( "Stacks" );

      Container container = getContentPane();

      statusLabel = new JLabel();
      stack = new Stack();

      container.setLayout( new FlowLayout() );
      container.add( new JLabel( "Enter a string" ) );
      inputField = new JTextField( 10 );
      container.add( inputField );      

      // button to place object on stack
      JButton pushButton = new JButton( "Push" );

      pushButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // put object on Stack
               statusLabel.setText( "Pushed: " + 
                  stack.push( inputField.getText() ) );
            }
         }
      );

      container.add( pushButton );    

      // button to remove top object on stack
      JButton popButton = new JButton( "Pop" );

      popButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // remove element from Stack
               try {
                  statusLabel.setText( "Popped: " + stack.pop() );
               }

               // process exception if Stack empty
               catch ( EmptyStackException exception ) {
                  statusLabel.setText( exception.toString() );
               }
            }
         }
      );

      container.add( popButton );     

      // button to look at top element of stack
      JButton peekButton = new JButton( "Peek" );

      peekButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // look at top object on Stack
               try {
                  statusLabel.setText( "Top: " + stack.peek() );
               }

               // process exception if Stack empty
               catch ( EmptyStackException exception ) {
                  statusLabel.setText( exception.toString() );
               }
            }
         }
      );

      container.add( peekButton );     

      // button to determine whether stack is empty
      JButton emptyButton = new JButton( "Is Empty?" );

      emptyButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // determine if Stack is empty
               statusLabel.setText( stack.empty() ? 
                  "Stack is empty" : "Stack is not empty" );
            }
         }
      );

      container.add( emptyButton );   

      // button to determine whether search key is in stack
      JButton searchButton = new JButton( "Search" );

      searchButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // search Stack for specified object
               String searchKey = inputField.getText();
               int result = stack.search( searchKey );

               if ( result == -1 ) 
                  statusLabel.setText( searchKey + " not found" );
               else
                  statusLabel.setText( searchKey + 
                     " found at element " + result );
            }
         }
      );

      container.add( searchButton );  

      // button to display stack contents
      JButton displayButton = new JButton( "Display" );

      displayButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // output Stack contents
               Enumeration enumeration = stack.elements();
               StringBuffer buffer = new StringBuffer();
        
               while ( enumeration.hasMoreElements() )
                  buffer.append( 
                     enumeration.nextElement() ).append( " " );
       
               JOptionPane.showMessageDialog( null,
                   buffer.toString(), "Display",
                   JOptionPane.PLAIN_MESSAGE );
            }
         }
      );

      container.add( displayButton );
      container.add( statusLabel );

      setSize( 675, 100 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      StackTest application = new StackTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class StackTest

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
