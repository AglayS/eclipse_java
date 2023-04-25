package This;

public class Dog extends AbstractDog implements DogName, DogWeight, DogHeight {
	
	private String name;
	
	private double weight;
	
	private double height;
	
	public Dog (String name, double weight, double height) {
		
		super();
		
		this.name = name;
		
		this.weight = weight;
		
		this.height = height;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	@Override
	
	public double getWeight() {
		
		return weight;
		
	}
	
	@Override
	
	public double getHeight() {
		
		return height;
		
	}
	
	@Override
	
	public void displayStats() {
		
		System.out.print("The doggo is: " + name + ". Their weight is: " + weight + " pounds. And their height is: " + height + " inches.");
		
	}
	
	

}
