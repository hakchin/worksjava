// Fig. 6.10: Scoping.java
// A scoping example.

// Java core packages
import java.awt.Container;

// Java extension packages
import javax.swing.*;

public class Scoping extends JApplet {
   JTextArea outputArea;

   // instance variable accessible to all methods of this class
   int x = 1;       

   // set up applet’s GUI
   public void init()
   {
      outputArea = new JTextArea();
      Container container = getContentPane();
      container.add( outputArea );

   }  // end method init

   // method start called after init completes; start calls
   // methods useLocal and useInstance
   public void start()
   {
      int x = 5;   // variable local to method start

      outputArea.append( "local x in start is " + x );

      useLocal();      // useLocal has local x
      useInstance();   // useInstance uses instance variable x
      useLocal();      // useLocal reinitializes local x
      useInstance();   // instance variable x retains its value

      outputArea.append( "\n\nlocal x in start is " + x );

   }  // end method start

   // useLocal reinitializes local variable x during each call
   public void useLocal()
   {
      int x = 25;  // initialized each time useLocal is called

      outputArea.append( "\n\nlocal x in useLocal is " + x +
         " after entering useLocal" );
      ++x;
      outputArea.append( "\nlocal x in useLocal is " + x +
         " before exiting useLocal" );

   }  // end method useLocal

   // useInstance modifies instance variable x during each call
   public void useInstance()
   {
      outputArea.append( "\n\ninstance variable x is " + x +
                          " on entering useInstance" );
      x *= 10;
      outputArea.append( "\ninstance variable x is " + x +
                          " on exiting useInstance" );

   }  // end method useInstance

}  // end class Scoping

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
