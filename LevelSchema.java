import java.util.ArrayList;

public class LevelSchema 
{
	ArrayList<Level> schema = new ArrayList<Level>();
	
	public LevelSchema()
	{
	}
	
	public void addLevel(Level currentLevel)
	{
		schema.add(currentLevel);
	}
	
	public ArrayList<Level> getSchema()
	{
		return schema;
	}
	
	public void compareData()
	{
		
	}
}
