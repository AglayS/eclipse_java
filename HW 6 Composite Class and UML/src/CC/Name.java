package CC;

public class Name {
	
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	
	public Name () { //default constructor, will be filled later
		
		firstName = "";
		
		middleName = "";
		
		lastName = "";
	
	}
	
	public Name (String firstName, String middleName, String lastName) { //initialize values
		
		this ();
		
		setFirstName(firstName);
		
		setMiddleName(middleName);
		
		setLastName(lastName);
	
		
	}
	
	public Name (String firstName, String lastName) { //in case there is no middle name
	
		this ();
		
		setFirstName(firstName);
		
		setLastName(lastName);
		
	
	}

	//getters/setters
	
	public String getfirstName () { 
		
		return firstName;
		
		
	}
	
	
	public void setFirstName(String firstName) {
		
		if (firstName.length() > 0) { //make sure name is cased correctly
			
			char c = firstName.charAt(0);
			
			firstName = firstName.toLowerCase().substring(1);
			
			this.firstName = c + firstName;
			
		}
		
	}
	
	
	public String getmiddleName () {
		
		
		return middleName;
		
		
	}
	
	
	public void setMiddleName (String middleName) {
		
		if (middleName.length() > 0) { //same as first name
			
			char c = middleName.charAt(0);
			
			middleName = middleName.toLowerCase().substring(1);
			
			this.middleName = c + middleName;
			
		}
		
		
	}
	
	
	public String getlastName () {
		
		return lastName;
		
	}
	
	
	public void setLastName (String lastName) {
		
		if (lastName.length() > 0) { //same as first name
			
			char c = lastName.charAt(0);
			
			lastName = lastName.toLowerCase().substring(1);
			
			this.lastName = c + lastName;
			
		}
		
		
	}
	
	
	
	
	
	
@Override
	
	public String toString () { //make sure name is printed
		
		
		if (middleName != "") {
			
			return firstName + "" + middleName + "" + lastName;
			
		}
		
		else {
			
			return firstName + "" + lastName;
			
		}
		
		
		
	}
	
	
}
