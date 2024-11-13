import java.util.HashMap;
// Done
public class Array_26_Sub_Array_With_0_sum {
    //    https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
    static boolean findsum(int arr[], int n) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(0, true);
        int sum = 0;
        for (int x : arr) {
            sum += x;
            if (map.containsKey(sum))
                return true;
            map.put(sum, true);
        }
        return false;
    }

    // https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1#
    public static boolean subArrayExists(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = 0;
        int i = -1;
        int sum = 0;
        map.put(sum, i);
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int len = i - map.get(sum);
                if (len > maxLen)
                    maxLen = len;
            }

        }
        if (maxLen != 0)
            return true;
        else
            return false;
    }

    // https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
    public static int countOfZeroSumSubArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = -1;
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (map.containsKey(sum)) {
                System.out.println("Sub Array found at index : " + (map.get(sum) + 1) + " to  " + i);
                count += map.get(sum);
                map.put(sum, 1 + map.get(sum));
            } else {
                map.put(sum, 1);
            }

        }
        return count;
    }
}
