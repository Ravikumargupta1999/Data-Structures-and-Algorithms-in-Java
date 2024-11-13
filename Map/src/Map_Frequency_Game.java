import java.util.HashMap;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/frequency-game/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map#
public class Map_Frequency_Game {
    public static int LargButMinFreq(int arr[], int n)
    {
        int value = Integer.MIN_VALUE;
        int count = n+1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if( entry.getKey()>value && entry.getValue()<=count  )
            {
                value = entry.getKey();
                count = entry.getValue();
            }
        }
        return value;


    }
    public static void main(String[] args) {

    }
}
