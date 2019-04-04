import java.util.ArrayList;

class CourseArea
{
	private String name;
	private ArrayList<Course> courses;
	
	public CourseArea(String nameIn)
	{
		name = nameIn;
	}
	
	public void addCourse(String courseName)
	{
		courses.add(Transcript.getCourseByName(courseName));
	}

	public String getName() 
	{
		return name;
	}
}
