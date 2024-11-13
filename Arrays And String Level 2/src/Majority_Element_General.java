import java.util.HashMap;

public class Majority_Element_General {
    //https://practice.geeksforgeeks.org/problems/count-element-occurences/1
    //https://www.youtube.com/watch?v=ChK9pQDhIrk&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=7
    public int countOccurence(int[] arr, int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++)
        {
            if(map.containsKey(arr[i]) == true)
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        int count = 0;
        int value = n/k;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(arr[i]) ==true)
            {
                if(map.get(arr[i])>value)
                {
                    count++;
                    map.put(arr[i],0);
                }
            }
        }
        return count;
    }
}
