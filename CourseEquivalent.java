import java.util.*;
class CourseEquivalent{
	private String primary;
	//private ArrayList<Course> courses;
	private ArrayList<String> courses;
	
	public CourseEquivalent(String nameIn){
		primary=nameIn;
		//courses=new ArrayList<Course>();
		courses=new ArrayList<String>();
	}
	
	public void addCourse(String courseIn){
		//Course temp=Registrar.getCourse(courseIn);
		//courses.add(temp);
		courses.add(courseIn);
	}
	
	public String toString(){
		String temp=primary+":";
		for(String tCourse:courses){
			temp+=" "+tCourse;
		}
		return temp;
	}
}