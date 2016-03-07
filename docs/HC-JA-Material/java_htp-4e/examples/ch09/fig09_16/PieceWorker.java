// Fig. 9.19: PieceWorker.java
// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {
   private double wagePerPiece; // wage per piece output
   private int quantity;        // output for week

   // constructor for class PieceWorker
   public PieceWorker( String first, String last,
      double wage, int numberOfItems )
   {
      super( first, last );  // call superclass constructor
      setWage( wage );
      setQuantity( numberOfItems );
   }
   
   // set PieceWorker's wage
   public void setWage( double wage ) 
   { 
      wagePerPiece = ( wage > 0 ? wage : 0 ); 
   }
   
   // set number of items output
   public void setQuantity( int numberOfItems ) 
   { 
      quantity = ( numberOfItems > 0 ? numberOfItems : 0 ); 
   }
   
   // determine PieceWorker's earnings
   public double earnings()
   { 
      return quantity * wagePerPiece; 
   }
   
   public String toString()
   {
      return "Piece worker: " + super.toString();
   }  

}  // end class PieceWorker


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
