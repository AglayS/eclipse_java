package Cute;

public class Test_Animal {

	//Aglay Saenz, 3/20/2020
	
	
	public static void main(String[] args) {
		
		//call all constructors for each animal

		Dog perro = new Dog("Paco", "Chihuahua", "March 31, 2008", 9.0, 30.5);
		
		Cat gato = new Cat("Lola", 7.8, 19.8);
		
		Bird pajaro = new Bird(10.0, "Yes", .289, 10);
		
		
		//toString method
		
		System.out.println(perro);
		
		System.out.println(gato);
		
		System.out.println(pajaro);
		
	}

}
