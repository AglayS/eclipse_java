package Sports;

public class Person {
	
String name;
	
	int age;
	
	Person (String name, int age) { //constructor for Person
		
		this.name = name;
		
		this.age = age;
		
	}
	
	Person(){}
	

}


//Athlete inherits Person

abstract class Athlete extends Person {
	
	String team;
	
	String position;
	
	Athlete (String name, int age, String team, String position) { //constructor for Athlete, will inherit Person
		
		super(name, age);
		
		this.team = team;
		
		this.position = position;
		
		
	}
	
	Athlete() {}
	
	abstract void doThis(); //for subclasses
	
	
	
	
	
}








