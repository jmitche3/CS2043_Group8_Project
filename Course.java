public class Course
{
	final private String courseCode;
	final private String courseName;
    final private String courseCredit;
	
	public Course(String courseNumber, String courseName, String courseCreditHours)
	{
		this.courseCode = courseNumber;
		this.courseName = courseName;
        this.courseCredit = courseCreditHours;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() 
	{
		return courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() 
	{
		return courseName;
	}

	/**
	 * @return the courseCredit
	 */
	public Double getCourseCredit() 
	{
		Double numCredit;
		numCredit = Double.parseDouble(courseCredit);
		return numCredit;
    }

    /**
     * @return the object as a string
     */
	@Override
	public String toString() 
	{
		return (courseCode +" " +courseName +" " +courseCredit);
	}
	

}