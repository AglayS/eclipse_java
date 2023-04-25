package HW2;

//Aglay Saenz, 1/13/2020, Homework #2


import java.util.Scanner;

public class HW2_IO {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in); //scanf of java, I guess; get user input
		
		System.out.println("Please enter three integer values: ");
		
		int one = input.nextInt(); //first integer
		
		int two = input.nextInt(); //second integer
		
		int three = input.nextInt(); //third integer
		
		int sum = one + two + three; //sum of all three
		
		double average = sum / 3.00; //average of all three
		
		System.out.printf("The sum is: " + sum + "\n"); 
		//concatenation in this one line since that was necessary for the assignment apparently?
		//also displays sum 
		
		System.out.printf("The average is: %.2f", average); //apparently println doesn't work when the format specifier is involved?
		//also displays the average
		
		input.close(); //close scanner
		
	}

}
