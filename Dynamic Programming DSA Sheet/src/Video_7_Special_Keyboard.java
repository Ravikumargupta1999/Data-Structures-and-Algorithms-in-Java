public class Video_7_Special_Keyboard {
    // https://practice.geeksforgeeks.org/problems/special-keyboard3018/1#
    // https://www.youtube.com/watch?v=c_y7H7qZJRU&t=6s
    static int optimalKeys(int n) {
        if (n <= 6)
            return n;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= 6; i++)
            dp[i] = i;
        for (int i = 7; i <= n; i++) {
            for (int j = i - 3; j >= 1; j--)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 44;
        System.out.println(optimalKeys(n));
    }
}
