package Group_Project;

public class Course {
	final private String courseCode;
	final private String courseName;
    final private Double courseCredit;
	
	public Course(String courseCodei, String sectionNumberi, String courseNamei, Double courseCrediti) {
		this.courseCode = courseCodei;
		this.courseName = courseNamei;
        this.courseCredit = courseCrediti;
		
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @return the courseCredit
	 */
	public Double getCourseCredit() {
		return courseCredit;
    }

    /**
     * @return the object as a string
     */
	public String toString() {
		return (courseCode +" " +courseName +" " +courseCredit);
	}
	

}