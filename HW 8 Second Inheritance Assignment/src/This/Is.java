package This;

public class Is {
	
	//Aglay Saenz, 3/29/2020

	public static void main(String[] args) { //display everything below
		
		Person p1 = new Person("Aglay", 20, 1234);
		
		Person p2 = new Person("Guy", 21, 2468);
		
		Person p3 = new Person("Becky", 20, 4321);
		
	
		Student s1 = new Student("Computer Engineering", 2, "Gaming");

		Student s2 = new Student("Aerospace Engineering", 3, "Reading");
		
		Student s3 = new Student("Industrial Engineering", 1, "Crocheting");
		
		
		System.out.println(p1);
		System.out.println(s1);
		
		System.out.println();
		
		System.out.println(p2);
		System.out.println(s2);
		
		System.out.println();
		
		System.out.println(p3);
		System.out.println(s3);
		
		
	}

}
