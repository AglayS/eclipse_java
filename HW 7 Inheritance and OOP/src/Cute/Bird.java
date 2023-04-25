package Cute;

public class Bird extends Animal {
	
	double wing_span;
	String can_fly;
	
	//constructor
	
	Bird (double wing_span, String can_fly, double weight, double height) {
		
		super (weight, height);
		
		setWingSpan(wing_span);
		
		setCanFly(can_fly);
		
		
	}
	
	// getters/setters
	
	public double getWingSpan() {
		
		return wing_span;
		
	}
	
	public void setWingSpan(double wing_span) {
		
		this.wing_span = wing_span;
		
	}
	
	public String getCanFly() {
		
		return can_fly;
		
	}
	
	public void setCanFly(String can_fly) {
		
		this.can_fly = can_fly;
		
	}
	
	//override to print out string
	
	@Override
	
	public String toString() {
		
		return "Bird\nWing Span: " + getWingSpan() + "\nFlies?: " + getCanFly() + "\nHeight: " + getHeight() + "\nWeight: " + getWeight() + "\n";
		
	}

}
