import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1#
public class Video_6_Count_of_Zero_Sum_Subarray {
    public static long findSubArray(long[] arr, int n) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int i = -1;
        int count = 0;
        map.put(sum, 1);
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (map.containsKey(sum)) {
                count += (map.get(sum));
                map.put(sum, map.get(sum) + 1);
            } else
                map.put(sum, 1);
        }
        return count;

    }

    public static void main(String[] args) {

    }

}
