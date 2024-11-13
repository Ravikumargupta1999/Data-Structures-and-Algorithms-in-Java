package Sumit_Malik_Level_2;

// https://www.youtube.com/watch?v=pW5fvwnZ1TA&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=14
public class Video_14_Reduce_A_Number_To_1_In_Minimum_Steps {
    // https://practice.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-condition0618/1#
    public int minSteps(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            int temp;
            if (i % 2 == 0 && i % 3 == 0) {
                temp = Math.min(dp[i / 2], dp[i / 3]);
            } else if (i % 2 == 0) {
                temp = dp[i / 2];
            } else if (i % 3 == 0) {
                temp = dp[i / 3];
            } else {
                temp = dp[i - 1];
            }
            dp[i] = Math.min(temp, dp[i - 1]) + 1;
        }
        return dp[N];
    }

    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/submissions/
    public int numberOfSteps(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        return dp[N];
    }

    public int numberOfSteps1(int num) {
        return totalSteps(num, 0);
    }

    public static int totalSteps(int n, int steps) {
        if (n == 0)
            return steps;
//        System.out.println(n+"  "+steps);
        if (n % 2 == 0)
            return totalSteps(n / 2, steps + 1);
        return totalSteps(n - 1, steps + 1);

    }

    // https://www.geeksforgeeks.org/reduce-a-number-to-1-by-performing-given-operations/
    // https://www.geeksforgeeks.org/reduce-a-number-to-1-by-performing-given-operations-set-2/
    static int countWays1(int n) {
        int res = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n == 3) {
                n = n - 1;
            } else if ((n & 3) == 1) {
                n = n - 1;
            } else if ((n & 3) == 3) {
                n = n + 1;
            }
            res++;
        }
        return res;
    }

    // https://www.codingninjas.com/codestudio/problems/min-steps-to-one-using-dp_920548?leftPanelTab=1
    public static int countStepsToOne(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                min = Math.min(min, 1 + dp[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, 1 + dp[i / 3]);
            }
            min = Math.min(min, 1+dp[i - 1]);
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays1(4));
    }
}
