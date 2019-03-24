package Group_Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Transcript 
{
	ArrayList<Grade> grades = new ArrayList<Grade>();
	
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
			gradeFields = line.split(",");
			
			// Fill in member variables of transcript.
			courseNumber = gradeFields[0];
			courseSection = gradeFields[1];
			courseName = gradeFields[2];
			letterGrade = gradeFields[3];
			courseCreditHours = gradeFields[4];
			courseTerm = gradeFields[5];
			
			//course = new Course(courseNumber, courseSection, courseName, courseCreditHours);
			//grade = new Grade(letterGrade, courseSection, courseTerm, course);
			
			transcript.grades.add(grade);

			line = br.readLine(); 
		}

	return transcript;
}}
