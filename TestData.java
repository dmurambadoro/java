public class TestData {
	// TODO access type for all arrays changed from public to private
	private static String[][] tests = { // TODO changed array name from myTests
			// Sample test: {"Test ID", "Course Name", "Code", "RoomNbr",
			// "Instructor(s)"},
			{ "Test1", "How to Write Bad Code", "IST 37870", "TH316", "Derek and Aaron" },
			{ "Test2", "Java Fundamentals", "IST 37500", "TH333", "Aaron" } };

	private static String[][] questions = { // TODO changed array name from myQuestions
			// Sample question: {"Test ID", "Question ID", "Question Type",
			// "Question Text", "Points Possible"}
			{ "Test1", "01", "Multi-Correct", 
				"Which of the following are general rules of thumb from this course?", "3" },
			{ "Test1", "02", "True-False", "Every method should have one and only one function.", "1" },
			{ "Test2", "01", "Single-Correct", "Identifying bad code is important because...", "1" },
			{ "Test2", "02", "Short Answer",
					"______________ could be defined as the process of turning bad code into good code.", "3" } };

	private static String[][] options = { // TODO changed array name from myOptions
			// Sample answer: {"Test ID", "Question ID", Correct Options (in an
			// array)}
			{ "Test1", "01", "Methods should be simple" },
			{ "Test1", "01", "Methods should be short" },
			{ "Test1", "01", "Use one concatenated statement if it's easy to understand" },
			{ "Test1", "01",
					"Always use try/catch blocks around any code that may return a null pointer exception" },
			{ "Test1", "02", "True" }, 
			{ "Test1", "02", "False" } };

	private static String[][] correctOptions = { // TODO changed array name from myCorrectOptions
			// Sample answer: {"Test ID", "Question ID", Correct Options (may be
			// multiple if multi-correct question type)}
			{ "Test1", "01", "Methods should be simple" },
			{ "Test1", "01", "Methods should be short" },
			{ "Test1", "01", "Use one concatenated statement if it's easy to understand" },
			{ "Test1", "02", "True" }, };

	private static String[][] studentAnswers = { // TODO changed array name from myStudentAnswers
			// Sample answer: {"Student ID", "Test ID", "Question ID", Answers
			// (may be multiple if multi-correct question type)
			{ "06025", "Test1", "01", "Methods should be simple" },
			{ "06025", "Test1", "01", "Methods should be short" },
			{ "06025", "Test1", "01",
					"Always use try/catch blocks around any code that may return a null pointer exception" },
			{ "06025", "Test1", "02", "True" }, };

	//Getters and Setters for arrays
	//tests
	public static String[][] getTests() {
		return tests;
	}
	
	public static void setTests(String[][] tests) {
		TestData.tests = tests;
	}
	
	//options
	public static String[][] getOptions() {
		return options;
	}
	public static void setOptions(String[][] options) {
		TestData.options = options; // static variable
	}
	
	//correctOptions
	public static String[][] getCorrectOptions() {
		return correctOptions;
	}
	public static void setCorrectOptions(String[][] correctOptions) {
		TestData.correctOptions = correctOptions;
	}
	
	//studentAnswers
	public static String[][] getStudentAnswers() {
		return studentAnswers;
	}
	
	public static void setStudentAnswers(String[][] studentAnswers) {
		TestData.studentAnswers = studentAnswers;
	}
    // questions
	public static String[][] getQuestions() {
		return questions;
	}

	public static void setQuestions(String[][] questions) {
		TestData.questions = questions;
	}
	
	
	

}
