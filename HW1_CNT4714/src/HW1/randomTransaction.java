package HW1;

/*  Name: Aglay Saenz  
Course: CNT 4714 Summer 2022 
Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking 
Due Date: June 5, 2022 
*/ 

import java.util.Random;

//class to randomly assign values to deposit/withdraw

public class randomTransaction { 
	
	// true = deposit, false = withdrawal
	public static int newNumber(boolean operator) {
	  
	int randomAmount = 0;

	if (operator == true) {
		
		randomAmount = integerRange(1, 500); //correct amount
	
		return randomAmount;

	} 
	
	else {
	
		randomAmount = integerRange(1, 99); //correct amount
	
		return randomAmount;
	
	}
	
}
	  
	// integer should be in range
	private static int integerRange(int min, int max) {
	  
		Random random = new Random();
	
		int i = 0;

		while (min >= i || max <= i) {
	
			i = random.nextInt();
	
		}

	return i;
	
	}
	  
//random sleep time
	public static int newSleepTime(boolean operator) {
	  
		Random randomGenerator = new Random();
		
		int sleepTime;
	  
			if (operator == true) {
	
				sleepTime = randomGenerator.nextInt(100);
	
				return sleepTime;

			} 
			
			else {
	
				sleepTime = randomGenerator.nextInt(5);
				
				return sleepTime;

			}
	
	}

} //good
