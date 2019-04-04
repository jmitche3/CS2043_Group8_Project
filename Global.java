import java.util.ArrayList;

public class Global
{
    private Int[] globalData;
    private ArrayList<ArrayList<Integer>> data;

    public Global(ArrayList<ArrayList<Integer>> data)
    {
        this.data = data;
        int length = data.get(0).size();
        this.globalData = new Int[length];
    }

    public void clacGlobal()
    {
        for(ArrayList<Integer> dataArray:data)
        {
            for(int i = 0; i < dataArray.size(); i++)
            {
                globalData[i] += dataArray.get(i);
            }
        }
    }

    public void printGlobal()
    {}
}