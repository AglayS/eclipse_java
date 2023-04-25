package HW1;

/*  Name: Aglay Saenz  
Course: CNT 4714 Summer 2022 
Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking 
Due Date: June 5, 2022 
*/ 

public class main { //main = threads class

	public static void main (String[] args) {
		
		
		accountInfo account = new accountInfo(); //function to make the big bank account

		
		System.out.printf("Deposit Agents\t\t\tWithdrawal Agents\t\tBalance\t\t\t\n");
		System.out.printf("---------------\t\t\t-----------------\t\t---------------\t\t\t\n"); //printf outputs for what will be displayed

		//5 depositors (d) and 10 withdraws
		deposit d = new deposit(account);
		withdraw w = new withdraw(account); //new thread types

		Thread d1 = new Thread(d, "1");
		Thread d2 = new Thread(d, "2");
		Thread d3 = new Thread(d, "3");
		Thread d4 = new Thread(d, "4");
		Thread d5 = new Thread(d, "5");
		
		//initialize all threads
		Thread w1 = new Thread(w, "6");
		Thread w2 = new Thread(w, "7");
		Thread w3 = new Thread(w, "8");
		Thread w4 = new Thread(w, "9");
		Thread w5 = new Thread(w, "10"); 
		Thread w6 = new Thread(w, "11");
		Thread w7 = new Thread(w, "12");
		Thread w8 = new Thread(w, "13");
		Thread w9 = new Thread(w, "14");
		Thread w10 = new Thread(w, "15");
		
		
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		w1.start();
		w2.start();
		w3.start();
		w4.start();
		w5.start();
		w6.start();
		w7.start();
		w8.start();
		w9.start();
		w10.start();
		//start all threads
		
	}

} //good
