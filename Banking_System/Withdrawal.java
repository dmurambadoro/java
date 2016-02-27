
public class Withdrawal extends Transaction {
	
	
	@Override
	public boolean process() {

		boolean processResult = false;
		
		// If withdrawal amount > account balance, display insufficient balance
		// notification

		if (getAnAccount().getEndingBalance() < getAmount()) {
			System.out.println("Insufficient funds in: "
					+ getAnAccount().getAccountNbr()
					+ " , cannot issue cash at this time!");
		}

		else {
			
			// Subtract amount from balance
			getAnAccount().setEndingBalance(getAnAccount().getEndingBalance() - getAmount()); 
			processResult = true;
			
			// close account if balance = 0 (from function in Transaction class)
			closeAccountWithZeroBalance();
			
			getAnAccount().setEndingTotalTransCount(getAnAccount().getEndingTotalTransCount() + 1);
			
		}

		return processResult;
	}
}
