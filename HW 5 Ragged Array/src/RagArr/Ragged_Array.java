package RagArr;

import java.util.Scanner;

public class Ragged_Array {

	
	//Aglay Saenz, 2/28/2020
	
	
	public static void main(String[] args) {
		
		menu(); //function here
		
	}

		
	
	public static void menu() { //separate function, because this would be a mess in main
		
		int student[][] = new int[25][]; //# rows
		
		int index = 0;
		
		int o; //option
		
		int maxExams = 0; //max exams a student can take
		
		Scanner input = new Scanner(System.in); //get user input
		
		
		
		do { //iterate at least once
			
			System.out.println("Press 1 to input grades for next student.");
			
			System.out.println("Press 2 to display average by student.");
			
			System.out.println("Press 3 to display average by exam.");
			
			System.out.println("Press 4 to display current average for all exams.");
			
			System.out.println("Press 5 to exit program.");
			
			
			o = input.nextInt();
			
		
			if (o == 1) { //take user input for grades and number of exams
				
				
				System.out.println("How many exams this student took?");
				
				
				int number_of_exam = input.nextInt();
				
				
				student[index] = new int[number_of_exam];
				
				
				System.out.println("Please enter each exam score one by one.");
				
					if (maxExams < number_of_exam) { //initialized to zero but it will change after given user input
						
						maxExams = number_of_exam;
						
					}
					
					
					
					for (int i = 0; i < number_of_exam; i++) {
						
						student[index][i] = input.nextInt();
						
						
					}
					
					index++; //count each student
				
				
			}
					
					
		
			
			if (o == 2) { //average for each student
				
				
				System.out.println("Average by Student ID");
				
				System.out.println("Student ID \t Average Score");
				
				
				for (int i = 0; i < index; i++) {
					
					
					double sum = 0.0;
					
					
					for (int j = 0; j < student[i].length; j++) {
						
						sum += student[i][j]; 
						
					}
					
					
					double avg = sum / (student[i].length); //average
					
					System.out.printf((i + 1) + "\t\t %.2f ", avg);
					
					System.out.println();
					
				}
				
				
				
			}
			
			
			if (o == 3) { //average for each exam
				
				
				System.out.println("Average by Exam Number");
				
				System.out.println("Exam Number \t Average Score");
				
				
				for (int i = 0; i < maxExams; i++) { //up to # of exams they took
					
					
					double sum = 0;
					
					double total = 0;
					
					
					for (int j = 0; j < index; j++) { 
						
						
						if (student[j].length >= (i + 1)) {
							
							total++;
							
							sum += student[j][i];
							
						}
						
					}
					
					
					double average = sum / total;
					
					System.out.printf((i + 1) + "\t\t");
					
					System.out.printf("%.2f", average);
					
					System.out.println();
					
					
					
				}
				
			}
				
				if (o == 4) { //get average for ALL exams
					
					
					double sumOfEvery = 0.0;

					
					for (int i = 0; i < index; i++) {
						
						
						double sum = 0.0;
						
						
						for (int j = 0; j < student[i].length; j++) {
							
							sum += student[i][j];
						
						}
						
						double average = sum / (student[i].length);
						
						sumOfEvery += average;
						
						
						
					}
		
					double total_average = (sumOfEvery) / (index);
					
					System.out.printf("Current class average for all exams is: " + "%.2f", total_average);
					
					System.out.println();
					
					System.out.println();
					
				}
		
			
		} while (o != 5); //while not choosing to end the program
		
	
	}
	

}
	
	
	

		
		