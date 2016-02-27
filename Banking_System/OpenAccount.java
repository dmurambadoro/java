
public class OpenAccount extends Transaction {

		
	@Override
	public boolean process() {

		boolean processResult = false;
		//Account accountFromArray = null;
		
		Account account = new Account(); // create a new account
		
		//populate account object with transaction data
		account.setAccountNbr(getFromAccountNbr());
		account.setAccountStatus(ACTIVE); // defined in interface
		account.setBeginningBalance(0); // set beginning balance to zero for new account
		account.setEndingBalance(getAmount()); // for new account, beginning balance equals amount
        				
		// check if an account with supplied account number exists in array
		//accountFromArray = BankSystem.getInstance().getAccount(getFromAccountNbr());
										
		if (this.getAnAccount() == null) {	
			// add new account to group
			BankSystem.getInstance().getAccountArray().add(account);
			
			System.out.println("A new account: " + account.getAccountNbr()
					+ " has been created and activated ...");
			
			// increment transactions processed
			account.setEndingTotalTransCount(account.getEndingTotalTransCount() + 1);

			processResult = true; // account successfully added

		}
		return processResult;
	}
}

