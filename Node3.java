
//Luis Lopez
//Assignment 3

class Node3
   {
   public char charData;              // char data item (key)
 
   public Node3 leftChild;         // this node's left child
   public Node3 rightChild;        // this node's right child
   public Node3 parent;			//this node's parent
   public int height;

   public void displayNode()      // display yourself
      {
      System.out.print('{');
      System.out.print(charData);
      System.out.print("}");
      }
   }  // end class Node