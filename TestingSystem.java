import java.util.ArrayList;

public class TestingSystem {
	private static TestingSystem instance;

	private ArrayList<Test> testArray = new ArrayList<Test>();

	private TestingSystem() {
	}

	// Singleton pattern. Get the instance of the TestingSystem
	public static TestingSystem getInstance() {
		if (instance == null) 
		{
			instance = new TestingSystem();
			//return instance; // TODO commented out; one return is enough; return must be at the end
		//} else {
			
		}
		return instance;
	}

	// Builds the tests and add the tests to the array list.
	public void loadTestArray() { //TODO method name changed from doStuff()
		//Test test; // TODO test reference changed from myTest

		for (int i = 0; i < TestData.getTests().length; i++) { // TODO myTests changed to tests
			//TODO ComputerBasedTest() and InternetBasedTest() deleted; shared common code
			// code moved to super-class: Test in function gradeTest(); code below therefore commmented out
						
			/*if (TestData.getTests()[i][0] == "CBT") { 
				test = new ComputerBasedTest();
			} else { // getTests()[1][0]
				test = new InternetBasedTest();
			}*/
			
			Test test = new Test();  // TODO changed Test class from abstract to allow instantiation

			test.buildAndGradeQuestions(); // builds tests
			testArray.add(test);  // adds test to an arrayList
		}
	}
}
