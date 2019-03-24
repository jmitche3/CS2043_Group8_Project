package Group_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Registrar {
	private String currentPath;
	private ArrayList<Transcript> transcriptList = new ArrayList<Transcript>();
	private File rankSchemaFile = new File(currentPath + "RankSchema.csv");
	private File levelSchemaFile = new File(currentPath + "LevelSchema.csv");
	private File desiredCoursesFile = new File(currentPath + "DesiredCourses.csv");
	private File areasFile = new File(currentPath + "Areas.csv");
	private File equivalentsFile = new File(currentPath + "Equivalents.csv");

	public Registrar(String pathIn) {
		currentPath = pathIn;
	}

	public void loadTranscripts(String fileName) {
		File folder = new File(currentPath);
		File[] listOfFiles = folder.listFiles();
		Pattern p = Pattern.compile("\\d{4}.*?\\.txt");
		Transcript currentTranscript = null;

		for (File file : listOfFiles) {
			if (p.matcher(file.getName()).matches()) {
				currentTranscript = loadTranscript(file);
				if (currentTranscript != null) {
					transcriptList.add(currentTranscript);
					System.out.println(file.getName());
				}
			}
		}
	}

	public Transcript loadTranscript(File file) 
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

	public void loadDesiredCourse() {

	}

	public void loadEquivalents() {

	}

	public void loadCourseArea() {

	}

	public void loadLevelSchema() {

	}

	public void loadRankSchema() {

	}

	public void getEquivalents() {

	}

	public int getStudentCount() {
		return transcriptList.size();
	}

	public int getStudentsPerCourse() {
		return 0;
	}

	public int getStudentsPerLocation() {
		return 0;
	}

	public int getStudentsPerYear() {
		return 0;
	}

	public int getTranscripts() {
		return 0;
	}

}
