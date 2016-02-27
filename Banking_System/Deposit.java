
public class Deposit extends Transaction {

	@Override
	public boolean process() {
		boolean processResult = false; // set result to false

		if (getAmount() > 0) { // process deposit if amount > 0
			
			// update account balance			
			getAnAccount().setEndingBalance(getAnAccount().getEndingBalance() + getAmount());
			
			// increment transactions processed
			getAnAccount().setEndingTotalTransCount(getAnAccount().getEndingTotalTransCount() + 1);
			
			processResult = true; // transaction successful
		}
		
		
		return processResult;
	}
}

