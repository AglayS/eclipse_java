import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //scanf basically
		
		System.out.println("Which of these is your favorite video game? Please input the letter only.");
		
		System.out.println("A. The Evil Within");
		
		System.out.println("B. Final Fantasy");
		
		System.out.println("C. Crash Bandicoot");
		
		System.out.println();
		
		char game = scanner.next().charAt(0); //accepts single character value
		
		switch (game) {
		
		case 'A': //break through to next case
		
		case 'a':
			
			System.out.println();
			
			System.out.println("My favorite horror games are both The Evil Within and The Evil Within 2!");
			
			break;
		
		case 'B':
			
		case 'b':
			
			System.out.println();
			
			System.out.println("A very good JRPG series. I always liked Final Fantasy X the most.");
			
			break;
			
		case 'C':
			
		case 'c':
			
			System.out.println();
			
			System.out.println("Awesome platforming!");
			
			break;
			
		
		}
		
		
	}

}
