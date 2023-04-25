import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;


/*=============================================================================
|   Assignment:  HW 02 - Building and managing a Skip List
|
|       Author:  Aglay Saenz
|     Language:  Java
|
|   To Compile:  javac Hw02.java
|
|
|   To Execute:  java Hw02 filename
|                     where filename is in the current directory and contains
|                           commands to insert, delete, print.
|
|        Class:  COP3503 - CS II Spring 2021
|   Instructor:  McAlpin
|     Due Date:  April. 4, 2021
|
+=============================================================================*/









public class SkipList {
	
	class Node { //creating the Node
		
		public Node above;
		public Node below;
		public Node next;
		public Node prev;
		public int key; //?
		
		//for now just think key = data
		

		
		public Node (int key) { //setting Node
			
			this.key = key;
			this.above = null;
			this.below = null;
			this.next = null;
			this.prev = null;
			
			//this.data = data;
			
		}
		
		
		
	}
	
	private Node head;
	private Node tail;
	
	private final int negative = Integer.MIN_VALUE; //negative infinity
	private final int positive = Integer.MAX_VALUE; //positive infinity
	
	
	private int height = 0; //levels
	
	public Random random = new Random(); //random seed
	
	
	//constructor
	
	public SkipList() { //fresh new skiplist //void?
		
		head = new Node (negative);
		
		tail = new Node (positive);
		
		head.next = tail;
		
		tail.prev = head;
		
	}
	
	
	public Node search (int key) { //search function
		
		
		Node n = head;
		
		while (n.below != null) {
			
			n = n.below;
			
			while (key >= n.next.key) {
				
				n = n.next;
				
			}
			
		}
		
		return n;
		
	}
	
	
	public Node insert (int key) { //insert function
		
		Node position = search (key);
		
		Node queue;
		
		
		int level = -1;
		
		int numberHead = -1;
		
		if (position.key == key) {
			
			return position;
			
		}
		
		do {
			
			numberHead++;
			level++;
			
			canIncreaseLevel(level);
			
			queue = position;
			
			while (position.above == null) { //does not exist, so take previous position
				
				position = position.prev;
				
			}
			
			position = position.above;
			
			queue = insertAfterAbove(position, queue, key);
			
		} while (random.nextBoolean() == true); //50/50 chance of going back to do
		
		return queue;
		
		
	} //all for insertion 
	
	
	
	public Node delete (int key) { //all for deletion
		
		Node removed = search (key);
		
		if (removed.key != key) { //if it don't exist, it don't exist
			
			return null;
			
		}
		
		
		removeRefToNode (removed);
		
		
		while (removed != null) { //removed exists
			
			removeRefToNode (removed);
			
			if (removed.above != null) {
				
				removed = removed.above;
				
			}
			
			else { //stop
				
				break;
				
			}
			
			
		}
		
		
		return removed; //return removed value
		
		
	}
	
	
	private void removeRefToNode (Node removed) {
		
		Node afterRemoved = removed.next;
		
		Node beforeRemoved = removed.prev;
		
		
		beforeRemoved.next = afterRemoved;
		
		afterRemoved.prev = beforeRemoved;
		
	}
	
	
	
	
	
	private void canIncreaseLevel (int level) { //increase level/height counter
		
		if (level >= height) {
			
			height++;
			
			addEmptyLevel();
			
		}
		
	}
	
	
	private void addEmptyLevel () { //empty level will be filled
		
		Node newHead = new Node(negative); //neg infinity
		
		Node newTail = new Node(positive); //positive infinity
		
		
		newHead.next =  newTail; 
		
		newHead.below = head;
		
		newTail.prev = newHead;
		
		newTail.below = tail;
		
		
		head.above = newHead;
		
		tail.above = newTail;
		
		
		head = newHead;
		
		tail = newTail;
		
		
	}
	
	private Node insertAfterAbove (Node position, Node queue, int key) {
		
		Node newNode = new Node (key); //new node made will be the new Node with key
		
		//Node beforeNewNode = position.below;
		
		Node beforeNewNode = position.below.below; //node before new node, below that
		
		
		setBeforeAndAfterRefs (queue, newNode); //call functions
		
		setAboveAndBelowRefs (position, key, newNode, beforeNewNode);
		
		return newNode;
		
	}
	
	
	private void setBeforeAndAfterRefs(Node queue, Node newNode) {
		
		newNode.next = queue.next; //new node will be next queue
		
		newNode.prev = queue; //start
		
		queue.next.prev = newNode; 
		
		queue.next = newNode; //next in queue will be new node
		
	}
	
	
	private void setAboveAndBelowRefs (Node position, int key, Node newNode, Node beforeNewNode) {
		
		if (beforeNewNode != null) { //while pre new node exists
			
			while (true) { //just keep going
				
				if (beforeNewNode.next.key != key) { //if next key is not equal to original key
					
					beforeNewNode = beforeNewNode.next; //this will be next node
					
				}
				
				else { //stop
					
					break;
					
				}
				
				
			}
			
			newNode.below = beforeNewNode.next;
			
			beforeNewNode.next.above = newNode;
			
		}
		
		if (position != null) { //if position exists
			
			if (position.next.key == key) { //if it equals the key we are looking for
				
				newNode.above = position.next; //above becomes next
				
			}
			
		}
		
		
	}
	
	
	public void printSkipList () { //print it
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nSkip list. \n");
		
		//sb.append("\nSkipList starting with top-left most node. \n");
		
		Node start = head; //start of list
		
		Node highestLevel = start; //whatever is head at that point
		
		int level = height;
		
		while (highestLevel != null) { //while it exists, do this
			
			sb.append("\nLevel: " + level + "\n");
			
			while (start != null) {
				
				sb.append(start.key);
				
				if (start.next != null) {
					
					sb.append(" : ");
					
				}
				
				start = start.next; //keep going
				
			}
			
			highestLevel = highestLevel.below;
			
			start = highestLevel;
			
			level--;
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	
public void quit () { //easy function, just terminate program when quitting
	
	System.exit(0);;
	
}
	
	
	
public void complexityIndicator () {
		
	System.err.println("ag127018; 5.0; 90");
		
	//90 hours, is 5 hours over 18 days. I, once again, obviously don't know how to code
		
}



/*
public Random rand = new Random();
public int seed;

public void Seeder (Integer inSeed) {
	
	rand.setSeed(inSeed);
	
}
*/


	
	
	
//}

//none of this works
public static String[] cmd_list;

public SkipList (String input_file) {
	
	cmd_list = new String[500];
	
	int i = 0;
	
	Scanner sc = null;
	
	
	try {
		
		sc = new Scanner (new File(input_file));
		
	}
	
	catch (IOException e) {
		
		e.printStackTrace();
		
	}
	
	while (sc.hasNext()) {
		
		cmd_list[i] = sc.next();
		
		i++;
		
	}
	
	i = 0;
	
	System.out.println("For input file named " + input_file);
	
}





public static void main (String[] args) throws Exception { //main
	
	
	
	//below is fine
	
	//SkipList skiplist = new SkipList(key); //this is fine //?
	
	SkipList skipList = new SkipList(); //create object
	
	skipList.insert(6);
	
	skipList.insert(15);
	
	skipList.insert(4);
	
	skipList.printSkipList();
	
	
	skipList.delete(4);
	
	skipList.printSkipList();
	
	
}
	
} //SkipList in its entirety



/*=============================================================================
|     I, Aglay Saenz, (4093599) affirm that this program is
| entirely my own work and that I have neither developed my code together with
| any another person, nor copied any code from any other person, nor permitted
| my code to be copied  or otherwise used by any other person, nor have I
| copied, modified, or otherwise used programs created by others. I acknowledge
| that any violation of the above terms will be treated as academic dishonesty.
+=============================================================================*/

