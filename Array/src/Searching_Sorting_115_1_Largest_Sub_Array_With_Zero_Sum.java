import java.util.HashMap;

public class Searching_Sorting_115_1_Largest_Sub_Array_With_Zero_Sum {
    // https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1/

    int maxLen(int[] arr, int n) {
        // Your code here

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = -1;
        int sum = 0;

        map.put(sum, i);

        int length = 0;
        while (i < arr.length - 1) {

            i++;

            sum = sum + arr[i];

            if (map.containsKey(sum))
                length = Math.max(length, i - map.get(sum));
            else
                map.put(sum, i);

        }
        return length;
    }
}
