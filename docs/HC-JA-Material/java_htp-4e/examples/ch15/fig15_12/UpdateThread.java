// Fig. 15.12: UpdateThread.java
// Class for updating JTextArea with output.

// Java extension packages
import javax.swing.*;

public class UpdateThread extends Thread {
   private JTextArea outputArea;
   private String messageToOutput;
  
   // initialize outputArea and message
   public UpdateThread( JTextArea output, String message )
   {
      outputArea = output;
      messageToOutput = message;
   }

   // method called to update outputArea
   public void run()
   {
      outputArea.append( messageToOutput );
   }

}  // end class UpdateThread


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
