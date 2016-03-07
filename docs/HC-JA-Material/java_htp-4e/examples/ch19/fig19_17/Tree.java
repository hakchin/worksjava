// Fig. 19.17: Tree.java
// Definition of class TreeNode and class Tree.

// Deitel packages
package com.deitel.jhtp4.ch19;

// class TreeNode definition
class TreeNode {

   // package access members
   TreeNode leftNode;   
   int data;        
   TreeNode rightNode;  

   // initialize data and make this a leaf node
   public TreeNode( int nodeData )
   { 
      data = nodeData;              
      leftNode = rightNode = null;  // node has no children
   }

   // insert TreeNode into Tree that contains nodes;
   // ignore duplicate values
   public synchronized void insert( int insertValue )
   {
      // insert in left subtree
      if ( insertValue < data ) {

         // insert new TreeNode
         if ( leftNode == null )
            leftNode = new TreeNode( insertValue );

         // continue traversing left subtree
         else
            leftNode.insert( insertValue );
      }

      // insert in right subtree
      else if ( insertValue > data ) {

         // insert new TreeNode
         if ( rightNode == null )
            rightNode = new TreeNode( insertValue );

         // continue traversing right subtree
         else
            rightNode.insert( insertValue );
      }

   }  // end method insert

}  // end class TreeNode

// class Tree definition
public class Tree {
   private TreeNode root;

   // construct an empty Tree of integers
   public Tree() 
   { 
      root = null; 
   }

   // Insert a new node in the binary search tree.
   // If the root node is null, create the root node here.
   // Otherwise, call the insert method of class TreeNode.
   public synchronized void insertNode( int insertValue )
   {
      if ( root == null )
         root = new TreeNode( insertValue );

      else
         root.insert( insertValue );
   }

   // begin preorder traversal
   public synchronized void preorderTraversal()
   { 
      preorderHelper( root ); 
   }

   // recursive method to perform preorder traversal
   private void preorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      // output node data
      System.out.print( node.data + " " );  

      // traverse left subtree
      preorderHelper( node.leftNode );     

      // traverse right subtree
      preorderHelper( node.rightNode );     
   }

   // begin inorder traversal
   public synchronized void inorderTraversal()
   { 
      inorderHelper( root ); 
   }

   // recursive method to perform inorder traversal
   private void inorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      // traverse left subtree
      inorderHelper( node.leftNode );

      // output node data
      System.out.print( node.data + " " );

      // traverse right subtree
      inorderHelper( node.rightNode );
   }

   // begin postorder traversal
   public synchronized void postorderTraversal()
   { 
      postorderHelper( root ); 
   }

   // recursive method to perform postorder traversal
   private void postorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      // traverse left subtree
      postorderHelper( node.leftNode );

      // traverse right subtree
      postorderHelper( node.rightNode );

      // output node data
      System.out.print( node.data + " " );
   }

}  // end class Tree

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
