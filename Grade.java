import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Grade {
    final private String LetterGrade;
    final private String SectionNumber;
    final private String YearTaken;
    final private String School;
    final private Course Course;
    private Double gradePoints;

    public Grade(String letterGrade, String sectionNumber, String yearTaken, String school, Course course) {
        this.letterGrade = letterGrade;
        this.sectionNumber = sectionNumber;
        this.yearTaken = yearTaken;
        this.school = school;
        this.course = course;
        this.gradePoints = this.getGradePoint();
    }

    /**
     * @return the letterGrade
     */
    public String getLetterGrade() {
        return letterGrade;
    }

    /**
     * @return the sectionNumber
     */
    public String getSectionNumber() {
        return sectionNumber;
    }

    /**
     * @return the yearTaken
     */
    public String getYearTaken() {
        return yearTaken;
    }
    
    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @return the course object
     */
    public Course getCourse() {
        return course;
    }

    public double getGradePoint() {
        Double numericalGrade;
        switch (ths.getLetterGrade()) {
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
        return (numericalGrade * course.getCorseCredit());
    }

}