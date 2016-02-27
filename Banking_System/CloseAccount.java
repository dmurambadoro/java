
public class CloseAccount extends Transaction {
	
		
	@Override
	public boolean process() {
		boolean processResult = false;
		
		// close account if balance = 0 (from Transaction)
		processResult = closeAccountWithZeroBalance(); 
		
		// if a transaction is processed (processResult= true)
		if (processResult) {
			// increment processed transaction count
			getAnAccount().setEndingTotalTransCount(
					getAnAccount().getEndingTotalTransCount() + 1);
		}
		return processResult;
	}
}

