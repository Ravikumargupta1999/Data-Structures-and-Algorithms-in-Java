import java.util.Arrays;
import java.util.Scanner;

public class Video_2_Climbing_Stair {

    public static int get_count_paths(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        int n1 = get_count_paths(n - 1);
        int n2 = get_count_paths(n - 5);
        int n3 = get_count_paths(n - 6);
        int count_paths = n1 + n2 + n3;
        return count_paths;
    }

    // https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1
    // Recursion
    int countWays(int n) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        int p1 = countWays(n - 1);
        int p2 = countWays(n - 2);
        return p1 + p2;
    }

//
    // Memoization
    int countWays1(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return countWaysDP(n, dp);
    }

    int countWaysDP(int n, int[] dp) {
        if (n == 0)
            return 1;
        else if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int p1 = countWays(n - 1);
        int p2 = countWays(n - 2);
        return dp[n] = p1 + p2;
    }

    // Tabulation
    int countWays3(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else
                dp[i] = (dp[i - 1] % mod + (dp[i - 2] % mod)) % mod;
        }
        return dp[n] % mod;
    }

    // Constant Space

    int countWays4(int n)
    {
        int mod = 1000000007;
        if (n == 1 || n == 2)
            return n;
        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int temp1 = first;
            int temp2 = second;

            second = ((first % mod) + (second % mod)) % mod;

            first = temp2;
        }
        return second;
    }


}
