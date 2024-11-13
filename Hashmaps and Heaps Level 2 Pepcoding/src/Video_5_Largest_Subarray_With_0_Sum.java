import java.util.HashMap;

public class Video_5_Largest_Subarray_With_0_Sum {
    // https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1/#
    int maxLen(int[] arr, int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int ans = 0;
        for (int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans,i-map.get(sum));
            }
            else
                map.put(sum,i);
        }
        return ans;
    }
}
