import java.util.HashMap;
import java.util.Map;

public class Pairs_With_Difference_K {
    static  int countPairsWithDiffK(int[] arr, int n, int k) {
        Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<n;i++)
       {
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       }
       int count =0;


       for(int i=0;i<n;i++)
       {
           int value = k + arr[i];
           boolean flag = false;
           if(map.containsKey(arr[i]))
           {
               flag = true;
               map.put(arr[i],map.get(arr[i])-1);
           }
           if(map.containsKey(value)) {
               System.out.println(arr[i]+"  "+value+"  "+map.get(value));
               count += (map.get(value));
           }
           if(map.containsKey(arr[i]) == false)
               map.put(arr[i], 0);

           else
               map.put(arr[i],map.get(arr[i])+1);



       }
       return count;
    }
    public static void main(String[] args) {
        int n = 5, k= 0;
        int[] arr = {5,5,5,5,5};
        System.out.println(countPairsWithDiffK(arr,n,k));

    }
}
