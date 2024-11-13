public class String_77_Count_Palindromic_Subsequences {
    // https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
    // https://www.youtube.com/watch?v=YHSjvswCXC8
    public static long countPalindrome(String str) {
        long mod = 1000000007;
        long[][] dp = new long[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < str.length(); i++, j++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = ch1 == ch2 ? 3 : 2;
                } else {
                    if (ch1 == ch2)
                        dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                    else {
                        long a = (dp[i][j - 1] + dp[i + 1][j]) % mod;
                        long b = dp[i + 1][j - 1];
                        dp[i][j] = ((a - b) % mod + mod) % mod;
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }

    // https://leetcode.com/problems/count-different-palindromic-subsequences/
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        long[][] dp = new long[n][n];
        long mod = 1_000_000_007;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 2 * dp[i + 1][j - 1];
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && chars[left] != chars[i]) {
                        left++;
                    }
                    while (left <= right && chars[right] != chars[i]) {
                        right--;
                    }
                    if (left > right) {
                        dp[i][j] += 2;
                    } else if (left == right) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[left + 1][right - 1];
                    }
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[0][n - 1];
    }
}

