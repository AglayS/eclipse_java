package Sports;

public class Golfer extends Athlete {
	
	//Golfer inherits Athlete which inherits Person
	
	String MainSponsor;
	
	Golfer(String name, int age, String team, String position, String MainSponsor) {
		
		super(name, age, team, position);
		
		this.MainSponsor = MainSponsor;
		
	}
	
	Golfer(){}
	
	@Override
	
	void doThis() {
		
		System.out.println("I putt it in the hole!");
		
	}

}
