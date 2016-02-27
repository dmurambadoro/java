

import java.util.ArrayList;

public abstract class  Question {
	// Question data is public because Test needs it to populate it from
	// TestData
	private String questionType; // t=question type //TODO questionType changed from t; public to private
	private int pointsPossible; //TODO changed private from public; make instance variables private
	private String questionText; // qt=question text //TODO questionText changed from qt; public to private
	
	private ArrayList<String> optionArray = new ArrayList<String>(); //TODO private from public
	private ArrayList<String> correctOption = new ArrayList<String>();
	private ArrayList<String> studentAnswer = new ArrayList<String>();

	private int pointsAwarded;
	
	// Constants: question types
	final static String TRUE_FALSE = "True-False";
	final static String SINGLE_CORRECT = "Single-Correct";
	final static String MULTI_CORRECT = "Multi-Correct";
	final static String SHORT_ANSWER = "Short Answer";
	final static String LONG_ANSWER = "Long Answer";
	
	////Constant: question array
	final static int QUESTION_TYPE = 2;
	final static int QUESTION_TEXT = 3;
	final static int POSSIBLE_POINTS = 4;
	
	//Constant: option array
	final static int CORRECT_OPTION = 2;
	
	//String [] questionDataRow = TestData.getQuestions()[index]; //get row of data to an array variable

	// Builds each question
	//TODO buildQuestion method moved from Test class; changed from a "two" to "one" parameter method
	
	//public void buildQuestion(int index) {
	public void buildQuestion(String [] questionDataRow) {
		//String [] questionDataRow = TestData.getQuestions()[index]; //get row of data to an array variable
		
		setQuestionType(questionDataRow[QUESTION_TYPE]);
		setQuestionType(questionDataRow[QUESTION_TEXT]);
		setPointsPossible(Integer.parseInt(questionDataRow[POSSIBLE_POINTS]));
		
		/*setQuestionType(TestData.getQuestions()[index][2]); //FIXME use a variable to get a row of data; also constants for indexes
		setQuestionText(TestData.getQuestions()[index][3]);
		setPointsPossible(Integer.parseInt(TestData.getQuestions()[index][4]));*/
		
		
		for (int i = 0; i < TestData.getOptions().length; i++) {
			String[] optionDataRow = TestData.getOptions()[i];
			//getOptionArray().add(TestData.getOptions()[i][2]); 
			getOptionArray().add(optionDataRow[CORRECT_OPTION]);// TODO Option array now private; used getter method
		}
	}
	
	// Performs the following functions...
	// 1) Determines type of question
	// 2) Determines if studentAnswer matches correctOption
	// 3) Based on type of question, uses the student's answer to add all, some,
	//      or none of the pointsPossible to pointsAwarded
	// 4) Prints out a message to the console on whether the //TODO incomplete comment here; line 4 should be in sub-classes
		
	// make grade() an abstract method to be implemented in sub-classes; ensure this class is abstract
	public abstract boolean  grade(); //{ // changed name from proc() // TODO executes grade() in SUB-CLASS first
		
	
	
	// Getters and Setters
	// optionArray
	public ArrayList<String> getOptionArray() {
		return optionArray;
	}	
	public void setOptionArray(ArrayList<String> optionArray) {
		this.optionArray = optionArray;
	}
	// pointsPossible
	public int getPointsPossible() {
		return pointsPossible;
	}
	public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	// questionText
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	// questionType
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	// pointsAwarded
	public int getPointsAwarded() {
		return pointsAwarded;
	}
	public void setPointsAwarded(int pointsAwarded) {
		this.pointsAwarded = pointsAwarded;
	}
	// studentAnswer arrayList
	public ArrayList<String> getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(ArrayList<String> studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	// correctOption arrayList
	public ArrayList<String> getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(ArrayList<String> correctOption) {
		this.correctOption = correctOption;
	}
	
	// Get question type and instantiates Question objects/sub-classes
		public static Question getQuestionType(String questionType) {
			Question question = null;
			
			/*if (TRUE_FALSE.equals(questionType)
			{
				question = new TrueFalse();
			}
			
			else if(SINGLE_CORRECT.equals(questionType)) 
			{
				question = new SingleCorrect();
			}*/
						
			
			if(MULTI_CORRECT.equals(questionType)) 
			{
				question = new MultiCorrect();
			}
			else if(SHORT_ANSWER.equals(questionType)) 
			{
				question = new ShortAnswer();
			}
			else if(LONG_ANSWER.equals(questionType)) 
			{
				question = new LongAnswer();
			}
			
			else if (TRUE_FALSE.equals(questionType) || SINGLE_CORRECT.equals(questionType))
			{
				question = new SingleCorrect();
			}
			else {
				// validation taken care of here
				System.out.println("This is a bad question type: " + questionType); 
			}
			
			return question;
		}
	

}
