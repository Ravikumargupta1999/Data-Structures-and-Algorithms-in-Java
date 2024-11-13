
//https://practice.geeksforgeeks.org/problems/distinct-occurrences/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=1&query=category[]Dynamic%20Programmingdifficulty[]1page1category[]Dynamic%20Programming

public class Video_26_Distinct_Occurance {
    int subsequenceCount(String a, String b) {
        int mod = 1000000007;
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            dp[0][i] = 0;
        for (int i = 0; i <= m; ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = ((dp[i - 1][j - 1] % mod) + (dp[i - 1][j] % mod)) % mod;

                else
                    dp[i][j] = (dp[i - 1][j] % mod);
            }
        }

        return dp[m][n] % mod;
    }
}
