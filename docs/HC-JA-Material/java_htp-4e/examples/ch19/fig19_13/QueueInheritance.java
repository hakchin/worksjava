// Fig. 19.12: QueueInheritance.java
// Class QueueInheritance extends class List

// Deitel packages
package com.deitel.jhtp4.ch19;

public class QueueInheritance extends List {

   // construct queue
   public QueueInheritance() 
   { 
      super( "queue" ); 
   }

   // add object to queue
   public synchronized void enqueue( Object object )
   { 
      insertAtBack( object ); 
   }

   // remove object from queue
   public synchronized Object dequeue() throws EmptyListException
   { 
      return removeFromFront(); 
   }

}  // end class QueueInheritance


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
