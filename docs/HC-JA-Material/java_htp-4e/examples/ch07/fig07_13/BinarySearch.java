// Fig. 7.13: BinarySearch.java
// Binary search of an array

// Java core packages
import java.awt.*;
import java.awt.event.*;
import java.text.*;

// Java extension packages
import javax.swing.*;

public class BinarySearch extends JApplet
   implements ActionListener {

   JLabel enterLabel, resultLabel;
   JTextField enterField, resultField;
   JTextArea output;

   int array[];
   String display = "";

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

      // set up JTextArea for displaying comparison data
      output = new JTextArea( 6, 60 );
      output.setFont( new Font( "Monospaced", Font.PLAIN, 12 ) );
      container.add( output );

      // create array and fill with even integers 0 to 28
      array = new int[ 15 ];

      for ( int counter = 0; counter < array.length; counter++ )
         array[ counter ] = 2 * counter;

   }  // end method init

   // obtain user input and call method binarySearch
   public void actionPerformed( ActionEvent actionEvent )
   {
      // input also can be obtained with enterField.getText()
      String searchKey = actionEvent.getActionCommand();

      // initialize display string for new search
      display = "Portions of array searched\n";

      // perform binary search
      int element =
         binarySearch( array, Integer.parseInt( searchKey ) );

      output.setText( display );

      // display search result
      if ( element != -1 )
         resultField.setText(
            "Found value in element " + element );
      else
         resultField.setText( "Value not found" );

   }  // end method actionPerformed

   // method to perform binary search of an array
   public int binarySearch( int array2[], int key ) 
   {
      int low = 0;                  // low element subscript
      int high = array.length - 1;  // high element subscript
      int middle;                   // middle element subscript

      // loop until low subscript is greater than high subscript
      while ( low <= high ) {

         // determine middle element subscript
         middle = ( low + high ) / 2;

         // display subset of array elements used in this 
         // iteration of binary search loop
         buildOutput( array2, low, middle, high ); 

         // if key matches middle element, return middle location
         if ( key == array[ middle ] )  
            return middle;

         // if key less than middle element, set new high element
         else if ( key < array[ middle ] )
            high = middle - 1;  

         // key greater than middle element, set new low element
         else
            low = middle + 1;   
      }

      return -1;   // key not found
   
   }  // end method binarySearch

   // build row of output showing subset of array elements 
   // currently being processed
   void buildOutput( int array3[], 
      int low, int middle, int high )
   {
      // create 2-digit integer number format
      DecimalFormat twoDigits = new DecimalFormat( "00" );

      // loop through array elements
      for ( int counter = 0; counter < array3.length; 
         counter++ ) {

         // if counter outside current array subset, append
         // padding spaces to String display
         if ( counter < low || counter > high )
            display += "    ";

         // if middle element, append element to String display 
         // followed by asterisk (*) to indicate middle element
         else if ( counter == middle ) 
            display += 
               twoDigits.format( array3[ counter ] ) + "* ";

         // append element to String display 
         else                                          
            display += 
               twoDigits.format( array3[ counter ] ) + "  ";

      }  // end for structure

      display += "\n";
   
   }  // end method buildOutput
   
}  // end class BinarySearch

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
