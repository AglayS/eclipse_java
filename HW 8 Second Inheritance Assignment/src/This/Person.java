package This;

public class Person {


	String name;
	int age;
	int student_number;
	
	public Person (String name, int age, int student_number) { //constructor
	
	this.name = name;
	
	this.age = age;
		
	this.student_number = student_number;
	
	}
	
	//getters and setters
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public int getAge() {
		
		return age;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public int getStudentNumber () {
		
		return student_number;
		
	}
	
	public void setStudentNumber(int student_number) {
		
		this.student_number = student_number;
		
	}
	
	
	public Person() {} //override constructor above to display string
@Override
	
	public String toString() {
		
		return "Name: " + this.name + ", " + "Age: " + this.age + ", Student Number: "+ this.student_number;
		
	}
	
}

