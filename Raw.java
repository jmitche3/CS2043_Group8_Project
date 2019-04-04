import java.util.ArrayList;
import java.util.Set;

public class Raw 
{
    private Registrar registrar;
    private ArrayList<ArrayList> rawData;
    private Schema levelSchema;

    public Raw(Registrar registrarI)
    {
        this.registrar = registrarI;
        this.rawData = new ArrayList<ArrayList<Integer>>();
        this.calcRaw();
    }

    public Raw(Registrar registrarI,Schema schema)
    {
        this.registrar = registrarI;
        this.rawData = new ArrayList<ArrayList<Integer>>();
        this.levelSchema = schema;
        this.calcRaw(levelSchema);
    }

    public ArrayList<ArrayList> getRawData()
    {
        return rawData;
    }

    //I made the calcRaw without a given schema


    private void calcRaw()
    {
        this.rawData = new ArrayList<ArrayList<Integer>>();
        Set<Course> uniqueCourses = registrar.getTranscripts().get(0).getCourseList();
        ArrayList<Transcript> transcripts;
        DLevelSchema levelSchema = new DLevelSchema();
        for(Course course:uniqueCourses)
        {
            ArrayList<Integer> courseLevels = new ArrayList<Integer>();
            courseLevels.add(0);
            courseLevels.add(0);
            courseLevels.add(0);
            courseLevels.add(0);
            for(Transcript transcript:transcripts)
            {
                ArrayList<Grade> gradeData = transcript.getGrades();
                for (Grade grade:gradeData)
                {
                    if ((grade.getCourse()).getCourseName().equalsIgnoreCase(course.getCourseName()))
                    {
                        int index = levelSchema.compareData(grade.getLetterGrade());
                        if(index != -1){
                            int increment = courseLevels.get(index);
                            increment++;
                            courseLevels.set(index, increment);
                        }
                    }
                }
            }
            rawData.add(courseLevels);
        }
        writeRaw(uniqueCourses, rawData, levelSchema.getLevelNames, registrar.getFilePath() +"\\Raw.csv");
    }
7
    private void calcRaw(Schema schema)
    {
        this.rawData = new ArrayList<ArrayList<Integer>>();
        ArrayList<Transcript> transcripts = registrar.getTranscripts();
        Set<Course> uniqueCourses = registrar.getTranscripts().get(0).getCourseList();
        for(Course course:uniqueCourses)
        {
            ArrayList<Integer> courseLevels = new ArrayList<Integer>();
            courseLevels.add(0);
            courseLevels.add(0);
            courseLevels.add(0);
            courseLevels.add(0);
            for(Transcript transcript:transcripts)
            {
                List<Grade> gradeData = transcript.getGrades();
                for (Grade grade:gradeData)
                {
                    if ((grade.getCourse()).getCourseName().equalsIgnoreCase(course.getCourseName()))
                    {
                        int index = schema.compareData(grade.getLetterGrade());
                        int increment = courseLevels.get(index);
                        increment++;
                        courseLevels.set(index, increment);
                    }
                }
            }
            rawData.add(courseLevels);
        }
        writeRaw(uniqueCourses, rawData, schema.getLevelNames, registrar.getFilePath() +"\\Raw.csv");
    }

    public void setRegistrar(Registrar i)
    {
        this.registrar = i;
        this.calcRaw();
    }
}