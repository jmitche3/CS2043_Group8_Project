public class Grade {
    final private String letterGrade;
    final private String sectionNumber;
    final private String yearTaken;
    final private String school;
    final private Course course;

    public Grade(String letterGrade, String sectionNumber, String yearTaken, String school, Course course) {
        this.letterGrade = letterGrade;
        this.sectionNumber = sectionNumber;
        this.yearTaken = yearTaken;
        this.school = school;
        this.course = course;
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

}