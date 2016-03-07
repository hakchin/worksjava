// Fig. 20.3: HashtableTest.java
// Demonstrates class Hashtable of the java.util package.

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Java extensions packages
import javax.swing.*;

public class HashtableTest extends JFrame {
   private JLabel statusLabel;
   private Hashtable table;
   private JTextArea displayArea;
   private JTextField lastNameField;
   private JTextField firstNameField;

   // set up GUI to demonstrate Hashtable features
   public HashtableTest()
   {
      super( "Hashtable Example" );

      statusLabel = new JLabel();
      table = new Hashtable();
      displayArea = new JTextArea( 4, 20 );
      displayArea.setEditable( false );

      JPanel northSubPanel = new JPanel();

      northSubPanel.add( new JLabel( "First name" ) );
      firstNameField = new JTextField( 8 );
      northSubPanel.add( firstNameField );

      northSubPanel.add( new JLabel( "Last name (key)" ) );
      lastNameField = new JTextField( 8 );
      northSubPanel.add( lastNameField );

      JPanel northPanel = new JPanel();
      northPanel.setLayout( new BorderLayout() );
      northPanel.add( northSubPanel, BorderLayout.NORTH );
      northPanel.add( statusLabel, BorderLayout.SOUTH );

      JPanel southPanel = new JPanel();
      southPanel.setLayout( new GridLayout( 2, 5 ) );
      JButton putButton = new JButton( "Put" );

      putButton.addActionListener(

         new ActionListener() {

            // add new key/value pair to hash table
            public void actionPerformed( ActionEvent event )
            {
               Employee employee = new Employee(
                  firstNameField.getText(), 
                  lastNameField.getText() );

               Object value = 
                  table.put( lastNameField.getText(), employee );

               // first time this key was added
               if ( value == null )
                  statusLabel.setText( 
                     "Put: " + employee.toString() );

               // replaced previous value for this key
               else
                  statusLabel.setText( 
                     "Put: " + employee.toString() +
                     "; Replaced: " + value.toString() );
            }
         }
      );

      southPanel.add( putButton );

      // button to get value for specific key
      JButton getButton = new JButton( "Get" );

      getButton.addActionListener(

         new ActionListener() {

            // get value for specific key
            public void actionPerformed( ActionEvent event )
            {
               Object value = table.get( lastNameField.getText() );
             
               // value found for key
               if ( value != null )
                  statusLabel.setText( 
                     "Get: " + value.toString() );
             
               // value not found for key
               else
                  statusLabel.setText( 
                     "Get: " + lastNameField.getText() +
                     " not in table" );
            }
         }
      );

      southPanel.add( getButton );

      // button to remove key/value pair from table
      JButton removeButton = new JButton( "Remove" );

      removeButton.addActionListener(

         new ActionListener() {

            // remove key/value pair
            public void actionPerformed( ActionEvent event )
            {
               Object value = 
                  table.remove( lastNameField.getText() );
             
               // key found
               if ( value != null )
                  statusLabel.setText( "Remove: " + 
                     value.toString() );
             
               // key not found
               else
                  statusLabel.setText( "Remove: " + 
                     lastNameField.getText() + " not in table" );
            }
         }
      );

      southPanel.add( removeButton );

      // button to detetmine whether hash table is empty
      JButton emptyButton = new JButton( "Empty" );

      emptyButton.addActionListener(

         new ActionListener() {

            // determine whether hash table is empty
            public void actionPerformed( ActionEvent event )
            {
               statusLabel.setText( "Empty: " + table.isEmpty() );
            }
         }
      );

      southPanel.add( emptyButton );

      // button to determine whether hash table contains key
      JButton containsKeyButton = new JButton( "Contains key" );

      containsKeyButton.addActionListener(

         new ActionListener() {

            // determine whether hash table contains key
            public void actionPerformed( ActionEvent event )
            {
               statusLabel.setText( "Contains key: " +
                  table.containsKey( lastNameField.getText() ) );
            }
         }
      );

      southPanel.add( containsKeyButton );

      // button to clear all hash table contents
      JButton clearButton = new JButton( "Clear table" );

      clearButton.addActionListener(

         new ActionListener() {

            // clear hash table contents 
            public void actionPerformed( ActionEvent event )
            {
               table.clear();
               statusLabel.setText( "Clear: Table is now empty" );
            }
         }
      );

      southPanel.add( clearButton );

      // button to display hash table elements
      JButton listElementsButton = new JButton( "List objects" );

      listElementsButton.addActionListener(

         new ActionListener() {

            // display hash table elements
            public void actionPerformed( ActionEvent event )
            {
               StringBuffer buffer = new StringBuffer();

               for ( Enumeration enumeration = table.elements();
                     enumeration.hasMoreElements(); )
                  buffer.append(
                     enumeration.nextElement() ).append( '\n' );

               displayArea.setText( buffer.toString() );
            }
         }
      );

      southPanel.add( listElementsButton );

      // button to display hash table keys
      JButton listKeysButton = new JButton( "List keys" );

      listKeysButton.addActionListener(

         new ActionListener() {

            // display hash table KEYS
            public void actionPerformed( ActionEvent event )
            {
               StringBuffer buffer = new StringBuffer();

               for ( Enumeration enumeration = table.keys();
                     enumeration.hasMoreElements(); )
                  buffer.append(
                     enumeration.nextElement() ).append( '\n' );

                  JOptionPane.showMessageDialog( null,
                     buffer.toString(), "Display",
                     JOptionPane.PLAIN_MESSAGE );
            }
         }
      );

      southPanel.add( listKeysButton );

      Container container = getContentPane();
      container.add( northPanel, BorderLayout.NORTH );
      container.add( new JScrollPane( displayArea ), 
         BorderLayout.CENTER );
      container.add( southPanel, BorderLayout.SOUTH );

      setSize( 540, 300 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   {
      HashtableTest application = new HashtableTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class HashtableTest

// Employee class to represent first and last name
class Employee {
   private String first, last;

   // initialize an Employee
   public Employee( String firstName, String lastName )
   {
      first = firstName;
      last = lastName;
   }

   // convert Employee to String representation
   public String toString() 
   { 
      return first + " " + last; 
   }

}  // end class Employee


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
