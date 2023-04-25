package Sports;

public class Player { //this is the class you want to run
	
	//Aglay Saenz, 4/24/2020

	public static void main(String[] args) {
		
		//new objects
		Baseball Hank = new Baseball();
		
		Football Terry = new Football();
		
		Hockey Mario = new Hockey();
		
		Golfer Paula = new Golfer();
		
		Soccer Danilo = new Soccer();
		
		//one more time
		
		Baseball Barry = new Baseball();
		
		Football Payton = new Football();
		
		Hockey Wayne = new Hockey();
		
		Golfer Phil = new Golfer();
		
		Soccer Carlos = new Soccer();
		
		
		//objects will do thing assigned in other classes
		Athlete obj = Hank;
		
		obj.doThis();
		
		obj = Terry;
		
		obj.doThis();
		
		obj = Mario;
		
		obj.doThis();
		
		obj = Paula;
		
		obj.doThis();
		
		obj = Danilo;
		
		obj.doThis();
		
		obj = Barry;
		
		obj.doThis();
		
		obj = Payton;
		
		obj.doThis();
		
		obj = Wayne;
		
		obj.doThis();
		
		obj = Phil;
		
		obj.doThis();
		
		obj = Carlos;
		
		obj.doThis();

	}

}
