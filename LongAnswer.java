
public class LongAnswer extends Question {
	boolean gradeResult = false;
	
	public boolean grade() {
		
		// Instructor must hand-grade the answer to this question type
		setPointsAwarded(0);
		System.out.println("Finished grading a Long-Answer question");
		gradeResult = true;
				
		return gradeResult;
	}
}