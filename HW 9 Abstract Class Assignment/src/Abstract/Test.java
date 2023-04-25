package Abstract;

import java.util.ArrayList;

public class Test {

	//Aglay Saenz, 3/10/2020
	
	public static void main(String[] args) {
		
		ArrayList<Doggo> doggoList = new ArrayList<Doggo>(); //I don't think the assignment calls for it but I will put in a list anyway
		
		Doggo d1 = new GermanShep("Sentinel", 70.05, 26.07); //name, height first, then weight
		
		doggoList.add(d1);
		
		System.out.print(d1); 
		
		System.out.println();
		
		Doggo d2 = new ChowChow("Guardian", 55.78, 16.45); //name, height first, then weight
		
		System.out.print(d2);
		
		System.out.println();
		
		if (!d1.getClass().isInstance(d2)) { //d1 != d2
			
			System.out.println("Two very different (but good) doggos.");
			
		}

	}

}
