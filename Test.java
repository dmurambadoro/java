import java.util.ArrayList;

//public abstract class Test {
public  class Test { //TODO changed from abstract class to allow instantiation in TestSystem "loadTestArray()"
	public String type;
	
	// Question array must be public because ComputerBasedTest and InternetBasedTest need it
	private ArrayList<Question> questionArray = new ArrayList<Question>(); //TODO private from public; class instance variable
	
	// The following method has these functions...
	// 1) Builds each question in the question array
	// 2) Calls the gradeQuestions method which initiates grading of questions
	public void buildAndGradeQuestions() {  // buildProcessTest()
		buildQuestionArray();
		
		gradeQuestions();  // grade questions
	}
	
	// public abstract void process(); //TODO method "process" changed to "gradeQuestions"
	public void gradeQuestions() 
	{
		for (int i=0; i < getQuestionArray().size(); i++) { // TODO question array replaced with a getter method
			getQuestionArray().get(i).grade(); // TODO changed proc() to grade()
		}
	}
			
	// Build question array
	private void buildQuestionArray() { //TODO  getQuestionArray changed to buildQuestionArray
		for (int index=0; index < TestData.getQuestions().length; index++) { // TODO getter method used to access data from private array
			//Get question type object from if-else statement in getQuestionType method
			Question question = Question.getQuestionType(TestData.getQuestions()[index][2]);
			if (question != null) {
				// use a Question class instance to call its "buildQuestion" method
				question.buildQuestion(TestData.getQuestions()[index]); 
				questionArray.add(question);
			}
		}
	}
		
    // Getter and setter methods: questionArray arrayList
	public ArrayList<Question> getQuestionArray() {
		return questionArray;
	}
	
	public void setQuestionArray(ArrayList<Question> questionArray) { 
		this.questionArray = questionArray;
	}
}
