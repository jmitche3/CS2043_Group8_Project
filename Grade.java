public class Grade {
    final private String LetterGrade;
    final private String SectionNumber;
    final private String YearTaken;
    final private String School;
    final private Course Course;
    private Double gradePoints;

    public Grade(String letterGrade, String sectionNumber, String yearTaken, String school, Course course) {
        this.LetterGrade = letterGrade;
        this.SectionNumber = sectionNumber;
        this.YearTaken = yearTaken;
        this.School = school;
        this.Course = course;
        this.gradePoints = this.getGradePoint();
    }

    /**
     * @return the letterGrade
     */
    public String getLetterGrade() {
        return LetterGrade;
    }

    /**
     * @return the sectionNumber
     */
    public String getSectionNumber() {
        return SectionNumber;
    }

    /**
     * @return the yearTaken
     */
    public String getYearTaken() {
        return YearTaken;
    }
    
    /**
     * @return the school
     */
    public String getSchool() {
        return School;
    }

    /**
     * @return the course object
     */
    public Course getCourse() {
        return Course;
    }

    public double getGradePoint() {
        Double numericalGrade;
        switch (this.getLetterGrade()) {
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
        return (numericalGrade * Course.getCourseCredit());
    }

}