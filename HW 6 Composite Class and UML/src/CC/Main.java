package CC;

public class Main {

	//Aglay Saenz, 3/6/2020
	
	public static void main(String[] args) {

		
		try {
			
			
			Name name1 = new Name("FrEddiE ", "MErcury");
			
			Person person1 = new Person(name1, 'M', 30, 1000000.11);
			
			Person person2 = new Person(new Name ("Aglay ", "Adel ", "Saenz"), 'F', 20, 100.01);
			
			Person person3 = new Person(new Name ("SEB " , "Castellan"), 'M', 40, 50000.55);
			
			
			System.out.println(person1); //print out each person
			
			System.out.println(person2);
			
			System.out.println(person3);
			
			System.out.println();
			
			
			
			//testing components
			
			System.out.println("Trying to set gender 'F' for " + person3.getName() + ". Should be changed.");
			
			person3.setGender('F');
			
			System.out.println();
			
			System.out.println("Result: " + person3); //the gender can be changed
			
			System.out.println();
			
			System.out.println("Trying to set age to 21 for " + person2.getName() + ". Should be changed.");
			
			System.out.println();
			
			person2.setAge(21);
			
			System.out.println("Result: " + person2); //age can be changed
			
			System.out.println();
			
			System.out.println("Trying to set age to 0 for " + person1.getName() + ". Shouldn't change original.");
			
			System.out.println();
			
			person1.setAge(0);
			
			System.out.println("Result: " + person1); //this age cannot change because outside of range
			
			System.out.println();
			
			System.out.println("Trying to set salary to 0 for " + person2.getName() + ". Should change.");
			
			System.out.println();
			
			person2.setSalary(0);
			
			System.out.println("Result: " + person2); //0 is included in range, so it should change
			
			
		}
		
		catch (Exception e) {
			
			System.out.println("Something went wrong. Please try again."); 
			
		}
		

	}

}
