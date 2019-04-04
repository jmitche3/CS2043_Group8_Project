package Group_Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transcript 
{
	private static Set<Course> uniqueCourses = new HashSet<Course>();

	private ArrayList<Grade> grades = new ArrayList<Grade>();
	
	public static Transcript createTranscript(BufferedReader br) throws IOException
	{
		Transcript transcript = new Transcript();
		String courseNumber = null;
		String courseSection = null;
		String courseName = null;
		String letterGrade = null;
		String courseCreditHours = null;
		String courseTerm = null;
		String[] gradeFields = null;
		Course course = null;
		Grade grade = null;
		
		String line = br.readLine(); 

		while (line != null) 
		{ 
			gradeFields = line.split("\\s{2,}");
			
			// Fill in member variables of transcript.
			courseNumber = gradeFields[0];
			courseSection = gradeFields[1];
			courseName = gradeFields[2];
			letterGrade = gradeFields[3];
			courseCreditHours = gradeFields[4];
			courseTerm = gradeFields[5];
			
			course = new Course(courseNumber, courseName, courseCreditHours);
			uniqueCourses.add(course);
			grade = new Grade(letterGrade, courseSection, courseTerm, course);
			
			transcript.grades.add(grade);

			line = br.readLine(); 
		}

		return transcript;
	}
	
	static public Set<Course> getCourseList()
	{
		return uniqueCourses;
	}
	
	static public Course getCourseByName(String nameIn)
	{
		Course course = null;
		
		// Find the one with the requested name
		for(Course c : uniqueCourses)
		{
			if(c.getCourseName().equals(nameIn))
			{
				course = c;
				break;
			}
		}
		
		return course;
	}
	
	public List<Grade> getGrades()
	{
		return grades;
	}
}
