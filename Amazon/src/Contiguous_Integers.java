import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/check-if-array-contains-contiguous-integers-with-duplicates-allowed2046/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon#

public class Contiguous_Integers {
    public static boolean areElementsContiguous(int arr[], int n) {
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int i=0;i<n;i++)
            set.put(arr[i],set.getOrDefault(arr[i],0)+1);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(arr[i] <min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        for(int i= min ;i <= max;i++)
        {
            if(set.containsKey(i) == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,6,4,4,6,6};
        System.out.println(areElementsContiguous(arr,arr.length));
    }
}
