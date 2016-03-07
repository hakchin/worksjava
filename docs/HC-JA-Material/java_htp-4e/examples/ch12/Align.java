// Exercise 10.9 Solution
// Align.java
// This program creates a simple GUI
import java.awt.*;
import javax.swing.*;

public class Align extends JFrame {
   private JButton ok, cancel, help; 
   private JTextField xValue, yValue;
   private JCheckBox snap, show;
   private JLabel xLabel, yLabel;
   private JPanel checkPanel, buttonPanel,
                 fieldPanel1, fieldPanel2,
                 fieldPanel;

   public Align()
   {
      super( "Align" );

      // build checkPanel
      snap = new JCheckBox( "Snap to Grid" );
      show = new JCheckBox( "Show Grid" );
      checkPanel = new JPanel();
      checkPanel.setLayout( new GridLayout( 2 , 1 ) );
      checkPanel.add( snap );
      checkPanel.add( show );

      // build field panel1
      xLabel = new JLabel( "X: " );
      xValue = new JTextField( "8", 3 );
      fieldPanel1 = new JPanel();
      fieldPanel1.setLayout( new FlowLayout( FlowLayout.CENTER, 3, 5 ) );
      fieldPanel1.add( xLabel );
      fieldPanel1.add( xValue );

      yLabel = new JLabel( "Y: " );
      yValue = new JTextField( "8", 3 );
      fieldPanel2 = new JPanel();
      fieldPanel2.setLayout( new FlowLayout( FlowLayout.CENTER, 3, 5 ) );
      fieldPanel2.add( yLabel );
      fieldPanel2.add( yValue );

      fieldPanel = new JPanel();
      fieldPanel.setLayout( new BorderLayout() );
      fieldPanel.add( fieldPanel1, BorderLayout.NORTH );
      fieldPanel.add( fieldPanel2, BorderLayout.SOUTH );
      
      // build button panel
      ok = new JButton( "Ok" );
      cancel = new JButton( "Cancel" );
      help = new JButton( "Help" );
      buttonPanel = new JPanel();
      buttonPanel.setLayout( new GridLayout( 3, 1, 10, 5 ) );
      buttonPanel.add( ok );
      buttonPanel.add( cancel );
      buttonPanel.add( help );

      // set layout for applet
      getContentPane().setLayout( new FlowLayout( FlowLayout.CENTER, 10, 5 ) );
      getContentPane().add( checkPanel );
      getContentPane().add( fieldPanel );
      getContentPane().add( buttonPanel );

      setSize( 300, 125 );
      show();
   }

   public static void main( String args[] )
   {
      new Align();
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
