import java.util.List;
import java.util.ArrayList;

class CourseArea
{
	private String name;
	private List<Course> courses = new ArrayList<Course>();
	
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
	
	public boolean isCourseInArea(Course course)
	{
		return courses.contains(course);
	}
}
