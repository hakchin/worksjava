// Fig. 8.11: Increment.java
// Initializing a final variable

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class Increment extends JApplet
   implements ActionListener {

   private int count = 0, total = 0;
   private final int INCREMENT ;//= 5;   // constant variable
  
   private JButton button;  

   // set up GUI
   public void init() 
   { 
      Container container = getContentPane();

      button = new JButton( "Click to increment" );
      button.addActionListener( this );
      container.add( button );
   }

   // add INCREMENT to total when user clicks button
   public void actionPerformed( ActionEvent actionEvent )
   {
      total += INCREMENT;
      count++;
      showStatus( "After increment " + count +
         ": total = " + total );
   }

}  // end class Increment

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
