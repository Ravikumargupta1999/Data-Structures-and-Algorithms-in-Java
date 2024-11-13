import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy_255_Maximum_sum_of_absolute_difference_of_an_array {
    // https://www.youtube.com/watch?v=ap9rcWAw8bM
    // https://www.geeksforgeeks.org/maximum-sum-absolute-difference-array/
    // https://www.codingninjas.com/codestudio/problems/maximum-sum-of-absolute-difference_1164175?leftPanelTab=1
    public static int maxAbsSum(int[] a, int n) {
        List<Integer> finalSequence = new ArrayList<>();

        Arrays.sort(a);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            finalSequence.add(a[l]);
            finalSequence.add(a[r]);
            l++;
            r--;
        }
        if (l == r) {
            finalSequence.add(a[r]);
        }
//         System.out.println(finalSequence);
        int MaximumSum = 0;
        for (int i = 0; i < n - 1; ++i) {
            MaximumSum = MaximumSum + Math.abs(finalSequence.get(i) - finalSequence.get(i + 1));
        }

        MaximumSum = MaximumSum + Math.abs(finalSequence.get(n - 1) - finalSequence.get(0));
        return MaximumSum;
    }
}
