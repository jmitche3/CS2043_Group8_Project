package Group_Project;

public class Grade {
    final private String letterGrade;
    final private String sectionNumber;
    final private String yearTaken;
    private String school;
    final private Course course;
    private Double gradePoints;

    public Grade(String letterGradeIn, String courseSectionIn, String courseTermIn, Course course) 
    {
        this.letterGrade = letterGradeIn;
        this.sectionNumber = courseSectionIn;
        this.yearTaken = courseTermIn;
        this.school = this.getSchool();
        this.course = course;
        this.gradePoints = this.calculateGradePoint();
    }

    /**
     * @return the letterGrade
     */
    public String getLetterGrade() 
    {
        return letterGrade;
    }

    /**
     * @return the sectionNumber
     */
    public String getSectionNumber() 
    {
        return sectionNumber;
    }

    /**
     * @return the yearTaken
     */
    public String getYearTaken() 
    {
    	String currentYear;
    	currentYear = yearTaken.substring(0,4);
        return currentYear;
    }
    
    /**
     * @return the school (first two letters indicator)
     */
    public String getSchool() 
    {
    	school = sectionNumber.substring(0,2);
        return school;
    }

    /**
     * @return the course object
     */
    public Course getCourse()
    {
        return course;
    }

    public double calculateGradePoint()
    {
        Double numericalGrade;
        switch (this.getLetterGrade())
        {
            case "A+":
                numericalGrade = 4.3;
                break;
            case "A":
                numericalGrade = 4.0;
                break;
            case "A-":
                numericalGrade = 3.7;
                break;
            case "B+":
                numericalGrade = 3.3;
                break;
            case "B":
                numericalGrade = 3.0;
                break;
            case "B-":
                numericalGrade = 2.7;
                break;
            case "C+":
                numericalGrade = 2.3;
                break;
            case "C":
                numericalGrade = 2.0;
                break;
            case "D":
                numericalGrade = 1.0;
                break;
            case "F":
                numericalGrade = 4.0;
                break;
            default:
                return -1;
        }
       gradePoints = (numericalGrade * course.getCourseCredit());
       return gradePoints;
    }
    
    public double getGradePoint()
    {
    	return gradePoints;
    }

}