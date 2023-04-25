import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;



/*=============================================================================
 |   Assignment:  HW 01 - Building and managing a BST
 |
 |       Author:  Aglay Saenz
 |     Language:  Java
 |
 |   To Compile:  javac Hw01.java
 |
 |
 |   To Execute:  java Hw01 filename
 |                     where filename is in the current directory and contains
 |                           commands to insert, delete, print.
 |
 |        Class:  COP3503 - CS II Spring 2021
 |   Instructor:  McAlpin
 |     Due Date:  Feb. 28, 2021
 |
 +=============================================================================*/
 

//Node 


class Node {

  Node left;
  
  Node right;
  
  int data;

public int root;



  //constructors
  
  public Node () {
  	
      left = null;
      
      right = null;
      
      data = 0;
  
  }
  
  public Node (int n) {
  	
      left = null;
      
      right = null;
      
      data = n;
      
  }
  
  // set left node 
  
  public void setLeft (Node n) {
  	
      left = n;
      
  }
  
  // set right node 
  
  public void setRight (Node n) {
  	
      right = n;
      
  }
  
  //get left
  
  public Node getLeft () {
  	
      return left;
      
  }
  
  //get right node 
  
  public Node getRight () {
  	
      return right;
      
  }
  
  // set data to node 
  
  public void setData (int d) {
  	
      data = d;
      
  }
  
  //get data from node
  
  public int getData () {
  	
      return data;
      
  }     

}

//this should be fine for nodes




//I hope this works for an input file

//bst

class BST {
	
  public Node root;

  //constructor again
  
  public BST() {
  	
      root = null;
      
  }
  
  //check if tree is empty 
  
  public boolean isEmpty () {
  	
      return root == null;
      
  }
  

  
  public void insert (int data) {
     
  	Node current = root;
  	
      Node prev = null;
      
      while (current != null) { // find a place for inserting new node;
          
      	prev = current;
      	
      	if (data < current.root) {
         
        
              current = current.right;
              
          }

          else {
          
              current = current.left;
              
          }

      }
      
      
      if (root == null) {  // tree is empty;
      
          root = new Node(data);
          
      }
      
     
      
   
      
      else {
      
          prev.left = new Node(data);
          
      }
      
  }

  //no touch
  

  
  public boolean search (int value) { //function to search tree
      
      return search (root, value);
      
  }
  
  
  
  // search element recursively 
  
  private boolean search (Node root, int value) {
  
      boolean found = false;
      
      while ((root != null) && !found) {
      
          int r_val = root.getData ();
          
          if (value < r_val) {
          	
              root = root.getLeft();
              
          }
          
          else if (value > r_val) {
          	
              root = root.getRight ();
              
          }
          
          else {
          
              found = true;
              
              break;
              
          }
          
          found = search (root, value);
          
      }
      
      
     // System.out.println("Found: " + found); //does not work
     
      
		return found;
      
    
      
  }    
  
  


public void delete (int key) {
  	
      if (isEmpty ()) {
      	
          System.out.println("Tree is empty.");
          
      }
      
      else if (search(key) == false) {
      	
          System.out.println(key +" is deleted."); //not?
          
      }
      
      else {
      
          root = delete(root, key);
          
          System.out.println(key + " deleted from the tree");
          
      }
      
  }


  
  private Node delete (Node root, int key) {
  	
      Node p, p2, n;
      
      if (root.getData() == key) {
      
          Node left, right;
          
          left = root.getLeft();
          
          right = root.getRight();
          
          if (left == null && right == null) {
          	
              return null;
              
          }
          
          else if (left == null) {
          
              p = right;
              
              return p;
              
          }
          
          else if (right == null) {
          
              p = left;
              
              return p;
              
          }
          
          else {
          
              p2 = right;
              
              p = right;
              
              while (p.getLeft() != null) {
              	
                  p = p.getLeft();
                  
              }
              
              p.setLeft(left);
              
              return p2;
              
          }
          
      }
      
      if (key < root.getData()) {
      
          n = delete(root.getLeft (), key);
          
          root.setLeft (n);
          
      }
      
      else {
      
          n = delete(root.getRight(), key);
          
          root.setRight(n);      
          
      }
      
      return root;
      
  }



//count number of nodes 

public int countChildren () {
	
  return countChildren (root);
  
}

//count recursively

private int countChildren (Node right) {

  if (right == null) {
  	
      return 0;
      
  }
  
  else {
  
      int left = 1;
      
      left = left + countChildren (right.getLeft());
      
      left = left + countChildren (right.getRight());
      
      return left;
      
  	}
  
	}


public void complexityIndicator () {
	
	System.err.println("ag127018; 5.0; 75");
	
	//75 hours, is 5 hours over 15 days. I obviously don't know how to code
	
	}



int getDepth(Node root) {
	
    if ( root == null ) {
    	
        return 0;
        
    }
    
    return 1 + getDepth(root.getLeft()) + getDepth(root.getRight());
    
  // System.out.println("Depth: " + );
    
}



//in order traversal 

public void inorder () {

  inorder(root);
  
}



public void inorder(Node r) {
	
  if (r != null) {
  
      inorder(r.getLeft ());
      
      System.out.print(r.getData() + " ");
      
      inorder(r.getRight ());
      
  }
  
}



}



public class Hw01 {
	

	public static void main (String[] args) throws Exception{ //throws IOException 
	   
		 
		// System.out.println("Tree"); //just checks to see if main works
		 
		 
		 BST bst = new BST();  //make bst

		 
		 System.out.println( "\nCommand line arguments:\n");
		 	
		 	for (int i = 0; i < args.length; i++ ) {
		 
		 		String s = args[ i ];
		 		
		 		System.out.println( "Argument " + i + ": " + s );
		 
		 }
		 
		 File file = new File( args[ 0 ] );
		 
		 try {
		 
		 	BufferedReader br = new BufferedReader( new FileReader( file ));
		 	
		 	System.out.println( "\nFile opened successfully!");
		 	
		 	br.close();
		 	
		 } catch ( Exception e ) {
		
		 e.printStackTrace();
		 
		 System.err.println("File not found/not open successfully.");
		 
		 bst.complexityIndicator(); //to say how much I suck at coding
		 
		 }
		 
		 
		 //above is fine
		 
		/* int intvalue = Integer.parseInt( args[ 1 ] );
		 System.out.println( "\nintvalue = " + intvalue);
		 double dblvalue = Double.parseDouble( args[ 2 ] );
		 System.out.println( "\ndblvalue = " + dblvalue); */
		 
		 
		 
		 
		
		 
		 
		 
		 
		
		 Scanner sc = new Scanner(file);
		 
		 Scanner s = new Scanner(file);
		 
		
		 
		 char x = s.next().charAt(0);
		 
		 String xe = String.valueOf(x);
		 
		 
		 StringBuffer sb = new StringBuffer();
		 
		 //append each line to the buffer 
		 
		 int Nod = s.nextInt();
		 
	
		
		 
		
		 
		 
		 
		 System.out.println("\n" + file + " contains: ");
		 
		 
		 
		 while (sc.hasNext()) {
			 
			 sb.append(" \n" + sc.nextLine());
			 
			 
			 
			 if (xe == "i") {
				 
				 bst.insert(Nod);
				 
			 }
			 
			 
			 
			 
			 if (xe == "p") {
				 
				 
				 bst.inorder(bst.root);
				 
					
				 System.out.println("\nNodes = "+ bst.countChildren());
				 
				 
				 
			 }
			 
			 
		 }
		 
		 
		 
		 System.out.println(sb);
		 
	
		 
		 
		System.out.println("\n");
		 
		 
		 
		 bst.insert(9);
		 
		 bst.insert(24);
		 
		 bst.insert(3);
		 
		 bst.insert(4); 
		 
		 bst.insert(11); 
		 
		 
		 bst.inorder(bst.root);
		 
		 
		System.out.println("\n\n2 has been found? " + bst.search(2) );
		 
		 
		 bst.delete(11);
		 
		 System.out.println("\nTotal depth = " + bst.getDepth(bst.root));
		 
	
		
		 System.out.println("\nTotal Nodes = "+ bst.countChildren());
		 
		 //hard code to see if functions work, I don't know what to do
		}
	
	

	}
	




//the end





/*=============================================================================
  |     I, Aglay Saenz, (4093599) affirm that this program is
  | entirely my own work and that I have neither developed my code together with
  | any another person, nor copied any code from any other person, nor permitted
  | my code to be copied  or otherwise used by any other person, nor have I
  | copied, modified, or otherwise used programs created by others. I acknowledge
  | that any violation of the above terms will be treated as academic dishonesty.
  +=============================================================================*/
 

