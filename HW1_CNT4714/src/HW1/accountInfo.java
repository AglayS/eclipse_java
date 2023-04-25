package HW1;

/*  Name: Aglay Saenz  
Course: CNT 4714 Summer 2022 
Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking 
Due Date: June 5, 2022 
*/ 

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;





public class accountInfo implements Runnable { //buffer class
	
	public class TransactionLog {

		public void main(String[] args) {
			
			try {
				
				FileWriter writer = new FileWriter("Transaction Log.txt");
				//writer.write(" ");
				//writer.close();
				
				
			}
			
			catch (IOException e) {
				
				e.printStackTrace();
				
			}

		}

	}


	private int balance;
	private Lock accessLock;
	private Condition enoughFunds;
	
	

	//locking accountInfo
	public accountInfo () {
		
		balance = 0; 
		
		accessLock = new ReentrantLock();
		
		enoughFunds = accessLock.newCondition(); //combine deposit and withdraw
		
	}

	//lock for deposit
	public void deposit () throws InterruptedException {
		
		int money = randomTransaction.newNumber(true); //random money amount deposited (true)
		
		accessLock.lock(); //lock this object
		
			try {
				
				balance += money;
				
				System.out.printf("Agent %s deposits $%-3d\t\t\t\t\t\tBalance is $%-3d\n", Thread.currentThread().getName(), money, balance);
	
				enoughFunds.signalAll(); 
				
				
				if (money > 350) { //does not include 350
					
					
					System.out.printf("* * * Flagged Transaction - Deposit Agent %s Deposit In Excess of $350.00 USD - See Flagged Transaction Log.\n", Thread.currentThread().getName());//, lessMoney);
					
					
					try (FileWriter writer = new FileWriter("Transaction Log.txt", true)) { 
					
					
						if (money > 350) { //does not include 350, redundant perhaps?
						
						writer.write("* * * Flagged Transaction - Deposit Agent " + Thread.currentThread().getName() + " Deposit In Excess of $350.00 USD - This is the Flagged Transaction Log.\n");
					
						}
					}
					
				}
					
			} catch (Exception e) {
				
				System.err.println("Error: " + e.getMessage());
				
			}
			
			finally {
		
				accessLock.unlock(); //unlock this object
		
			}
			
	}

	//lock for withdrawal
	public void withdrawal() throws InterruptedException {
		
		int lessMoney = randomTransaction.newNumber(false); //random money amount withdraw (false)
		
		accessLock.lock();
	
		try { //if we have money, continue. If not, warning message
			
			if (balance > lessMoney) {
				
				balance -= lessMoney;
				
				System.out.printf("\t\t\t\tAgent %s withdraws $%-3d\t\tBalance is $%-3d\n", Thread.currentThread().getName(), lessMoney, balance);   
			
			}
			
	  
			else {
				
				while (balance < lessMoney) {
					
					System.out.printf("\t\t\t\tAgent %s withdraws $%-3d\t(****) WITHDRAWAL BLOCKED - INSUFFICIENT FUNDS!!!\"\n", Thread.currentThread().getName(), lessMoney);
	
					enoughFunds.await();
					
				}
				
			}
			
			
			if (lessMoney > 75) { //does not include 75
				
				System.out.printf("* * * Flagged Transaction - Withdrawal Agent %s Withdrawal In Excess of $75.00 USD - See Flagged Transaction Log.\n", Thread.currentThread().getName());//, lessMoney);
				
			//}
			
			try (FileWriter writer = new FileWriter("Transaction Log.txt", true)) { //ugh
				
				writer.write("* * * Flagged Transaction - Withdrawal Agent " + Thread.currentThread().getName() + "  In Excess of $75.00 USD - This is the Flagged Transaction Log.\n");
			
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			} //withdrawal filewriter is correct
			
			enoughFunds.signal();
			

	} catch (InterruptedException e) {
		
		System.err.println("Error: " + e.getMessage());
	
	} finally {
		
		accessLock.unlock();
	
	}

	}
	

	@Override
	public void run() { //runnable
		// TODO Auto-generated method stub
		
	}

	
	
}//good
