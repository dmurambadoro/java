
public class MainApp {

	public static void main(String[] args) {
		
		TestingSystem testingSystem = TestingSystem.getInstance();  // Singleton design
		testingSystem.loadTestArray();  // call method to load tests
		
	}

}

