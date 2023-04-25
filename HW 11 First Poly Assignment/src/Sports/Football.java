package Sports;

public class Football extends Athlete{
	
	//specialty numbers: 
	//1 for Offense (default), 2 for Defense, 3 for Special Teams
	
	int specialty;
	
	Football(String name, int age, String team, String position, int specialty) {
		
		super(name, age, team, position);
		
		if (specialty > 0 && specialty < 4) {
			
			this.specialty = specialty;
			
		}
		
		else {
			
			this.specialty = 1; //default
			
		}
		
		
		
	}
	
	Football(){}
	
	@Override
	
	void doThis() {
		
		System.out.println("I tackle something!");
		
	}
	
	
	
	
	
	

}
