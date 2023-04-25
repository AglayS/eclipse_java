package Cute;

public class Cat extends Animal {
	
	String name;
	
	int lives;
	
	//cat constructor
	
	Cat (String name, double weight, double height) {
		
		super(weight, height);
		
		setName(name);
		
		lives = 9;

	}
	
	// getters/setters

	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	//override to print out string
	
	@Override
	
	public String toString() {
		
		return "Cat\nName: " + getName() + "\nLives: " + lives + "\nHeight: " + getHeight() + "\nWeight: " + getWeight() + "\n";
		
	}
	



}
