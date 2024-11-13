// https://practice.geeksforgeeks.org/problems/maximum-sum-problem2211/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=1&query=category[]Dynamic%20Programmingdifficulty[]0page1category[]Dynamic%20Programming#

public class Video_18_Maximum_Sum_Problem {
    public static int maxSum(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n <= 2)
            return n;
        for (int i = 2; i <= n; i++)

            dp[i] = Math.max((dp[i / 2] + dp[i / 3] + dp[i / 4]), i);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(maxSum(12));
    }
}
