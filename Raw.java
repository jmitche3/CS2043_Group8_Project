import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Raw 
{
    private Registrar registrar;
    private ArrayList<ArrayList<Integer>> rawData;
    private Schema levelSchema;

    public Raw(Registrar registrarI)
    {
        this.registrar = registrarI;
        this.rawData = new ArrayList<ArrayList<Integer>>();
        this.calcRaw();
        this.levelSchema = new DLevelSchema();
    }

    public Raw(Registrar registrarI,Schema schema)
    {
        this.registrar = registrarI;
        this.rawData = new ArrayList<ArrayList<Integer>>();
        this.levelSchema = schema;
        this.calcRaw(levelSchema);
    }

    public ArrayList<ArrayList<Integer>> getRawData()
    {
        return rawData;
    }

    private void calcRaw() //calculates raw without a schema
    {
        this.rawData = new ArrayList<ArrayList<Integer>>();
        Set<Course> uniqueCourses = Transcript.getCourseList();
        List<Transcript> transcripts = registrar.getTranscripts();
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
                List<Grade> gradeData = transcript.getGrades();
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
    }

    private void calcRaw(Schema schema) //calculates raw with schema
    {
        this.rawData = new ArrayList<ArrayList<Integer>>();
        List<Transcript> transcripts = registrar.getTranscripts();
        Set<Course> uniqueCourses = Transcript.getCourseList();
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
    }

    public void writeRawFile()
    {
        Set<Course> uniqueCourses = Transcript.getCourseList();
        writeRaw(uniqueCourses, rawData, levelSchema.getLevelNames(), registrar.getCurrentPath() +"\\Raw.csv");
    }

    public void setRegistrar(Registrar i)
    {
        this.registrar = i;
        this.calcRaw();
    }
}