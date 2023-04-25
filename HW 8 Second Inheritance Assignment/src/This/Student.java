package This;

public class Student extends Person {

	
	String major;
	
	int languages;
	
	String hobby;
	
	
	public Student (String major, int languages, String hobby) { //constructor
		
		this.major = major;
		
		this.languages = languages;
		
		this.hobby = hobby;
		
		
	}
	
	
	//getters and setters
	
	public String getMajor() {
		
		return major;
		
	}
	
	public void setMajor(String major) {
		
		this.major = major;
		
	}
	
	public int getLanguages() {
		
		return languages;
		
	}
	
	public void setLanguages(int languages) {
		
		this.languages = languages;
		
	}
	
	
	public Student() {} //override method above to display string
	
	@Override
	
	public String toString () {
		
		return "Major: " + this.major + ", " + "Number of languages can speak: " + this.languages + ", " + "Hobby: " + this.hobby;
		
	}
	
	
	
}
