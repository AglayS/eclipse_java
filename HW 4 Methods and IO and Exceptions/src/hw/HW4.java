package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HW4 {

	public static void main(String[] args) throws IOException {
		
		
		Scanner input = new Scanner(System.in);
		
		
	
	while (true) { //keep menu going until system exit
		
			
		System.out.println("Hello! To get started, please read below and enter your option!"); //menu options below	
		
		System.out.println("Option A: Name echo x20!"); //say name 20 times
		
		System.out.println("Option B: Double aged!"); //multiply age by 2
		
		System.out.println("Option C: Teenager? Or not?"); //determine if teenager or not
		
		System.out.println("Option D: Triangles!"); //make triangle patterns
		
		System.out.println("Option E: Exit program."); //exit program
		
		System.out.println(); //I just want a new line here
		
		
			String option = input.next(); //user input for what option they want
		
			char o = option.charAt(0); //switch with char value
			
			
		switch (o) {
		
			case 'A': //fall through, in case case sensitivity matters
		
			case 'a':
				
					System.out.println(); //you will see new line a lot. I like my menu clean
				
					System.out.println("Can I get your first name please?");
				
					String firstname = input.next(); //get user input for first name
					
					System.out.println();
				
					System.out.printf("%s. I like that name. So much that I'll say it 20 times! %n", firstname);
				
					System.out.println();
					
						for (int i = 1; i <= 20; i++) { 
					
//makes it easier to print out the name. I even include numbers for insurance that it is twenty
					
							System.out.printf("%s. ", i); //number counter
						
							System.out.printf("%s %n", firstname); //name given
									
						}
						
					System.out.println();
				
			break;
				
				
			case 'B':	
				
			case 'b':
				
					System.out.println();
				
					System.out.println("Can I get your age, please?"); //get users age
				
					int age = input.nextInt();
				
					int age2 = age * 2; //double the age given
					
					System.out.println();
				
					System.out.printf("You are %d. Double that is %d!", age, age2); //displays both original age and then doubled
				
					System.out.println();
					
					System.out.println();
					
				
			break;
			
			
			case 'C':
			
			case 'c':
				
					System.out.println();
				
					System.out.println("Can I get your age, please?");
					
					int age1 = input.nextInt();
					
					if ((age1 >= 13) && (age1 <= 19)) { //my teenage age range is 13 through 19
					
						System.out.printf("You are %d. Therefore, you are a teenager.", age1);
						
						System.out.println();
						
						System.out.println();

					}
					
					else { //any other age besides 13 through 19
						
						System.out.printf("You are %d. Therefore you are NOT a teenager.", age1);
						
						System.out.println();
						
						System.out.println();
						
					}
				
			break;
			
			
			case 'D':
				
			case 'd': 
			
				
			System.out.println();

			
		try { 
			
			
			File input1 = new File("Triangle.txt"); //create the actual file
			

			FileWriter tri_out = new FileWriter(input1); //output the actual file
			
			
			if (!input1.canWrite()) { //test for file creation
				
				System.out.println("File cannot be created.");
				
				System.exit(1);
				
				
			}
			
			
			System.out.println("Please enter a number from 3 to 50: ");
			
			int triangle1 = input.nextInt();
			
			System.out.println();

			

			if ((triangle1 <= 50) && (triangle1 >= 3)) { //ensure 3-50 range
			
			
			for (int i = 1; i <= triangle1; i++) { //I am using a right triangle loop
				
				for (int j = 1; j <= i; j++) {
					
					
					System.out.print("*"); //for displaying on screen
					
					
					tri_out.write("*"); //for displaying in new text file
					
					
				}
				
				
				System.out.println(" "); //for displaying on screen
				
				
				tri_out.write(" "); //for displaying in text file
				
				tri_out.write("\n"); //for displaying in text file
				
				}
			
			System.out.println();
			
			System.out.println("Triangle.txt has been created. Check it out!");
			
			}
			
			
			
			
			else { //if not within 3-50 range
				
				System.out.println("I am sorry, I cannot print with that value. Please select from the menu and try again.");
				
			}
			
		

			System.out.println();

		tri_out.write("\n");
			
		tri_out.write("Congratulations on your new triangle!"); //written in file
		
		tri_out.close(); //close file
		
		
		} //end try
		
		
		catch (FileNotFoundException e) { //need it to complete try/catch
	
			e.printStackTrace();
	
		}
				
		
					
			break;
				
				
			
	case 'E':
		
	case 'e':
		
			System.out.println();
		
			System.out.println("Thank you for playing!"); 
		
			System.exit(1); //user is done, exit program
			
	break;
			
			
	default: 
		
		System.out.println();
		
		System.out.println("Input invalid. Please try again."); //if user uses other characters
		
		System.out.println();
		
	break;
			
			
		}
		

	
		}
			
	}

	
	
	
}
		