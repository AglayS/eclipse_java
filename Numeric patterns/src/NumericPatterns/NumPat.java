package NumericPatterns;



public class NumPat {

	public static void printNums (int n) { //Simple number program
		
		int i, j, num;
		
		for (i = 0; i < n; i++) { //outer loop for rows
			
			num = 1;
			
			for (j = 0; j <= i; j++) { //inner loop for rows
				
				System.out.print(num + " "); //print num with space
				
				num++; //increment num
				
			}
			
			System.out.println(); //ending line after each row
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		int n = 5;
		
		printNums(n); 
		
		

	}

}
