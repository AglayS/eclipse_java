package HW1;

/*  Name: Aglay Saenz  
Course: CNT 4714 Summer 2022 
Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking 
Due Date: June 5, 2022 
*/ 

import java.util.Random;

public class withdraw implements Runnable {
	
	private accountInfo account;
	private static Random rand = new Random();

	//link to main account
	public withdraw (accountInfo mainAccount) {
	
		account = mainAccount;

	}

	public void run () {
	
		try {
		
			while (true) {
			
				account.withdrawal();

				Thread.sleep(rand.nextInt(100)); //random sleep

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}
	
} //good