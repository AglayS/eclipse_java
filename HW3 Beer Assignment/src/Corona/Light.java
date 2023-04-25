package Corona;

import java.util.Scanner;

public class Light {

	
	
	public static void main(String[] args) {
		
		//Aglay Saenz, 1/24/2020, Homework 3 Beer Assignment
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the average number of 12 oz can of beers you drink in a day: "); //asking user input for how much beer a day they drink
		
		
		float avg_beer = input.nextFloat(); //it has to be float, types must match
		
		
		while (avg_beer < 0) { //in case someone decides to try and use negatives
			
			System.out.println("Please try again.");
			
			System.out.println();
			
			System.out.println("Please enter the average number of 12 oz can of beers you drink in a day: "); 
			
			avg_beer = input.nextFloat(); 
			
		}

		
		System.out.println("Please enter the average cost of one 12 oz can of beer: "); //asking user input for average cost
		

		float avg_cost = input.nextFloat();
		
		
		while (avg_cost < 0) { //same as avg_beer while loop
			
			System.out.println("Please try again.");
			
			System.out.println(); //another way of saying new line
			
			System.out.println("Please enter the average cost of one 12 oz can of beer: ");
			
			avg_cost = input.nextFloat();
			
		}
		
		input.close(); //close scanner. I could leave it open though
		
		
		float yearly_beer = avg_beer * 365; //average a day times 365 days a year
		
		float yearly_cost = avg_cost * 365; //average cost a day times 365 days a year
			
		float yearly_calories = 150 * yearly_beer; //assuming 150 calories in each 12 oz beer multiplied by yearly_beer
		
		float yearly_weight = 15 * avg_beer; //assuming fifteen pounds gained per one 12 oz can, then multiplied by avg_beer
		
			
		
		
		System.out.printf("That is approximately %.2f beers in one year.", yearly_beer); //display how many beers consumed in one year
		
		System.out.println(); //new line
		
		System.out.printf("In one year you will consume approximately %.2f calories from beer alone.", yearly_calories); //display calories consumed by drinking beer each year
			
		System.out.println();
		
		System.out.printf("If you don't diet or exercise the counter the beer calories, you will gain %.2f pounds from drinking that much beer.", yearly_weight); //how much weight gained if you decide to be a couch potato
			
		System.out.println();
		
		System.out.printf("You will spend $%.2f on beer alone each year.", yearly_cost); //cost each year on beer
		
		
		
		
		if ((avg_cost == 0) && (avg_beer == 0)) { //in case someone decides to just put zeroes for some reasons
				
				System.out.println();
				
				System.out.println("I mean, good that you don't drink and don't have to spend money on it, but why are you using this then?");
				
			}
		

		
	}

}
