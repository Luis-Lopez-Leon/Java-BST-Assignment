import java.util.Scanner;

//Luis Lopez
//Assignment 3


class TreeApp3
   {
   public static void main(String[] args){
	   
	   
	   
	  Scanner userInput = new Scanner(System.in);
	  int MenuChoice;//for do while loop
      String userWord;
      char userChar;
      Tree3 charTree = new Tree3();
      nodeQueue extraNodes = new nodeQueue(100);
      nodeQueue insertQueue = new nodeQueue(100);
      
      //Building BST first
      
      System.out.print("Enter a word in all caps and press ENTER key: ");
      userWord = userInput.nextLine();//reads user word as a String
      
      for(int i = 0; i < userWord.length(); i++) {//Inserting each Character into a new Tree or data structure if it cannot be inserted
    	 
    	charTree.insert3(userWord.charAt(i), extraNodes);
 
    	  
      }
      
     

      do {//Now we display the Menu
    	  
    	  
    	  System.out.print("\n\n1. Display the tree\n");
          System.out.print("2. Display the contents of the data structure you used to store the letters that could not be inserted(if any)\n");
          System.out.print("3. BONUS\n");
          System.out.print("4. Display Tree after extra data was inserted.\n");
          System.out.print("5. Exit.\n");
          int choice = userInput.nextInt();
          MenuChoice = choice;//assigns user's choice to MenuChoice for do while loop to work.
          switch(choice)
             {
             case 1:
                charTree.displayTree();
                break;
             case 2:
            	 
            	 for(int i = 0; i < extraNodes.size(); i++)
                 {
               	  extraNodes.queArray[i].displayNode();
                 }
               
                break;
             case 3:
                
            	 charTree.computeNodeHeights(charTree.getroot());
                
                break;
             case 4:

            	 charTree.insertLeftOvers(charTree.getroot(), extraNodes, insertQueue);
            	 
              	 System.out.print("Tree after inserting left over data: \n\n");
              	 
              	 charTree.displayTree();
                
                break;
                
             case 5:
            	 
            	 break;
  
             default:
                System.out.print("Invalid entry\n");
             }  // end switch
          
         
          
          }// end do
    	  while(MenuChoice != 5);
     
     
      
      
      
      
      
   		}  // end main()
   }  // end class TreeApp