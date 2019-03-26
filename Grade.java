class Grade{
	private String letGrade;
	private double gradeVal;
	private String term;
	private String section;
	//private Course course;
	
	public Grade(String courseIn, String sectionIn,String titleIn,String letGradeIn,double valueIn,String termIn){
		letGrade=letGradeIn;
		section=sectionIn;
		term=termIn;
		//course=new Course(courseIn,titleIn,valueIn);
		//gradeVal=Registrar.calcGradeVal(letGrade);
	}
	
	public String toString(){
		String tS="";
		//tS+=course.toString();
		tS+=","+section+","+letGrade+","+term;
		return tS;
	}
}