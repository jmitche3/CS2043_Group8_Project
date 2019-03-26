import java.util.*;

class Transcript{
	private int studID;
	private byte progYear;
	private String program;
	private ArrayList<Grade> grades;
	
	public Transcript(){
		grades=new ArrayList<Grade>();
	}
	
	public void setID(int IDin){
		studID=IDin;
	}
	
	public void setProgram(String progIn){
		program=progIn;
	}
	
	public void addGrade(Grade gIn){
		grades.add(gIn);
	}
	
	public ArrayList<Grade> getGrades(){
		return grades;
	}
	
	public String toString(){
		String tS=""+studID+","+program+"\n";
		for(int i=0;i<grades.size();i++){
			tS+=""+grades.get(i);
			tS+="\n";
		}
		return tS;
	}
}