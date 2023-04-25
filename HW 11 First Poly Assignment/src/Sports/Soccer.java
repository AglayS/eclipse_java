package Sports;

public class Soccer extends Athlete {
	
	//soccer positions will be:
	//0 for Goal Keeper (default), 1 for Defender, 2 for Midfielder, 3 for Forward
	
	int SoccerPosition;
	
	Soccer (String name, int age, String team, String position, int SoccerPosition) {
		
		super(name, age, team, position);
		
		if (SoccerPosition > -1 && SoccerPosition < 4) {
			
			this.SoccerPosition = SoccerPosition;
			
		}
		
		else {
			
			this.SoccerPosition = SoccerPosition; //default
			
		}
		
	}
	
	Soccer(){}
	
	@Override
	
	void doThis() {
		
		System.out.println("I kick the ball!");
		
	}
	

}
