import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/twice-counter4236/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map

public class Map_Twice_Counter {
    public int countWords(String arr[], int n)
    {

        int count = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        for (Map.Entry<String,Integer> entry : map.entrySet())
        {
            if( entry.getValue() == 2  )
            {
               count++;
            }
        }
        return count;
    }
}
