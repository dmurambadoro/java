
public class Account {

	// Variables
	private String accountNumber; // account number
	private double beginningBalance;
	private double endingBalance;
	private char accountStatus;
	
	// Accumulators
	private int beginningTransCount; //beginningTransCount
	private int endingTransCount;
	
		
	
	// Assign values to policy variables (from parser)
	public void build(AccountParser ap ) 
	{
		setAccountNbr(ap.getAccountNumber());
		setBeginningBalance(ap.getBalance());
		setEndingBalance(ap.getBalance());
		setAccountStatus(ap.getStatus());
	
	}
	
	//Getters
	public String getAccountNbr() {
		return accountNumber;
	}
	
	public double getBeginningBalance() {
		return beginningBalance;
	}
	public double getEndingBalance() {
		return endingBalance;
	}
		
	public char getAccountStatus() {
		return accountStatus;
	}
	
	public int getBeginningTotalTransCount() {
		return beginningTransCount;
	}

	public int getEndingTotalTransCount() {
		return endingTransCount;
	}

	
	//Setters
	public void setAccountNbr(String accountNbr) {
		this.accountNumber = accountNbr;
	}

	public void setBeginningBalance(double beginningBalance) {
		this.beginningBalance = beginningBalance;
	}
	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}
	public void setAccountStatus(char accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public void setBeginningTotalTransCount(int beginningTransCount) {
		this.beginningTransCount = beginningTransCount;
	}

	public void setEndingTotalTransCount(int endingTransCount) {
		this.endingTransCount = endingTransCount;
	}

	
	public void print() {
		// display output data
		System.out.println();
		System.out.println("Account# :   " + accountNumber);

		System.out.println("Beginning number of transactions:   " + beginningTransCount); 
		System.out.println("Ending number of transactions:   " + endingTransCount); 
		
		System.out.println("Beginning account balance:   " + getBeginningBalance());
		System.out.println("Ending account balance:   " + getEndingBalance());
		
	}

}
