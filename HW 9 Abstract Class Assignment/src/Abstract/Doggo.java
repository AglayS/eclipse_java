package Abstract;

abstract class Doggo { //child classes must use a name at some point
	
	
	protected String name;
	
	public Doggo(String name) {
		
		this.name = name;
	}
	
	
	public String getName() {
		
		return name;
		
	}
	
	
}


class GermanShep extends Doggo {
	
	private double weight;
	
	private double height;
	
	public GermanShep (String name, double weight, double height) { //constructor
		
		super(name);
		
		this.weight = weight;
		
		this.height = height;
		
	}
	
@Override //display string of info
	
	public String toString() { //display name, height, and weight
		
		return "Name: " + name + " Height (inches): " + height + " Weight (pounds): " + weight;
		
	}
	
	
}

class ChowChow extends Doggo {
	
	private double weight;
	
	private double height;
	
	public ChowChow (String name, double weight, double height) {
		
		super(name);
		
		this.weight = weight;
		
		this.height = height;
		
		
	}
	
@Override
	
	public String toString() { //display name, height, weight
		
		return "Name: " + name + " Height (inches): " + height + " Weight (pounds): " + weight;
		
	}
	
}


