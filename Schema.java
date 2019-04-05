import java.util.ArrayList;

public interface Schema 
{

    public int compareData(String input); //Lets the user give data input to compare against the schema.
    public ArrayList<String> getLevelNames();
    public String getBinName(int binNumber);
}