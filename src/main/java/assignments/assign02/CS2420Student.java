package assignments.assign02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CS2420Student extends UofUStudent {

    private EmailAddress contactInfo;
    private Map<String, List<Double>> scores;

    /**
     * Creates a student from the given first name, last name, and uNID.
     *
     * @param firstName
     * @param lastName
     * @param uNID
     * @param contactInfo
     */
    public CS2420Student(String firstName, String lastName, int uNID, EmailAddress contactInfo) {
        super(firstName, lastName, uNID);
        this.contactInfo = contactInfo;
        scores = new HashMap<>();
        scores.put("assignment", new ArrayList<>());
        scores.put("exam", new ArrayList<>());
        scores.put("lab", new ArrayList<>());
        scores.put("quiz", new ArrayList<>());
    }

    public EmailAddress getContactInfo()
    {
        return contactInfo;
    }

    /**
     * Adds a percent score to the specified category.
     * @param score
     * @param category
     */
    public void addScore(double score, String category)
    {
        if(0.0 > score || score > 100.0) throw new IllegalArgumentException("score must be within the range 0.0 to 100.0");
        switch(category)
        {
            case "assignment" -> scores.get(category).add(score);
            case "exam" -> scores.get(category).add(score);
            case "lab" -> scores.get(category).add(score);
            case "quiz" -> scores.get(category).add(score);
        }
    }

    /**
     * Checks whether the student can be graded.
     *
     * @return
     * Returns {@code true} if the student has at least one score
     * in each category.
     */
    private boolean canBeGraded()
    {
        for(List<Double> type : this.scores.values())
            if(type.isEmpty()) return false;
        return true;
    }

    /**
     * Computes the average of the contents in a List of type Double
     * @param array
     * The array to be averaged.
     * @return
     * The end result.
     */
    private double average(List<Double> array)
    {
        if(array.size() == 0) return 0.0;
        double output = array.get(0);
        for(int i = 1; i < array.size(); i++)
        {
            output += array.get(i);
        }
        return output / array.size();
    }

    /**
     * Calculates the final score based on the following rubric:
     * Exams -- 45%
     * Assignments -- 35%
     * Quizzes -- 10%
     * Labs -- 10%
     * If the Exams score is less than 65%, then the final grade is
     * equal to the exam score.
     *
     * @return
     * A double value representing the percent final grade
     */
    public double computeFinalScore()
    {
        if(!canBeGraded()) return 0.0;
        double totalScore = 0.0;
        // Assignments -- 35%
        totalScore += average(this.scores.get("assignment")) * 0.35;
        // Quizzes -- 10%
        totalScore += average(this.scores.get("quiz")) * 0.1;
        // Labs -- 10%
        totalScore += average(this.scores.get("lab")) * 0.1;
        // Exams -- 45%
        double examTotal = average(this.scores.get("exam"));
        if(examTotal < 65.0) totalScore = examTotal;
        else totalScore += examTotal * 0.45;

        return totalScore;
    }

    /**
     * Computes the final letter grade based on the final score according
     * to the following rubric:
     * A :	100% - 93%
     * A-:	92.9% - 90%
     * B+:	89.9%–87%
     * B :	86.9%–83%
     * B-:	82.9% - 80%
     * C+:	79.9%–77%
     * C :	76.9%–73%
     * C-:	72.9% - 70%
     * D+:	69.9%–67%
     * D :	66.9%–63%
     * D-:	62.9% - 60%
     * E :	59.9%–0%
     *
     * @return
     * A letter in the range A-E, sometimes with a +/- sign after if
     * the student can be graded. If the student can't be graded,
     * returns N/A.
     */
    public String computeFinalGrade()
    {
        if(!canBeGraded()) return "N/A";
        double finalScore = this.computeFinalScore();
        if(finalScore >= 93) return "A";
        else if(finalScore >= 90) return "A-";
        else if(finalScore >= 87) return "B+";
        else if(finalScore >= 83) return "B";
        else if(finalScore >= 80) return "B-";
        else if(finalScore >= 77) return "C+";
        else if(finalScore >= 73) return "C";
        else if(finalScore >= 70) return "C-";
        else if(finalScore >= 67) return "D+";
        else if(finalScore >= 63) return "D";
        else if(finalScore >= 60) return "D-";
        else  return "E";
    }
}
