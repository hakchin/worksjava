// Exercise 10.11 solution
// ColorSelect.java
// This program creates a simple GUI
import java.awt.*;
import javax.swing.*;

public class ColorSelect extends JFrame {
   private JButton ok, cancel; 
   private JCheckBox b, f;
   private JComboBox colorList;
   private JPanel p, p1;

   public ColorSelect()
   {
      super( "ColorSelect" );

      // north
      colorList = new JComboBox();
      colorList.addItem( "RED" );
      getContentPane().add( colorList, BorderLayout.NORTH );

      // center
      p = new JPanel();
      b = new JCheckBox( "background" );
      f = new JCheckBox( "foreground" );
      p.add( b );
      p.add( f );
      getContentPane().add( p, BorderLayout.CENTER );

      // south
      ok = new JButton( "Ok" );
      cancel = new JButton( "Cancel" );
      p1 = new JPanel();
      p1.add( ok );
      p1.add( cancel );
      getContentPane().add( p1, BorderLayout.SOUTH );

      setSize( 300, 125 );
      show();
   }

   public static void main( String args[] )
   {
      new ColorSelect();
   }
}


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
