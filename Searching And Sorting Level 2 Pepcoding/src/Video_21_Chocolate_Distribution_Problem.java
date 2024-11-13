import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
public class Video_21_Chocolate_Distribution_Problem {
    public long findMinDiff(ArrayList<Long> a, long n, long m) {
        Collections.sort(a);
        long ans = Integer.MAX_VALUE;
        long j = 0;
        for (long i = m - 1; i < n; i++) {
            ans = Math.min(ans, a.get((int) i) - a.get((int)j++));
        }
        return ans;
    }
}
