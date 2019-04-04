import java.util.ArrayList;

public class GlobalDistribution
{
    private int[] globalData;
    private ArrayList<ArrayList<Integer>> data;
    private Schema schema;

    public GlobalDistribution(ArrayList<ArrayList<Integer>> data, Schema schema)
    {
        this.data = data;
        int length = data.get(0).size();
        this.globalData = new int[length];
        this.schema = schema;
        this.calcGlobal();
    }

    private void calcGlobal()
    {
        for(ArrayList<Integer> dataArray:data)
        {
            for(int i = 0; i < dataArray.size(); i++)
            {
                globalData[i] += dataArray.get(i);
            }
        }
    }

    public int getTotal()
    {
        int total = 0;
        for(int i=0; i<globalData.length; i++)
        {
            total += globalData[i];
        }
        return total;
    }

    public int[] getGlobalData()
    {
        return globalData;
    }

    public void writeGlobalFile(String filepath)
    {
        writeGlobal(globalData, schema.getLevelNames(), filepath +"\\global.csv");
    }
}