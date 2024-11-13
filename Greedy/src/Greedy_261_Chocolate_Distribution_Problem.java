import java.util.ArrayList;
import java.util.Collections;

public class Greedy_261_Chocolate_Distribution_Problem {
    // https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
    public long findMinDiff(ArrayList<Long> al, long n, long m) {
        Collections.sort(al);
        long min = Integer.MAX_VALUE;
        for (long i = m - 1; i < n; i++) {
            min = Math.min(min, al.get((int) (i)) - al.get((int) (i - (m - 1))));
        }
        return min;
    }
}
