// Fig. 7.12: LinearSearch.java
// Linear search of an array

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class LinearSearch extends JApplet
   implements ActionListener {

   JLabel enterLabel, resultLabel;
   JTextField enterField, resultField;
   int array[];

   // set up applet's GUI
   public void init()
   {
      // get content pane and set its layout to FlowLayout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // set up JLabel and JTextField for user input
      enterLabel = new JLabel( "Enter integer search key" );
      container.add( enterLabel );

      enterField = new JTextField( 10 );
      container.add( enterField );

      // register this applet as enterField's action listener
      enterField.addActionListener( this );

      // set up JLabel and JTextField for displaying results
      resultLabel = new JLabel( "Result" );
      container.add( resultLabel );

      resultField = new JTextField( 20 );
      resultField.setEditable( false );
      container.add( resultField );

      // create array and populate with even integers 0 to 198
      array = new int[ 100 ];

      for ( int counter = 0; counter < array.length; counter++ )
         array[ counter ] = 2 * counter;

   }  // end method init

   // Search array for specified key value
   public int linearSearch( int array2[], int key ) 
   {   
      // loop through array elements
      for ( int counter = 0; counter < array2.length; counter++ )

         // if array element equals key value, return location
         if ( array2[ counter ] == key )
            return counter;

      return -1;  // key not found
   }

   // obtain user input and call method linearSearch
   public void actionPerformed( ActionEvent actionEvent )
   {
      // input also can be obtained with enterField.getText()
      String searchKey = actionEvent.getActionCommand();

      // Array a is passed to linearSearch even though it
      // is an instance variable. Normally an array will
      // be passed to a method for searching.
      int element =
         linearSearch( array, Integer.parseInt( searchKey ) );

      // display search result
      if ( element != -1 )
         resultField.setText( "Found value in element " + 
            element );
      else
         resultField.setText( "Value not found" );
   }

}  // end class LinearSearch

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
