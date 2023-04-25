package transaction;


import java.io.File;

import java.util.Formatter;

import java.util.FormatterClosedException;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {

	private static Scanner inOldmaster;
	private static Scanner inTransaction;
	private static Formatter outNewMaster;
	private static Formatter logFile;
	private static TransactionRecord transaction;
	private static Records account;
	
	public FileMatch() { //constructor
		
		transaction = new TransactionRecord();
		account = new Records();
		
	}
	
	public void openFiles() {
		
		try {
			
			//file streams for input and output files 
			
			inOldmaster = new Scanner(new File("oldmast.txt"));
			
			inTransaction = new Scanner(new File("trans.txt"));
			
			outNewMaster = new Formatter("newmast.txt");
			
			logFile = new Formatter("log.txt");
			
		}
		
		catch (Exception exception) {
			
			System.err.println("Error opening the files.");
			
			
		}
		
		
	}
	
	public void processFiles() {
		
		int transactionAccountNumber;
		
		int accountNumber;
		
		try {
			
			transaction = getTransactionRecord();
			
			if (transaction == null) {
				
				return;
				
			}
			
			transactionAccountNumber = transaction.getAccount();
			
			account = getRecords();
			
			if (account == null) {
				
				return;
				
			}
			
			accountNumber = account.getAccount();
			
			while (accountNumber != 0) {
				
				while (accountNumber < transactionAccountNumber) {
					
					outNewMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
					
					account = getRecords(); //new account
					
					if (account == null) {
					
						return;
						
				}
				
				accountNumber = account.getAccount();
				
				
			}
				
				if (accountNumber == transactionAccountNumber) {
					
					account.combine(transaction);
					
					outNewMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
					
					transaction = getTransactionRecord();
					
					if (transaction == null) {
						
						return;
						
					}
					
					transactionAccountNumber = transaction.getAccount();
					
					account = getRecords();
					
					if (account == null) {
						
						return;
						
					}
					
					accountNumber = account.getAccount();
					
				} //end big if
				
				while (transactionAccountNumber < accountNumber) {
					
					logFile.format("%s %d %n", "Unmatched transaction record for account number.", transactionAccountNumber);
					
					//new transaction
					transaction = getTransactionRecord();
					
					if (transaction == null) {
						
						return;
						
					}
					
					transactionAccountNumber = transaction.getAccount();
					
					
				} //while
				
				
		} //outer while
		
		
	}//end try
		
		catch (FormatterClosedException closedException) {
			
			System.err.println("Error writing to file - file has been closed.");
			
			System.exit(1);
			
		}
		
		catch (IllegalFormatException formatException) {
			
			System.err.println("Error with output.");
			
			System.exit(1);
			
		}
	
	} //end method processFiles
	
	public void closeFiles() {
		
		try {
			
			if (inTransaction != null) {
				
				inTransaction.close();
								
			}
			
			if (outNewMaster != null) {
				
				outNewMaster.close();
				
			}
			
			if (inOldmaster != null) {
				
				inOldmaster.close();
				
			}
			
			if (logFile != null) {
				
				logFile.close();
				
			}
				
		}
		
		catch (Exception exception) {
			
			System.err.println("Error closing files.");
			
			System.exit(1);
			
		}
		
		
	}//end closeFiles
	
private TransactionRecord getTransactionRecord() {
	
	try {
		
		if (inTransaction.hasNext()) {
			
			transaction.setAccount(inTransaction.nextInt());
			
			transaction.setAmount(inTransaction.nextDouble());
			
			return transaction;
			
		}
		
		else {
			
			while (inOldmaster.hasNext()) {
				
				account.setAccount(inOldmaster.nextInt());
				
				account.setFirstName(inOldmaster.next());
				
				account.setLastName(inOldmaster.next());
				
				account.setBalance(inOldmaster.nextDouble());
				
				//store in new master
				outNewMaster.format("%d %s %s %.2f", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
				
				
			} //end while
			
		}//end else
		
		
	} //end try
	
	catch (FormatterClosedException closedException) {
		
		System.err.println("Error writing to file - file has been closed.");
		
		System.exit(1);
		
	} //end catch
	
	catch (IllegalFormatException formatException) {
		
		System.err.println("Error with output.");
		
		System.exit(1);
		
	} //end catch
	
	catch (NoSuchElementException elementException) {
		
		System.err.println("Invalid input from file.");
		
	}
	
	return null; //no more records
	
	
}//end method getTransactionRecord
	

//get an account record

private Records getRecords() {
	
	try { //try to read an account record
	
		if (inOldmaster.hasNext()) {
			
			account.setAccount(inOldmaster.nextInt());
			
			account.setFirstName(inOldmaster.next());
			
			account.setLastName(inOldmaster.next());
			
			account.setBalance(inOldmaster.nextDouble());
	
			return account;
			
		}
	
		else { //end of old master file
			
			logFile.format("%s %d %n", "Unmatched transaction record for accont number.", transaction.getAccount());
			
			//these records are transactions without accounts
			
			while (inTransaction.hasNext()) {
				
				transaction.setAccount(inTransaction.nextInt());
				
				transaction.setAmount(inTransaction.nextDouble());
				
			} //end while
			
		} //end else
	
	
} //end try
	
catch (FormatterClosedException closedException) {
		
		System.err.println("Error writing to file - file has been closed.");
		
		System.exit(1);
		
	} //end catch
	
	catch (IllegalFormatException formatException) {
		
		System.err.println("Error with output.");
		
		System.exit(1);
		
	} //end catch
	
	
	catch (NoSuchElementException elementException) {
		
		System.err.println("Invalid input from file.");
		
	}
	
	return null;
	
	
	} //end method getRecords

} //end class FileMatch
