import java.io.*;
import java.util.*;
//import org.apache.poi.ss.usermodel;

public class IODriver{
	
	/*public static Transcript readTranscript(String target){
		FileReader in;
		Transcript student=new Transcript();
		
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			sc.useDelimiter("\\s{2,}|\\n|\\r");
			
			student.setID(sc.nextInt());
			student.setProgram(sc.next());
			while(sc.hasNext()){
				//sc.next();
				String courseIn=sc.next();
				String sectionIn=sc.next();
				String titleIn=sc.next();
				String letGradeIn=sc.next();
				//System.out.println(letGradeIn);
				double valueIn=sc.nextDouble();
				String termIn=sc.next();
				Course tempCourse=readerAddCourse(courseIn,titleIn,valueIn);
				Grade temp= new Grade(courseIn,sectionIn,titleIn,letGradeIn,valueIn,termIn);
				
				student.addGrade(temp);
			}
		}catch(IOException e){
			
		}
		return student;
	}
	
	public static Course readerAddCourse(String courseIn,String titleIn,double valueIn){
		for(Course c:getCourseList()){
			if(c.getCourseName().equals(courseIn)){
				return c;
			}
		}
	}*/
	
	public static ArrayList<CourseArea> readArea(String target){
		FileReader in;
		
		ArrayList<CourseArea> tempList=new ArrayList<CourseArea>();
		
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			String line=sc.nextLine();
			Scanner sc2=new Scanner(line);
			sc2.useDelimiter(",");
			byte i=0;
			
			while(sc2.hasNext()){
				CourseArea temp=new CourseArea(sc2.next());
				tempList.add(temp);
				i++;
			}
			int j=i;
			i=0;
			sc.useDelimiter(",|\\n|\\r");
			String courseIn;
			while(true){
				courseIn=sc.next();
				//System.out.println(courseIn);
				if(!courseIn.equals("")){
					tempList.get(i).addCourse(courseIn);
				}
				i++;
				if(i>=j){
					i=0;
					if(sc.hasNext()){
						sc.next();
					}else
						break;
				}
			}
		}
		catch(IOException e){
			//HANDLE
		}
		return tempList;
	}
	
	public static ArrayList<CourseEquivalent> readEquivs(String target){
		FileReader in;
		
		ArrayList<CourseEquivalent> tempList=new ArrayList<CourseEquivalent>();
		
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			String line=sc.nextLine();
			Scanner sc2=new Scanner(line);
			sc2.useDelimiter(",");
			byte i=0;
			
			while(sc2.hasNext()){
				CourseEquivalent temp=new CourseEquivalent(sc2.next());
				tempList.add(temp);
				i++;
			}
			int j=i;
			i=0;
			sc.useDelimiter(",|\\n|\\r");
			String courseIn;
			while(sc.hasNext()){
				courseIn=sc.next();
				//System.out.print(i);
				//System.out.println(": "+courseIn);
				if(!courseIn.equals("")&&!courseIn.equals("x")){
					tempList.get(i).addCourse(courseIn);
				}
				i++;
				if(i>=j){
					i=0;
					if(sc.hasNext()){
						sc.next();
					}else
						break;
				}
			}
		}
		catch(IOException e){
			//HANDLE
		}
		return tempList;
	}
	/*
	public static GradeSchema readGSchema(String target){
		FileReader in;
		GradeSchema temp=new GradeSchema();
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			sc.useDelimiter(",|\\n|\\r");
			while(sc.hasNext()){
				temp.add(sc.next(),sc.next(),sc.next());
				if(sc.hasNext()){
					sc.next(); //clear blank line ends
				}
			}
		}catch(IOException e){
			//HANDLE
		}
		return temp;
	}*
	
	public static RankSchema readRSchema(String target){
		FileReader in;
		RankSchema temp=new RankSchema();
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			sc.useDelimiter(",|\\n|\\r");
			while(sc.hasNext()){
				temp.add(sc.next(),sc.next(),sc.next());
				if(sc.hasNext()){
					sc.next(); //clear blank line ends
				}
			}
		}catch(IOException e){
			//HANDLE
		}
		return temp;
	}
	
	/*public static ArrayList<Course> desiredCourses(String target){
		FileReader in;
		
		//ArrayList<Course> tempList=new ArrayList<Course>();
		
		try{
			in=new FileReader(target);
			Scanner sc=new Scanner(in);
			sc.useDelimiter(",|\\n|\\r");
			while(sc.hasNext()){
				//tempList.add(Registrar.getCourse(sc.next()));	//Registrar's getCourse(String) method should search for an existing course with the target name, and create a new one if none is found.
			}
		}catch(IOException e){
			//HANDLE
		}
		return tempList;
	}*/
	
	/*public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String target=sc.nextLine();
		//ArrayList<CourseEquivalent> student=readEquivs(target);
		Transcript test=readTranscript(target);
		//System.out.print(student);
		//for(CourseEquivalent area:student){
			System.out.println(test);
		//}
	}*/
	
	/*public static void writeTranscript(Transcript student, String target){
		PrintWriter out;
		
		try{
			File output=new File(target);
			out=new PrintWriter(output);
			
			out.println(""+student.getID()+"  "+student.getProgram());
			ArrayList<Grade> grades=student.getGrades();
			for(Grade g : grades){
				out.println(g);
			}
			out.close();
		}catch(IOException e){
			System.err.print(e);
		}
	}*/
	
	/*public static void writeTranscriptExcel(Transcript student, String target){
		
	}*/
	
	public static void writeRaw(Set<Course> courses, ArrayList<ArrayList<Integer>> counts, ArrayList<String> scheme,String target){
		PrintWriter out;
		
		try{
			File output=new File(target);
			out=new PrintWriter(output);
			
			out.print("Course");
			for(String title : scheme){
				out.print(","+title);
			}
			for(int i=0;i<courses.size();i++){
				out.print("\n"+((Course)courses.toArray()[i]).getCourseCode());
				for(int j:counts.get(i)){
					out.print(","+j);
				}
			}
			out.close();
		}catch(IOException e){
			
		}
	}
	public static void writeGlobal(int[] data,ArrayList<String> names,String target){
		PrintWriter out;
		String line = "";
		
		try{
			File output=new File(target);
			out=new PrintWriter(output);
			
			for(String title : names){
				if(!line.isEmpty())
					line += ",";
				line += title;
			}
			out.print(line);
			out.print("\n");
			
			line = "";
			for(int i : data){
				if(!line.isEmpty())
					line += ",";
				line += i;
			}
			out.print(line);
			out.print("\n");
			out.close();
		}catch(IOException e){
			
		}
		
	}
	
	public static void writeArea(ArrayList<ArrayList<Integer>> data, String[] areas, String[] levels, String target){
		PrintWriter out;
		
		try{
			File output=new File(target);
			out=new PrintWriter(output);
			
			out.print("Area");
			for(String title : levels){
				out.print(","+title);
			}
			for(int i=0;i<areas.length;i++){
				out.print("\n"+areas[i]);
				for(int j : data.get(i)){
					out.print(","+j);
				}
			}
			out.close();
		}catch(IOException e){
			
		}
	}

	public static void writeMasterList(String target){
		PrintWriter out;
		
		try{
			File output=new File(target + "\\MasterList.txt");
			out=new PrintWriter(output);
			Set<Course> data = Transcript.getCourseList();
			out.print("MasterList:");
			for(Course course:data)
			{
				out.print("\n" +course.getCourseName());
			}

			out.close();

		}catch(IOException e){
			
		}
	}
	
}