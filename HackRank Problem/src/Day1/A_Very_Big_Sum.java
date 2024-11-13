package Day1;

import java.util.List;

public class A_Very_Big_Sum {
    // https://www.hackerrank.com/challenges/a-very-big-sum/problem
    public static long aVeryBigSum(List<Long> ar) {
        long res = 0;
        for(long val : ar)
            res += val;
        return res;
    }
}
