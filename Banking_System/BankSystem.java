import java.util.ArrayList;

public class BankSystem
{
    
	//An arrayList of bank accounts
	private ArrayList<Account> accountArray = new ArrayList<Account>();
	
	private int numValidProcessedTrans; // number of processed transactions 
	private int numValidUnProcessedTrans; // number of unprocessed transactions
	
	// Make a reference to the BankSystem	
	private static BankSystem     instance;

    private BankSystem() // constructor
    {
    }
    // Retrieval method - singleton design
    public static BankSystem getInstance()
    {
        if ( instance == null )
        {
            instance = new BankSystem();
        }

        return instance;
    }

    
 // calls other functions in the correct order of execution
    public void run() {  
		// load accounts to array
		loadAccountArray();
				
		// populate transactions
		processTransactions();
		
		// print account details
		printAccountDetails();

	}	
	
    // Load account to a group of accounts
	private void loadAccountArray() {
		// Open and read the master file
		FileUtility masterFile = new FileUtility();
		String masterFileName = "Master.txt";
		masterFile.openReadFile(masterFileName); // open Master.txt to read it
		
		// read first account line
		String accountData = masterFile.getNextLine(); 

		while (accountData != null) // check if accountData is not null
		{
			// reference new AccountParser object with account data
			AccountParser ap = new AccountParser(accountData); 
			Account account = new Account(); // create new account object reference
			account.build(ap); // populate account
			getAccountArray().add(account); // load account to array
			accountData = masterFile.getNextLine();
		}
		
	}
	
	// Getting accounts from array list
	public Account getAccount(String accountNumber) 
	{

		Account account = null; // if no account found return null

		for (int i = 0; i < getAccountArray().size(); i++) {
			Account bankAccount = getAccountArray().get(i); // get account object

			// get matching accounts from accounts and transaction files
			if (bankAccount.getAccountNbr().equals(accountNumber)) 
			{

				account = bankAccount;
				break;
			} 
			
		}
		return account;
	}
	
	// Build and process transactions
	public void processTransactions() { 
		// Open and read the transaction file
		FileUtility transFile = new FileUtility();
		String transFileName = "Trans.txt";
		transFile.openReadFile(transFileName);// open Trans.txt to read it
		
		String transData = transFile.getNextLine(); //read first line of transaction data
				
		while (transData != null) { // not at end of file

			transData = transData.trim(); // remove spaces on line of data
			// make a reference to transaction parser with line of data
			TransactionParser tp = new TransactionParser(transData);
			// Create a transaction reference to transaction object (sub-class)
			Transaction transaction = Transaction.getTransType(tp); 

			if (transaction != null) { // if transaction is valid (not null), build it
				transaction.build(tp); // populate using matching variables
				if (transaction.process()) { // sub-class process method runs
					numValidProcessedTrans++;
				} else {
					numValidUnProcessedTrans++;
				}

			}
			transData = transFile.getNextLine(); // read the next transaction
		}
		
	}	
	
	// Print transaction details for each account
	private void printAccountDetails() {
		for (int index = 0; index < getAccountArray().size(); index++) {
			Account anAccount = getAccountArray().get(index);
			//if (anAccount.getEndBalance()!= 0) // avoids printing invalid transactions
			//{
			   anAccount.print();
			//}
		}
		System.out.println("\n==============   Summary   ================");
		System.out.println("Number of valid transactions processed: " + numValidProcessedTrans);
		System.out.println("Number of valid transactions not processed: " + numValidUnProcessedTrans);
	}
	
	public ArrayList<Account> getAccountArray() {
		return accountArray;
	}
	
	public void setAccountArray(ArrayList<Account> accountArray) {
		this.accountArray = accountArray;
	}
	
	
}
