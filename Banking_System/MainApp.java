public class MainApp {

	public static void main(String[] args) {
		System.out.println("Starting the Banking system ....");
		System.out.println();
		
		// retrieve same copy of banking system
		BankSystem bankSystem  = BankSystem.getInstance(); // singleton design; 
		bankSystem.run(); // invoke run method in banking system
		
		System.out.println();
        System.out.println( "...Thank you for using the Banking System..." );

	}

}
