import java.util.HashMap;
import java.util.Map;
// https://practice.geeksforgeeks.org/problems/pair-sum-existence-revisited/1/?category[]=Map&category[]=Map&page=1&query=category[]Mappage1category[]Map#
public class Map_Pair_Sum_Existence_Revisited {
    public static int sumExists(int arr[], int n, int sum)
    {

        int count = 0;
        int coun = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        for (int i=0;i<n;i++)
        {
            int temp = sum - arr[i];
            if(map.get(arr[i]) == 1)
                map.remove(arr[i]);
            else if(map.get(arr[i])>1)
            {
                coun = map.get(arr[i]);
                map.put(arr[i],coun-1);
            }
            if(map.containsKey(temp))
            {
                System.out.println(arr[i]+"  "+temp);
                count = 1;
                break;
            }
            if(map.containsKey(arr[i])== false)
                map.put(arr[i],1);
            else
            {
                coun = map.get(arr[i]);
                map.put(arr[i],coun+1);
            }
        }
       if(count == 1)
           return 1;
       else
           return 0;

    }

    public static void main(String[] args) {
        int n = 16;
        int[] arr= {47, 68,83, 13, 33, 87, 70, 9, 90, 51, 18, 10, 46, 2, 5, 40};
        int sum = 4;
        System.out.println(sumExists(arr,n,sum));

    }
}
