import java.util.ArrayList;
import java.util.Arrays;

public class Greedy_256_Swap_and_Maximize {
    // previous sum
    // https://practice.geeksforgeeks.org/problems/swap-and-maximize5859/1
    long maxSum(long[] arr, int n) {
        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        ArrayList<Long> list = new ArrayList<>();
        while (l < r) {
            list.add(arr[l++]);
            list.add(arr[r--]);
        }
        if (l == r)
            list.add(arr[l]);

        long maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum += Math.abs(list.get(i) - list.get(i + 1));
        }
        maxSum += Math.abs(list.get(n - 1) - list.get(0));
        return maxSum;
    }
}
