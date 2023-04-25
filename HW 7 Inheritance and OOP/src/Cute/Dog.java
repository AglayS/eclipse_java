package Cute;

public class Dog extends Animal{
	
	private String name;
	private String breed;
	private String DOB;
	
	//constructor
	
	Dog (String name, String breed, String DOB, double weight, double height) {
		
		super(weight, height);
		
		setName(name);
		
		setBreed(breed);
		
		setDob(DOB);
		
		
	}
	
	// getters/setters
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getBreed() {
		
		return breed;
		
	}
	
	public void setBreed(String breed) {
		
		this.breed = breed;

	}
	
	public String getDob() {
		
		return DOB;
		
	}
	
	public void setDob(String DOB) {
		
		this.DOB = DOB;

	}
	
	//override to print out strings
	
	@Override
	
	public String toString() {
		
		return "Dog\nName : " + getName() + "\nBreed: " + getBreed() + "\nDOB: " + getDob() + "\nHeight: " + getHeight() + "\nWeight: " + getWeight() + "\n";
		
	}
	
	

}
