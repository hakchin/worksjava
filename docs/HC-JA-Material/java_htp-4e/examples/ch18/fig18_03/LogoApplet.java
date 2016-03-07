// Fig. 18.4: LogoApplet.java
// Customizing an applet via HTML parameters.
//
// HTML parameter "animationdelay" is an int indicating
// milliseconds to sleep between images (default 50).
//
// HTML parameter "imagename" is the base name of the images
// that will be displayed (i.e., "deitel" is the base name
// for images "deitel0.gif," "deitel1.gif," etc.). The applet
// assumes that images are in an "images" subdirectory of
// the directory in which the applet resides.
//
// HTML parameter "totalimages" is an integer representing the
// total number of images in the animation. The applet assumes
// images are numbered from 0 to totalimages - 1 (default 30).

// Java core packages
import java.awt.*;

// Java extension packages
import javax.swing.*;

public class LogoApplet extends JApplet {  
    
   // obtain parameters from HTML and customize applet
   public void init()
   {
      String parameter;

      // get animation delay from HTML document
      parameter = getParameter( "animationdelay" );

      int animationDelay = ( parameter == null ?
         50 : Integer.parseInt( parameter ) );

      // get base image name from HTML document
      String imageName = getParameter( "imagename" );

      // get total number of images from HTML document
      parameter = getParameter( "totalimages" );

      int totalImages = ( parameter == null ? 
         0 : Integer.parseInt( parameter ) );

      // create instance of LogoAnimator
      LogoAnimator2 animator;

      if ( imageName == null || totalImages == 0 )
         animator = new LogoAnimator2();
      else
         animator = new LogoAnimator2( totalImages, 
            animationDelay, imageName );

      // attach animator to applet and start animation
      getContentPane().add( animator );
      animator.startAnimation();
   
   }  // end method init
   
}  // end class LogoApplet
                                        

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
