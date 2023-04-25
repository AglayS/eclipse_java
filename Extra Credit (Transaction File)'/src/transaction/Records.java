package transaction;

public class Records {

	private int account;
	
	private String firstname;
	
	private String lastname;
	
	private double balance;
	
	
	public Records() {
		
		this(0, "","",0.0);
		
	}
	
	public Records(int acct, String first, String last, double bal) {
		
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
		
		
	}
	
	public void combine (TransactionRecord transaction) { //create class later
		
		balance = balance + transaction.getAmount();
		
	}
	
	public void setAccount(int acct) {
		
		account = acct;
		
	}
	
	public int getAccount() {
		
		return account;
		
	}
	
	public void setFirstName(String first) {
		
		firstname = first;
		
	}
	
	public String getFirstName() {
		
		return firstname;
		
	}
	
	public void setLastName(String last) {
		
		lastname = last;
		
	}
	
	public String getLastName() {
		
		return lastname;
		
	}
	
	public void setBalance(double bal) {
		
		balance = bal;
		
	}
	
	public double getBalance() {
		
		return balance;
		
	}

	
}
	
	
	
	
	

