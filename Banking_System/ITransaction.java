
public interface ITransaction {
	
	// Constants - transaction types
	final static char CLOSE_ACCOUNT = 'C';
	final static char DEPOSIT = 'D';
	final static char OPEN_ACCOUNT = 'O';
	final static char WITHDRAWAL = 'W';
	
	// Constants - account status
	final static char ACTIVE = 'A';
	final static char CLOSED = 'C';
		
	// All interface methods are abstract (e.g "public abstract boolean process"
	boolean process();

	void build(TransactionParser tp);
}
