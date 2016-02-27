// Grades a Multi-Correct question
public class MultiCorrect extends Question {
	boolean gradeResult = false;

	public boolean grade() { // grade question

		if (getStudentAnswer().size() == 0) {
			System.out.println("Could not grade a Multi-Correct question");
		} 
		else {

			for (int i = 0; i < getStudentAnswer().size(); i++) {
				int totalCorrect = 0;
				boolean studentAnswerCorrect = false;

				for (int j = 0; j < getCorrectOption().size(); j++) {
					totalCorrect = getCorrectOption().size(); // get arrayList
					// size
					if (getStudentAnswer().get(i) == getCorrectOption().get(j)) {
						studentAnswerCorrect = true;
						break; // gets out of the inner for loop; evaluates the
						// next
						// student answer(outer loop)
					}
				}

				if (studentAnswerCorrect) // answer is correct; increment points
				{
					setPointsAwarded(getPointsAwarded()
							+ (getPointsPossible() / totalCorrect));
				} else { // answer not correct; deduct points
					setPointsAwarded(getPointsAwarded()
							- (getPointsPossible() / totalCorrect));
				}

				if (i == getStudentAnswer().size()) { // print when all student
					// answers have been
					// evaluated
					System.out.println("Finished grading a Multi-Correct question");
					gradeResult = true;
				}

			}
			// not a valid answer
			//System.out.println("Could not grade a Multi-Correct question");
			
		}
		return gradeResult;
	}
}
