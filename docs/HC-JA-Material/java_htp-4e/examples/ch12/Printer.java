// Exercise 10.12 Solution
// Printer.java
// This program creates a simple GUI
// html: width = 400 height = 130
import java.awt.*;
import javax.swing.*;

public class Printer extends JFrame {
   private JButton b1, b2, b3, b4; 
   private JCheckBox c1, c2, c3, c4;
   private JRadioButton c5, c6, c7;
   private JComboBox q;
   private JLabel label1, label2;
   private JPanel p1, p2, p3, p4, p5, p6, p7, p8;
   private ButtonGroup cbg;
 
   public Printer()
   {
      super( "Printer" );

      // build left north panel
      label1 = new JLabel( "Printer:  MyPrinter" );
      p1 = new JPanel();
      p1.setLayout( new FlowLayout( FlowLayout.LEFT ) );
      p1.add( label1 );

      // build right east panel
      b1 = new JButton( "Ok" );
      b2 = new JButton( "Cancel" );
      b3 = new JButton( "Setup..." );
      b4 = new JButton( "Help" );
      p2 = new JPanel();
      p2.setLayout( new GridLayout( 4, 1, 5, 5 ) );
      p2.add( b1 );
      p2.add( b2 );
      p2.add( b3 );
      p2.add( b4 );

      // build left south panel
      label2 = new JLabel( "Print Quality: " );
      q = new JComboBox();
      q.addItem( "High" );
      c1 = new JCheckBox( "Print to File" );
      p3 = new JPanel();
      p3.setLayout( new FlowLayout( FlowLayout.LEFT, 10, 0 ) );
      p3.add( label2 );
      p3.add( q );
      p3.add( c1 );

      // build left east panel
      c2 = new JCheckBox( "Image" );
      c3 = new JCheckBox( "Text" );
      c4 = new JCheckBox( "Code" );
      p4 = new JPanel();
      p4.setLayout( new BorderLayout( ) );
      p4.add( c2, BorderLayout.NORTH );
      p4.add( c3, BorderLayout.CENTER );
      p4.add( c4, BorderLayout.SOUTH );

      // build left west panel
      cbg = new ButtonGroup();
      p5 = new JPanel();
      p5.setLayout( new BorderLayout() );
      p5.add( c5 = new JRadioButton( "Selection" ),
              BorderLayout.NORTH );
      p5.add( c6 = new JRadioButton( "All" ),
              BorderLayout.CENTER );
      p5.add( c7 = new JRadioButton( "Applet" ),
              BorderLayout.SOUTH );
      c6.setSelected( true );

      // build left center
      p8 = new JPanel();
      p8.setLayout( new FlowLayout( FlowLayout.CENTER, 30, 0 ) );
      p8.setBackground( Color.white );
      p8.add( p4 );
      p8.add( p5 );


      // setup left panel
      p6 = new JPanel();
      p6.setLayout( new BorderLayout() );
      p6.add( p1, BorderLayout.NORTH );
      p6.add( p8, BorderLayout.CENTER );
      p6.add( p3, BorderLayout.SOUTH );

      // setup applet layout
      p7 = new JPanel();
      p7.setLayout( new FlowLayout( FlowLayout.CENTER, 10, 0 ) );
      p7.add( p6 );
      p7.add( p2 );
      getContentPane().add( p7 );

      setSize( 400, 155 );
      show();
   }

   public static void main( String args[] )
   {
      new Printer();
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
