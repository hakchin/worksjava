// Fig. 20.1: VectorTest.java
// Testing the Vector class of the java.util package

// Java core packages
import java.util.*;
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class VectorTest extends JFrame {
   private JLabel statusLabel;
   private Vector vector;
   private JTextField inputField;

   // set up GUI to test Vector methods
   public VectorTest()
   {
      super( "Vector Example" );

      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      statusLabel = new JLabel();
      vector = new Vector( 1 );            

      container.add( new JLabel( "Enter a string" ) );

      inputField = new JTextField( 10 );
      container.add( inputField );       

      // button to add element to vector
      JButton addButton = new JButton( "Add" );

      addButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // add an element to vector   
               vector.addElement( inputField.getText() );
               statusLabel.setText( "Added to end: " +
                  inputField.getText() );
               inputField.setText( "" ); 
            }
         }
      );         

      container.add( addButton ); 

      // button to remove element from vector
      JButton removeButton = new JButton( "Remove" );

      removeButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // remove element from vector
               if ( vector.removeElement( inputField.getText() ) )
                  statusLabel.setText( "Removed: " +
                     inputField.getText() );
               else
                  statusLabel.setText( inputField.getText() +
                     " not in vector" );
            }
         }
      );

      container.add( removeButton );   

      // button to get first element of vector
      JButton firstButton = new JButton( "First" );

      firstButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // return first element of vector
               try {
                  statusLabel.setText( 
                     "First element: " + vector.firstElement() );
               }

               // catch exception if Vector empty
               catch ( NoSuchElementException exception ) {
                  statusLabel.setText( exception.toString() );
               }
            }
         }
      );

      container.add( firstButton );    

      // button to get last element of vector
      JButton lastButton = new JButton( "Last" );

      lastButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // return last element of vector
               try {
                  statusLabel.setText( 
                     "Last element: " + vector.lastElement() );
               }

               // catch exception if Vector empty
               catch ( NoSuchElementException exception ) {
                  statusLabel.setText( exception.toString() );
               }
            }
         }
      );

      container.add( lastButton );     

      // button to determine whether vector is empty
      JButton emptyButton = new JButton( "Is Empty?" );

      emptyButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // determine if Vector is empty
               statusLabel.setText( vector.isEmpty() ?
                  "Vector is empty" : "Vector is not empty" );
            }
         }
      );

      container.add( emptyButton );    

      // button to determine whether vector contains search key
      JButton containsButton = new JButton( "Contains" );

      containsButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               String searchKey = inputField.getText();

               // determine if Vector contains searchKey
               if ( vector.contains( searchKey ) ) 
                  statusLabel.setText(
                     "Vector contains " + searchKey );
               else
                  statusLabel.setText( 
                     "Vector does not contain " + searchKey );
            }
         }
      );

      container.add( containsButton ); 

      // button to determine location of value in vector
      JButton locationButton = new JButton( "Location" );

      locationButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // get location of an object in Vector
               statusLabel.setText( "Element is at location " +
                  vector.indexOf( inputField.getText() ) );
            }
         }
      );

      container.add( locationButton );

      // button to trim vector size
      JButton trimButton = new JButton( "Trim" );

      trimButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // remove unoccupied elements to save memory
               vector.trimToSize();
               statusLabel.setText( "Vector trimmed to size" );
            }
         }
      );

      container.add( trimButton );     

      // button to display vector size and capacity
      JButton statsButton = new JButton( "Statistics" );

      statsButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // get size and capacity of Vector
               statusLabel.setText( "Size = " + vector.size() +
                  "; capacity = " + vector.capacity() );
            }
         }
      );

      container.add( statsButton );    

      // button to display vector contents
      JButton displayButton = new JButton( "Display" );

      displayButton.addActionListener(

         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               // use Enumeration to output Vector contents
               Enumeration enum = vector.elements();
               StringBuffer buffer = new StringBuffer();
        
               while ( enum.hasMoreElements() )
                  buffer.append( enum.nextElement() ).append( "  " );

               JOptionPane.showMessageDialog( null,
                  buffer.toString(), "Display",
                  JOptionPane.PLAIN_MESSAGE );
            }
         }
      );

      container.add( displayButton );
      container.add( statusLabel );

      setSize( 300, 200 );
      setVisible( true );

   }  // end VectorTest constructor

   // execute application
   public static void main( String args[] )
   {
      VectorTest application = new VectorTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class VectorTest


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
