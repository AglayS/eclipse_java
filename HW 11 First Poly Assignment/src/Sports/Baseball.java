package Sports;

public class Baseball extends Athlete { //class Baseball will inherit Athlete, hence also inheriting Person
	
	//batting positions will be: 
	//-1 for lefties, 0 for both (will be default), 1 for righties
			
			int BattingPosition;
			
			Baseball (String name, int age, String team, String position, int BattingPosition) {
				
				super(name, age, team, position);
				
				if (BattingPosition > -2 && BattingPosition < 2) {
					
					this.BattingPosition = BattingPosition;
					
				}
				
				else {
					
					this.BattingPosition = 0; //default
					
				}
			
				
				
				
			}
			
		Baseball(){}
				
		@Override
				
		void doThis() { //will display, will be similar in other classes
					
			System.out.println("I hit something!");
					
		}
				
				
}
	
	
	


