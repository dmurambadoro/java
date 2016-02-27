import java.util.Date;

public abstract class Transaction implements ITransaction { // "abstract" so
	// "process" method
	// is implemented in
	// subclasses
	
	private String fromAccountNbr; // from account number
	private String toAccountNbr; // to account number
	private char transType;
	private Date processDate;
	private double amount;

	private Account anAccount; // allows trans/account interaction

	// Getters
	public String getFromAccountNbr() {
		return fromAccountNbr;
	}

	public String getToAccountNbr() {
		return toAccountNbr;
	}

	public char getTransType() {
		return transType;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public double getAmount() {
		return amount;
	}

	public Account getAnAccount() {
		return anAccount;
	}

	// Setters
	public void setFromAccountNbr(String fromAccountNbr) {
		this.fromAccountNbr = fromAccountNbr;
	}

	public void setToAccountNbr(String toAccountNbr) {
		this.toAccountNbr = toAccountNbr;
	}

	public void setTransType(char transType) {
		this.transType = transType;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public void setAmount(double amount) {
		if (amount < 0) {
			amount = 0;
		}
		this.amount = amount;
	}

	public void setAnAccount(Account anAccount) {
		this.anAccount = anAccount;
	}

	@Override
	public void build(TransactionParser tp) { // build method (from interface) implemented here
		// Assign values to claim variables
		setFromAccountNbr(tp.getFromAccountNumber()); // same as: fromAccountNbr = tp.getFromAccountNumber();
		
		setTransType(tp.getTransactionType());
		setProcessDate(tp.getProcessDate());
		setAmount(tp.getAmount());
		
		// returns a null or a reference to an account object
		//setAnAccount(BankSystem.getInstance().getAccount(tp.getFromAccountNumber()));
		anAccount = BankSystem.getInstance().getAccount(tp.getFromAccountNumber()); //same as line above
		
		// if account is not found, display error message
		if (anAccount == null) { 
			System.out.println("Account: " + tp.getFromAccountNumber()
					+ " could not be found.");
		}

	}

	// Get a transaction object with data
	public static Transaction getTransType(TransactionParser tp) {

		Transaction transaction = null; // set transaction reference to null

		switch (tp.getTransactionType()) {

		case DEPOSIT: { // Deposit (variable declared in ITransaction class)
			transaction = new Deposit();

			break;
		}

		case WITHDRAWAL: { // Withdrawal
			transaction = new Withdrawal();

			break;
		}

		case OPEN_ACCOUNT: { // Open account
			transaction = new OpenAccount();
			break;
		}

		case CLOSE_ACCOUNT: { // Close account
			transaction = new CloseAccount();
			break;
		}

		default: {
			System.out.println("For account: " + tp.getFromAccountNumber()
					+ " transaction: " + tp.getTransactionType()
					+ " is invalid");
		}

		}
		return transaction;
	}

	// Close account method - used in withdraw and close accounts
	// sub-transaction types
	public boolean closeAccountWithZeroBalance() {
		boolean processResult = false;

		if (getAnAccount().getEndingBalance() == 0) 
		{ 

			getAnAccount().setAccountStatus(CLOSED);

			processResult = true;
		}

		else {
			System.out.println("Cannot close account: "
					+ getAnAccount().getAccountNbr()
					+ " because it has a positive balance!");
		}

		return processResult;
	}
}



