package InterviewQuestion;

import java.sql.Array;
import java.time.Year;
import java.util.Arrays;

public class Video_32_Faithful_Numbers {
    static Long nthFaithfulNum(int n) {
        Long[] dp = new Long[n + 1];
        dp[1] = (long) 1;
        int count = 1;
        int pow = 1;
        long val = dp[1];
        for (int i = 2; i <= n; i++) {

            if (i == (int) Math.pow(2, pow)) {
                dp[i] = (long) Math.pow(7, pow);
                pow++;
                val = dp[i];
                count = 1;
            } else {
                dp[i] = val + dp[count++];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(nthFaithfulNum(12));
    }
}
