import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
// https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
public class Searching_Sorting_115_4_Largest_Sum_SubArray {
// this gave wrong solution
    public static int lenOfLongSubarr (int[] arr, int N, int target) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
//                System.out.println("If " + i + "   " + (sum - target));
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            } else {
                if (!map.containsKey(sum))
                    map.put(sum, i);
            }
//            System.out.println(map);
        }

        return maxLen;
    }

    public static int largestSumSubArray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k)
                maxlen = i + 1;
            if (map.containsKey(sum) == false)
                map.put(sum, i);
            if (map.containsKey(sum - k))
                if (maxlen < i - map.get(sum - k))
                    maxlen = i - map.get(sum - k);
        }
        return maxlen;

    }


}
