import java.util.Stack;

//Luis Lopez
//Assignment 3



class Tree3
   {
   private Node3 root;             // first node of tree

// -------------------------------------------------------------
   public Tree3()                  // constructor
      { root = null; }            // no nodes in tree yet
// -------------------------------------------------------------

   public Node3 getroot() {//getRoot method
	   
	   return root;
   }
   
// -------------------------------------------------------------
   public Node3 find(char key)      // find node with given key
      {                           // (assumes non-empty tree)
      Node3 current = root;               // start at root
      while(current.charData != key)        // while no match,
         {
         if(key < current.charData)         // go left?
            current = current.leftChild;
         else                            // or go right?
            current = current.rightChild;
         if(current == null)             // if no child,
            return null;                 // didn't find it
         }
      return current;                    // found it
      }  // end find()
// -------------------------------------------------------------
   public int Max(int a, int b)//returns max number
   {
	   
	   if(a > b)
		   return a;
	   else
		   return b;
	   
	   
   }
// -------------------------------------------------------------
   public boolean checkVowel(char letter) 
   {
	   
	   switch(letter) //If char is a vowel, return true.
	   {
	   
	   case 'A':
	   case 'E':
	   case 'I':
	   case 'O':
	   case 'U':
		   return true;
	    
	   }
	   
	   
	   return false;//Only executes if vowel was not found, so its a consonant and return false.
   }
// -------------------------------------------------------------
   public Node3 findParentSibling(Node3 parentNode)
   {
	   if(parentNode.parent == null)
		   return null;
	   else if(parentNode.parent == null)
		   return null;
	   
	   
	   if(parentNode.parent.leftChild == parentNode)//if parent is left child of its parent/root
	   {
		   
		   if(parentNode.parent.rightChild == null) //if parent's sibling is null, return null.
		   {
			   
			   return null;
			   
		   }
		   else//if not null, return the sibling.
		   {
			   
			   return parentNode.parent.rightChild;
			   
		   }
		   
	   }
	   else if(parentNode.parent.rightChild == parentNode)//if parent is right child of its parent/root
	   {
		   
		   if(parentNode.parent.leftChild == null) //if parent's sibling is null, return null.
		   {
			   
			   return null;
			   
		   }
		   else//if not null, return the sibling.
		   {
			   
			   return parentNode.parent.leftChild;
			   
		   }
		   
	   }
	   
	   return null;
	   
   }

   
// -------------------------------------------------------------
   
   public void insert3( char id, nodeQueue extraNode) //Modified with extra rules from the assignment.
   {
	   Node3 newNodeZ = new Node3();    // make new node
	   newNodeZ.charData = id;// insert letter to new node's attribute
	   
	   Node3 parentofCurrentY = null; //"trailing pointer" to keep track of parent of current pointer
	   Node3 currentX = root; //pointer: traces the downward path
	   
	   while(currentX != null)//checks if Tree root is not empty
	   {
		   
		   parentofCurrentY = currentX;//starts at root
		   
		   
		   if(newNodeZ.charData < currentX.charData)//go left?
		   {
			   currentX = currentX.leftChild;//pointer traces down left
		   }
		   else//go right
		   {
			   currentX = currentX.rightChild;//pointer traces down right
		   }
		   
	   }
	   
	   newNodeZ.parent = parentofCurrentY;//stores "trailer pointer" to the newNode's parent
	   
	   if(parentofCurrentY == null)//check if "trailer pointer" is null, if so it means that the Tree is empty.
	   {
		   root = newNodeZ;//newNode becomes the root
		   return;
		   
	   }
	   else if(newNodeZ.charData <= parentofCurrentY.charData)//go left?  equal sign means that duplicates will be placed as left childs.
	   {
		   
		   
		   if(checkVowel(newNodeZ.parent.charData) == false && (newNodeZ.parent.charData != newNodeZ.charData))//If child and parent are consonants but not duplicate, safe to insert to Tree
		   {
			   
			   parentofCurrentY.leftChild = newNodeZ;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) == null)//check if uncle is null
		   {
			   
			  return;
		   }
		   else if((checkVowel(newNodeZ.charData) == true && checkVowel(newNodeZ.parent.charData) == true) && checkVowel(findParentSibling(newNodeZ.parent).charData) == true)//Child and Parent are vowels, and so is the uncle, then its safe to insert to Tree.
		   {
			   
			   parentofCurrentY.leftChild = newNodeZ;
			   
		   }
		   
		   
		   if(checkVowel(newNodeZ.parent.charData) == false && (newNodeZ.parent.charData == newNodeZ.charData))//If child and parent are consonants but duplicates, cannot be inserted and instead get inserted in nodeQueue
		   {
			   
			   extraNode.insert(newNodeZ);
			   
			   return;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) == null)//check if uncle is null
		   {
			   
			  return;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) != null)
		   {
			   
			   if( (checkVowel(newNodeZ.charData) == true && checkVowel(newNodeZ.parent.charData) == true) && checkVowel(findParentSibling(newNodeZ.parent).charData) == false )//If child and parent are vowels, but parent's sibling is NOT a vowel, insert in nodeQueue
			   {
				   
				   extraNode.insert(newNodeZ);
				   
				   return;
				   
			   }
			   
		   }
		   
		   
		   
		   
   		
	   }
	   else//go right
	   {
		   
		   
		   if(checkVowel(newNodeZ.parent.charData) == false && (newNodeZ.parent.charData != newNodeZ.charData))//If child and parent are consonants but not duplicate, safe to insert to Tree
		   {
			   
			   parentofCurrentY.rightChild = newNodeZ;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) == null)//check if uncle is null
		   {
			   
			  return;
		   }
		   else if((checkVowel(newNodeZ.charData) == true && checkVowel(newNodeZ.parent.charData) == true) && checkVowel(findParentSibling(newNodeZ.parent).charData) == true)//Child and Parent are vowels, and so is the uncle, then its safe to insert to Tree.
		   {
			   
			   parentofCurrentY.rightChild = newNodeZ;
			   
		   }
		   
		   
		   if(checkVowel(newNodeZ.parent.charData) == false && (newNodeZ.parent.charData == newNodeZ.charData))//If child and parent are consonants, cannot be inserted and instead get inserted in nodeQueue
		   {
			   
			   extraNode.insert(newNodeZ);
			   
			   return;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) == null)
		   {
			   
			  return;
			   
		   }
		   else if(findParentSibling(newNodeZ.parent) != null)
		   {
			   
			   if( (checkVowel(newNodeZ.charData) == true && checkVowel(newNodeZ.parent.charData) == true) && checkVowel(findParentSibling(newNodeZ.parent).charData) == false )//If child and parent are vowels, but parent's sibling is NOT a vowel, insert in nodeQueue
			   {
				   
				   extraNode.insert(newNodeZ);
				   
				   return;
				   
			   }
			   
		   }
		  
 	
		   
		   
	   }
   
 
      }  // end insert()
// -------------------------------------------------------------
   public void insertLeftOvers(Node3 rootNode, nodeQueue extraNodes, nodeQueue insertQueue)
   {

	   
	   
		   insertQueue.insert(rootNode);//start by inserting root into queue
		   
		   while(extraNodes.isEmpty() != true)
		   {

			   	
				Node3 temp = insertQueue.remove();//dequeue node
				
				if(temp.leftChild != null)//if node is not null, insert node into queue to continue iterating through tree
				{
					

					insertQueue.insert(temp.leftChild);
					
					
				}
				else if(temp.leftChild == null)//if node is null, that is the first available space to insert left over data, then insert that node into queue to continue iterating through tree
				{
					
					temp.leftChild = extraNodes.remove();
					insertQueue.insert(temp.leftChild);
					
				}
				   
				if(extraNodes.isEmpty())//if queue of extra nodes is empty, exit method since we are done.
					break;
				
				if(temp.rightChild != null)//if node is not null, insert node into queue to continue iterating through tree
				{
					
					insertQueue.insert(temp.rightChild);
						
				}
				else if(temp.rightChild == null)//if node is null, that is the first available space to insert left over data, then insert that node into queue to continue iterating through tree
				{
					
					temp.rightChild = extraNodes.remove();
					insertQueue.insert(temp.rightChild);
					
				}
				
		   }
	   
	   
	   
   }
// -------------------------------------------------------------
   public void computeNodeHeights(Node3 localRoot) {//Root height will be the highest number, since its the one that takes the most edges to reach the leaves.
	   
	   if(localRoot == null)//Tree is empty
       {
		   return;
       }
	   
	   computeNodeHeights(localRoot.leftChild); //Traverse the left subtree
	   computeNodeHeights(localRoot.rightChild);//Traverse the right subtree
	   
	   if(localRoot.leftChild == null && localRoot.rightChild == null)//node is leaf, so height is set to 0
	   {
		   
		   localRoot.height = 0;
		   
	   }
	   else if(localRoot.leftChild != null && localRoot.rightChild != null)//node is not a leaf, so height increased by 1 depending on which child's height is bigger
	   {
		   
		   localRoot.height = Max(localRoot.leftChild.height, localRoot.rightChild.height) + 1;
		   
	   }
	   else if(localRoot.leftChild == null && localRoot.rightChild.height != localRoot.height)//when node is not leaf but left child is null and right child is not null but right child's height is not equal to node's height, then increase right child's height by 1
	   {
		   
		   localRoot.rightChild.height += 1;
		   
	   }
	   else if(localRoot.rightChild == null && localRoot.leftChild.height != localRoot.height)//when node is not leaf but right child is null and left child is not null but left child's height is not equal to node's height, then increase left child's height by 1
	   {
		   
		   localRoot.leftChild.height += 1;
		   
	   }
	   
	   
	   System.out.printf("Node %s: %d %n", localRoot.charData, localRoot.height);//print every node's character and its height
	   
  }
// -------------------------------------------------------------
   public boolean delete(char key) // delete node with given key
      {                           // (assumes non-empty list)
      Node3 current = root;
      Node3 parent = root;
      boolean isLeftChild = true;

      while(current.charData != key)        // search for node
         {
         parent = current;
         if(key < current.charData)         // go left?
            {
            isLeftChild = true;
            current = current.leftChild;
            }
         else                            // or go right?
            {
            isLeftChild = false;
            current = current.rightChild;
            }
         if(current == null)             // end of the line,
            return false;                // didn't find it
         }  // end while
      // found node to delete

      // if no children, simply delete it
      if(current.leftChild==null &&
                                   current.rightChild==null)
         {
         if(current == root)             // if root,
            root = null;                 // tree is empty
         else if(isLeftChild)
            parent.leftChild = null;     // disconnect
         else                            // from parent
            parent.rightChild = null;
         }

      // if no right child, replace with left subtree
      else if(current.rightChild==null)
         if(current == root)
            root = current.leftChild;
         else if(isLeftChild)
            parent.leftChild = current.leftChild;
         else
            parent.rightChild = current.leftChild;

      // if no left child, replace with right subtree
      else if(current.leftChild==null)
         if(current == root)
            root = current.rightChild;
         else if(isLeftChild)
            parent.leftChild = current.rightChild;
         else
            parent.rightChild = current.rightChild;

      else  // two children, so replace with inorder successor
         {
         // get successor of node to delete (current)
         Node3 successor = getSuccessor(current);

         // connect parent of current to successor instead
         if(current == root)
            root = successor;
         else if(isLeftChild)
            parent.leftChild = successor;
         else
            parent.rightChild = successor;

         // connect successor to current's left child
         successor.leftChild = current.leftChild;
         }  // end else two children
      // (successor cannot have a left child)
      return true;                                // success
      }  // end delete()
// -------------------------------------------------------------
   // returns node with next-highest value after delNode
   // goes to right child, then right child's left descendents
   private Node3 getSuccessor(Node3 delNode)
      {
      Node3 successorParent = delNode;
      Node3 successor = delNode;
      Node3 current = delNode.rightChild;   // go to right child
      while(current != null)               // until no more
         {                                 // left children,
         successorParent = successor;
         successor = current;
         current = current.leftChild;      // go to left child
         }
                                           // if successor not
      if(successor != delNode.rightChild)  // right child,
         {                                 // make connections
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode.rightChild;
         }
      return successor;
      }
// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node3 localRoot)
      {
      if(localRoot != null)
         {
         System.out.print(localRoot.charData + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void inOrder(Node3 localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.charData + " ");
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node3 localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.charData + " ");
         }
      }
// -------------------------------------------------------------
   public void displayTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node3 temp = (Node3)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.charData);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayTree()
// -------------------------------------------------------------
   }  // end class Tree