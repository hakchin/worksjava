// Fig. 18.2: LogoAnimator.java
// Animation a series of images

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class LogoAnimator extends JPanel
   implements ActionListener {

   protected ImageIcon images[];       // array of images

   protected int totalImages = 30,     // number of images
                 currentImage = 0,     // current image index
                 animationDelay = 50,  // millisecond delay
                 width,                // image width
                 height;               // image height

   protected String imageName = "deitel";  // base image name
   protected Timer animationTimer;  // Timer drives animation

   // initialize LogoAnimator by loading images
   public LogoAnimator()
   {
      initializeAnimation();
   }

   // initialize animation
   protected void initializeAnimation()
   {
      images = new ImageIcon[ totalImages ];

      // load images
      for ( int count = 0; count < images.length; ++count )
         images[ count ] = new ImageIcon( getClass().getResource(
            "images/" + imageName + count + ".gif" ) );
 
      width = images[ 0 ].getIconWidth();   // get icon width
      height = images[ 0 ].getIconHeight(); // get icon height
   }

   // display current image 
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      images[ currentImage ].paintIcon( this, g, 0, 0 );
      currentImage = ( currentImage + 1 ) % totalImages;
   }

   // respond to Timer's event
   public void actionPerformed( ActionEvent actionEvent )
   {
      repaint();  // repaint animator
   }

   // start or restart animation
   public void startAnimation()
   {
      if ( animationTimer == null ) {
         currentImage = 0;  
         animationTimer = new Timer( animationDelay, this );
         animationTimer.start();
      }
      else  // continue from last image displayed
         if ( ! animationTimer.isRunning() )
            animationTimer.restart();
   }

   // stop animation timer
   public void stopAnimation()
   {
      animationTimer.stop();
   }

   // return minimum size of animation
   public Dimension getMinimumSize()
   { 
      return getPreferredSize(); 
   }

   // return preferred size of animation
   public Dimension getPreferredSize()
   {
      return new Dimension( width, height );
   }

   // execute animation in a JFrame
   public static void main( String args[] )
   {
      // create LogoAnimator
      LogoAnimator animation = new LogoAnimator();

      // set up window
      JFrame window = new JFrame( "Animator test" );

      Container container = window.getContentPane();
      container.add( animation );
         
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      // size and display window
      window.pack();
      Insets insets = window.getInsets();

      window.setSize( animation.getPreferredSize().width + 
         insets.left + insets.right,
         animation.getPreferredSize().height +
         insets.top + insets.bottom );

      window.setVisible( true );
      animation.startAnimation();  // begin animation

   }  // end method main

}  // end class LogoAnimator

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
