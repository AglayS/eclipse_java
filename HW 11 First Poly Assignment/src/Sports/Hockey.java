package Sports;

public class Hockey extends Athlete {
	
	//Hockey inherits Athlete which inherits Person
	
	String StickBrand;
	
	Hockey (String name, int age, String team, String position, String StickBrand) {
		
		super(name, age, team, position);
		
		this.StickBrand = StickBrand;
		
	}
	
	Hockey(){}
	
	@Override
	
	void doThis() {
		
		System.out.println("I sit in a penalty box!");
		
	}

}
