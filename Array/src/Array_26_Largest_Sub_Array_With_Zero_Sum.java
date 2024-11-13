import java.util.HashMap;

public class Array_26_Largest_Sub_Array_With_Zero_Sum {
    // https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
    public static int subArrayExists(int[] arr) {
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
        return maxLen;
    }
}
