// Grades Short-Answer question
public class ShortAnswer extends Question {
	boolean gradeResult = false;
	public boolean grade() { // grade question

		for (int i = 0; i < getStudentAnswer().size(); i++) {
			if (getStudentAnswer().get(0) == getCorrectOption().get(i)) {
				setPointsAwarded(getPointsPossible());
				gradeResult = true;
				System.out.println("Finished grading a Short-Answer question");

			}
			System.out.println("Could not grade a Short-Answer question");
		}
		return gradeResult;
	}
}