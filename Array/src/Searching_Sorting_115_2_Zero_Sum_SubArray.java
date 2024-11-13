import java.util.HashMap;
import java.util.Scanner;

public class Searching_Sorting_115_2_Zero_Sum_SubArray {
    // https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
    public static long findSubArray(long[] arr, int n) {

        HashMap<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int i = -1;

        map.put((long) 0, 1);

        long res = 0;

        while (i < arr.length - 1) {

            i++;

            sum = sum + arr[i];

            res = res + map.getOrDefault(sum, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return res;
    }

}
