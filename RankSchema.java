import java.util.*;
class RankSchema{
	private class LevelSchem{
		String name, min, max;
		public LevelSchem(String nameIn, String minIn, String maxIn){
			name=nameIn;
			min=minIn;
			max=maxIn;
		}
		public String toString(){
			return name+": "+min+" - "+max;
		}
	}
	private String name;
	//private ArrayList<Course> courses;
	private ArrayList<LevelSchem> courses;
	
	public RankSchema(){
		courses=new ArrayList<LevelSchem>();
	}
	
	public void add(String nameIn, String minIn, String maxIn){
		//Course temp=Registrar.getCourse(courseIn);
		//courses.add(temp);
		courses.add(new LevelSchem(nameIn,minIn,maxIn));
	}
	
	public String toString(){
		String temp="";
		for(LevelSchem tCourse:courses){
			temp+=tCourse+"\n";
		}
		return temp;
	}
}