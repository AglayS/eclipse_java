package Cute;

public class Animal {


	private double weight;
	private double height;
	
	//constructor
	
	Animal (double weight, double height) {
		
		setWeight(weight);
		
		setHeight(height);
		
	}

		// getters/setters
	
	public double getWeight() {
		
		return weight;
		
	}
		
	public void setWeight(double weight) {
		
		this.weight = weight;
		
	}
	
	public double getHeight() {
		
		return height;
		
	}
		
	public void setHeight(double height) {
		
		this.height = height;
		
	}
	
	

}
