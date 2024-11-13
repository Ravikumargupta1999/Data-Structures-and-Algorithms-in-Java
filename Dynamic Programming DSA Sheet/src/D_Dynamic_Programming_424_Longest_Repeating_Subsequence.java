public class D_Dynamic_Programming_424_Longest_Repeating_Subsequence {
    // https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
    // https://www.youtube.com/watch?v=oL7GCrcdaJI&t=815s
    public static int LongestRepeatedSubsequences(String s1) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp.length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = 0;
                } else if (j == dp.length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s1.charAt(j) && i != j)
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        int length = dp[0][0];


        char[] value = new char[length];
        int len = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s1.length()) {
            if (s1.charAt(i) == s1.charAt(j) && i != j) {
                value[len] = s1.charAt(i);
                i++;
                j++;
                len++;
            } else if (dp[i + 1][j] > dp[i][j + 1])
                i++;
            else
                j++;
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(LongestRepeatedSubsequences("xax"));
    }
}
