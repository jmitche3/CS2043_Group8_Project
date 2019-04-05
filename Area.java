import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Area 
{
	private Registrar registrar;
	
	public Area(Registrar registrar)
	{
		this.registrar = registrar;
	}
	
    public void writeAreaFile()
    {
    	Map<Course, List<Double>> gradesPerCourse = new HashMap<Course, List<Double>>();
    	
    	// Gather up all of the marks per course
    	for(Transcript transcript : registrar.getTranscripts())
    	{
    		for(Grade grade : transcript.getGrades())
    		{
    			if(!gradesPerCourse.containsKey(grade.getCourse()))
    				gradesPerCourse.put(grade.getCourse(), new ArrayList<Double>());
    			
    			gradesPerCourse.get(grade.getCourse()).add(grade.calculateGradePoint());
    		}
    	}

    	// Put all of the letter grades for each course into their corresponding area
    	Map<CourseArea, List<String>> avgPerArea = new HashMap<CourseArea, List<String>>();

    	for(Course course : gradesPerCourse.keySet())
    	{
    		CourseArea courseArea = registrar.getCourseAreaForCourse(course);
    		
    		if(courseArea == null)
    			System.out.println("Area null for course " + course.getCourseCode());
    		if(!avgPerArea.containsKey(courseArea))
    			avgPerArea.put(courseArea, new ArrayList<String>());
    		
    		double courseSum = 0.0;
    		
    		// Compute the average for this course
    		for(double d : gradesPerCourse.get(course))
    			courseSum += d/course.getCourseCredit();
    		
    		// The dist is based on letter grade, convert our avg to a letter
    		String letterGrade = convertAvgToLetter(courseSum/(double)gradesPerCourse.get(course).size());

    		avgPerArea.get(courseArea).add(letterGrade);
    	}

    	// Bin the letter grades per area according to the schema
    	Schema schema = new DLevelSchema();
    	Map<CourseArea, Map<String, Integer>> binToCountDistribution = binData(avgPerArea, schema);
    	String[] areas = new String[binToCountDistribution.size()];
    	int index = 0;
    	ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
    	
    	// Write the distribution to a file. The IO was written by someone else, so we need to
    	// do a bit of creative data work here to get it to fit.
    	
    	for(CourseArea courseArea : binToCountDistribution.keySet())
    	{
    		Map<String, Integer> areaDist = binToCountDistribution.get(courseArea);
    		ArrayList<Integer> distValues = new ArrayList<Integer>();
    		
    		areas[index++] = courseArea.getName();
    		
    		// Add them to a list using the level names in order 
    		// as they come out of the schema by index.
    		for(String levelName : schema.getLevelNames())
    			distValues.add(areaDist.get(levelName));
    		
    		data.add(distValues);
    	}

    	// Write it out.
    	String[] levelNames = new String[schema.getLevelNames().size()];
    	schema.getLevelNames().toArray(levelNames);
    	
    	IODriver.writeArea(data, areas, levelNames, registrar.getCurrentPath() +"/Area.csv");
    	System.out.println("Area.csv written to disk");
    }
    
    private Map<CourseArea, Map<String, Integer>> binData(Map<CourseArea, List<String>> avgPerArea, Schema schema)
    {
    	Map<CourseArea, Map<String, Integer>> distributions = new HashMap<CourseArea, Map<String, Integer>>();
    	
    	// For each course area, we have to look at each letter grade, convert
    	// it to a bin and add one to the appropriate bin counter
    	for(CourseArea courseArea : avgPerArea.keySet())
    	{
    		// Make a new dist for each area
        	Map<String, Integer> dist = new HashMap<String, Integer>();
        	List<String> letterGrades = avgPerArea.get(courseArea);

        	// Starting each bin at zero
        	for(String levelName : schema.getLevelNames())
        		dist.put(levelName, new Integer(0));
        	
        	for(String letterGrade : letterGrades)
        	{
        		// Get the current count for the level
        		String level = schema.getBinName(schema.compareData(letterGrade));
        		int count = dist.get(level);

        		// Increment it and put it back
        		dist.put(level, new Integer(count+1));
        	}
        	
        	// Add the course area dist to the returned distributions
        	distributions.put(courseArea, dist);
    	}
    	
    	return distributions;
    }
    
    private String convertAvgToLetter(double avg)
    {
    	if(avg == 4.3)
    		return "A+";
    	else if(avg >= 4.0)
    		return "A";
    	else if(avg >= 3.7)
    		return "A-";
    	else if(avg >= 3.3)
    		return "B+";
    	else if(avg >= 3.0)
    		return "B";
    	else if(avg >= 2.7)
    		return "B-";
    	else if(avg >= 2.3)
    		return "C+";
    	else if(avg >= 2.0)
    		return "C";
    	else if(avg >= 1.0)
    		return "D";

    	return "F";
    }
}
