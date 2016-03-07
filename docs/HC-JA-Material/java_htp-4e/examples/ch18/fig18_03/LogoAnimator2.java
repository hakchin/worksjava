// Fig. 18.3: LogoAnimator2.java
// Animating a series of images

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class LogoAnimator2 extends LogoAnimator {

   // default constructor
   public LogoAnimator2()
   {
      super();
   }

   // new constructor to support customization 
   public LogoAnimator2( int count, int delay, String name )
   {
      totalImages = count;
      animationDelay = delay;
      imageName = name;

      initializeAnimation();
   }

   // start animation as application in its own window
   public static void main( String args[] )
   {
      // create LogoAnimator
      LogoAnimator2 animation = new LogoAnimator2();

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

}  // end class LogoAnimator2

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
