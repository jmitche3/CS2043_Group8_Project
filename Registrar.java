import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Registrar 
{
	private String currentPath;
	private ArrayList<Transcript> transcriptList = new ArrayList<Transcript>();
	private File levelSchemaFile = null;
	private File areasFile = null;
	private List<CourseArea> courseAreas = null;
	
	public Registrar(String pathIn) 
	{
		currentPath = pathIn;
		levelSchemaFile = new File(currentPath + "/LevelSchema.csv");
		areasFile = new File(currentPath + "/Areas.csv");
	}

	public void loadTranscripts() 
	{
		File folder = new File(currentPath);
		File[] listOfFiles = folder.listFiles();
		Pattern p = Pattern.compile("\\d{4}.*?\\.txt");
		Transcript currentTranscript = null;

		for (File file : listOfFiles)
		{
			if (p.matcher(file.getName()).matches()) 
			{
				currentTranscript = loadTranscript(file);
				if (currentTranscript != null) 
				{
					transcriptList.add(currentTranscript);
				}
			}
		}
	}

	private Transcript loadTranscript(File file) 
	{
		Transcript currentTranscript = null;

		try (BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.US_ASCII)) 
		{
			currentTranscript = Transcript.createTranscript(br);
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
		return currentTranscript;
	}

	public void loadCourseAreas()
	{
		String[] courseAs;
		int areaNum= 0;
		ArrayList<CourseArea> areas = new ArrayList<CourseArea>();

		try (BufferedReader br = Files.newBufferedReader(areasFile.toPath(), StandardCharsets.US_ASCII)) 
		{
			String line = br.readLine(); 
			
			while (line != null) 
			{ 
				courseAs = line.split(",");
				
				// First line is the course areas
				if(areaNum == 0)
				{
					for(String areaName : courseAs)
					{
						areas.add(new CourseArea(areaName));
					}
					areaNum = courseAs.length;
				}
				else
				{
					for(int i = 0; i<courseAs.length; i++)
					{
						if(!courseAs[i].isEmpty())
						{
							areas.get(i).addCourse(courseAs[i]);
						}
					}
				}

				line = br.readLine(); 
			}

			courseAreas = new ArrayList<CourseArea>();
			for(int i=0; i<areas.size(); ++i)
				courseAreas.add(areas.get(i));
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}

	public void loadLevelSchema() 
	{
		String[] scheme;
		String levelName;
		String[] letters;
		Level currentLevel;
		LevelSchema schema = new LevelSchema();
		
		try (BufferedReader br = Files.newBufferedReader(levelSchemaFile.toPath(), StandardCharsets.US_ASCII)) 
		{
			String line = br.readLine(); 

			while (line != null) 
			{ 
				scheme = line.split(","); 
				
				levelName = scheme[0];
				letters = new String[scheme.length - 1];
				System.arraycopy(scheme, 1, letters, 0, letters.length);
				currentLevel = new Level(levelName, letters);
				schema.addLevel(currentLevel);
				
				line = br.readLine(); 
			}
		}
		 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}

	public int getStudentCount() 
	{
		return transcriptList.size();
	}

	public List<Transcript> getTranscripts()
	{
		return transcriptList;
	}
	
	public String getCurrentPath()
	{
		return currentPath;
	}
	
	public List<CourseArea> getAreaList()
	{
		return courseAreas;
	}
	
	public CourseArea getCourseAreaForCourse(Course course)
	{
		for(CourseArea courseArea : courseAreas)
			if(courseArea.isCourseInArea(course))
				return courseArea;
		return null;
	}

}
