// Grades Single-Correct or True-False questions

public class SingleCorrect extends Question {
	boolean gradeResult = false;

	public boolean grade() { // grade Single-Correct or True-False question

		if (getStudentAnswer().get(0) == getCorrectOption().get(0)) {
			setPointsAwarded(getPointsPossible());
			gradeResult = true;
			
			System.out.println("Finished grading a " + getQuestionType() + " question");
		}

		
		return gradeResult;
	}
	

}
