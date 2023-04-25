package transaction;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Formatter;

import java.util.FormatterClosedException;

import java.util.IllegalFormatException;


public class TransactFile {

	public static void main(String[] args) {
		
		Formatter outOldmaster = null;
		
		Formatter outTransaction = null;
		
		Records accounts [] = new Records[4];
		TransactionRecord transactions [] = new TransactionRecord[4];
		
		//create account records
		
		accounts[0] = new Records(100, "Alan", "Jones", 348.17);
		
		accounts[1] = new Records(300, "Mary", "Smith", 27.19);
		
		accounts[2] = new Records(500, "Sam", "Sharp", 0.00);
		
		accounts[3] = new Records(700, "Suzy", "Green", -14.22);
		
		//create transactions
		
		transactions[0] = new TransactionRecord(100, 27.14);
				
		transactions[1] = new TransactionRecord(300, 62.11);
		
		transactions[2] = new TransactionRecord(400, 100.56);
		
		transactions[3] = new TransactionRecord(900, 82.17);
		
		
	try {
		
		outOldmaster = new Formatter("oldmast.txt");
		
		for (int i = 0; i < accounts.length; i++) {
			
			outOldmaster.format("%d %s %s %.2f%n", accounts[i].getAccount(),accounts[i].getFirstName(), accounts[i].getLastName(), accounts[i].getBalance());
			
			
			
		}
		
		outTransaction = new Formatter("trans.txt");
		
		for (int i = 0; i < transactions.length; i++) {
			
			outTransaction.format("%d %.2f%n", transactions[i].getAccount(), transactions[i].getAmount());
			
			
			
		}
		
	}
	
	catch (SecurityException securityException) {
		
		System.err.println("You do not have write access to this file.");
		
		System.exit(1);
		
	}
		
	catch (FileNotFoundException fileNotFoundException) {
		
		System.err.println("Error creating file.");
		
		System.exit(1);
		
		
	}
		
		
	catch (IllegalFormatException formatException) {
		
		System.err.println("Error with output");
		
		System.exit(1);
		
	}
	
	
	catch (FormatterClosedException closedException) {
		
		System.err.println("Error writing to file - file has been closed.");
		
		System.exit(1);
		
	}
	
	finally {
		
		if (outOldmaster != null) {
			
			outOldmaster.close();
			
		}
		
		if(outTransaction != null); {
			
			outTransaction.close();
			
		}
		
	}
		
	}

}
