import java.util.ArrayList;

public class DLevelSchema implements Schema
{
    private final ArrayList<String> Fails;
    private final ArrayList<String> Marginal;
    private final ArrayList<String> Meets;
    private final ArrayList<String> Exceeds;
    private final ArrayList<String> LevelNames;

    public DLevelSchema() 
    {
        this.Fails = new ArrayList<String>();
        this.Marginal = new ArrayList<String>();
        this.Meets = new ArrayList<String>();
        this.Exceeds = new ArrayList<String>();
        this.LevelNames = new ArrayList<String>();
        this.Fails.add("F");
        this.Fails.add("D");
        this.Marginal.add("C");
        this.Marginal.add("C+");
        this.Meets.add("B-");
        this.Meets.add("B");
        this.Meets.add("B+");
        this.Exceeds.add("A-");
        this.Exceeds.add("A");
        this.Exceeds.add("A+");
        this.LevelNames.add("Fails");
        this.LevelNames.add("Meets");
        this.LevelNames.add("Marginal");
        this.LevelNames.add("Exceeds");
    }

    public int compareData(String input)
    {
        if (Fails.contains(input)) 
        {
            return 0;
        } 
        else if (Meets.contains(input))
        {
            return 1;
        }
        else if (Marginal.contains(input))
        {
            return 2;
        }
        else if (Exceeds.contains(input))
        {
            return 3;
        } else {
            return -1; //Grade isnt in schema, meaning its not a letter grade.
        }
    }

    public String getBinName(int binNumber)
    {
    	return this.LevelNames.get(binNumber);
    }
    
    public ArrayList<String> getLevelNames()
    {
        return LevelNames;
    }
} 