package CC;

public class Person {
	
	private Name name;
	
	private char gender;
	
	private int age;
	
	private double salary;
	
	
	
	public Person () { //default
		
		
		name = new Name("" , "");
		
		gender = 'M';
		
		age = 1;
		
		salary = 0;
		
		
	}
	
	
	public Person (Name name, char gender, int age, double salary) { //initialize values
		
		this ();
		
		setName(name);
		
		setGender(gender);
		
		setAge(age);
		
		setSalary(salary);
		
	}
	
	
	//getters/setters
	
	
	public Name getName () {
		
		return name;

	}
	
	
	public void setName(Name name) {
		
		this.name = name;
		
	}
	
	
	public int getAge () {
		
		return age;
		
	}
	
	
	public void setAge (int age) {
		
		if (age >= 1 && age <= 120) { //will change age only if it is in this range
			
			this.age = age;
			
		}
		
	}
	
	
	
	public char getGender () {
		
		return gender;
		
	}
	
	
	public void setGender (char gender) {
		
		gender = Character.toUpperCase(gender); //uppercase lettering
		
		if (gender == 'M' || gender == 'F' || gender == 'O') { //should only display these three genders
			
			this.gender = gender;
			
		}
		
	}
	
	
	public double getSalary () {
		
		return salary;
		
	}
	
	
	public void setSalary (double salary) {
		
		if (salary >= 0) { //only sets salary if it is zero or above
			
			this.salary = salary;
			
		}
		
		
	}
	
	
	
	
	@Override
	
	public String toString () { //returns all these values
		
		return name + ", Gender: " + gender + ", Age: " + age + ", Salary is $" + salary;
		
	}
	
	
	
	
	
	

}
