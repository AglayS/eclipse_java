package OneD;

import java.util.Random;

import java.util.Scanner;

public class Array {
	
	//Aglay Saenz, 2/28/2020, 1D Array Assignment

	public static void main(String[] args) {
		
		oneToThree();
		
		fourToFive();

		sixToSeven();
		
		eightToTen();
		
		//each method will call a new array for the purposes of this assignment
		
	}

	
	public static void oneToThree () { //generate
		
		Random rd = new Random(); //generate randomly
		
		int array[] = new int[100]; //100 elements
		
			for (int i = 0; i <= 99; i++) {
		
				array[i] = rd.nextInt(100 - 1 + 1) + 1; //1 - 10 inclusive
		
			}
		
			for (int i = 0; i < array.length; i++) { //display
		
				System.out.println((i + 1) + ". " + array[i] + " ");

			}
		
			System.out.println();
			
	}
	
	
	public static void fourToFive () {
		
		
		Random rd = new Random(); //generate randomly
		
		int array[] = new int[100]; //100 elements
		
			for (int i = 0; i <= 99; i++) {
		
				array[i] = rd.nextInt(100 - 1 + 1) + 1; //1 - 10 inclusive
		
			}
		
		
			for (int i = 0; i < 100; i++) {
				
				for (int j = i + 1; j < array.length; j++) {
					
					if (array[i] > array[j]) { //sort arrays like this
						
						int temp = array[i];
						
						array[i] = array[j];
						
						array[j] = temp;
						
						
					}
					
					
				}
				
				System.out.println((i + 1) + ". " + array[i] + " "); //display sorted array
				
			}
			
		System.out.println();
			
	}
	
	
	public static void sixToSeven () {
		
		Random rd = new Random(); //generate randomly
		
		Scanner input = new Scanner(System.in);
		
		int array[] = new int[100]; //100 elements
		
			for (int i = 0; i <= 99; i++) {
		
				array[i] = rd.nextInt(100 - 1 + 1) + 1; //1 - 10 inclusive
		
				System.out.println((i + 1) + ". " + array[i] + " "); //display it
			
			}
			
			
		System.out.println("Please enter a number from 1 to 100: ");
		
		
			int search = input.nextInt();
		
			boolean found = false;
		
			int counter = 0;
			
		for (int i = 0; i <= 99; i++) {
			
			if (search == array[i]) {
				
				found = true;
				
				counter++; //count how many times number occurs
				
			}

				
		}
			
	
	if (found != true) {
		
		System.out.println("I'm sorry, I couldn't find your number.");
		
	}
	
	else {
		
		System.out.printf("Found your number %d times!", counter);
		
	}
	
	System.out.println();
	
}
	
	
	public static void eightToTen() {
		
		
		Random rd = new Random(); 
		
		int array[] = new int[100]; 
		
			for (int i = 0; i <= 99; i++) {
		
				array[i] = rd.nextInt(100 - 1 + 1) + 1; 
		
				System.out.println((i + 1) + ". " + array[i] + " "); 
			
			}
		
			
			int minimum = array[0]; //start with first element
			
			int maximum = array[0];
			
			
			for (int i = 0; i <= 99; i++) {
				
				if (array[i] < minimum) {
					
					minimum = array[i]; //new minimum value with this element
					
				}
			
				if (array[i] > maximum) {
					
					maximum = array[i]; //new max value with this element
					
				}
				
			}
			
			
			double total = 0;
			
			
			for (int i = 0; i <= 99; i++) { //made a separate loop for average for safety
				
				total = total + array[i]; //add each element to total
				
			}
			
			
			double average = total / 100; //finding average with 100 elements technically
			
			
			System.out.printf("The minimum is %d", minimum); //display min
			
			System.out.println();
			
			System.out.printf("The maximum is %d", maximum); //display max
			
			System.out.println();
			
			System.out.printf("The average is %.2f", average); //display average
			
			
	}
	

	
}
