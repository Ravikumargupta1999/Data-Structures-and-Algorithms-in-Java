//https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
public class String_96_Min_Del_And_Insert {
    public static int LongestCommonSubsequences(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2)
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static int minDeletionAndInsertion(String str1, String str2) {
        int l = str1.length() - LongestCommonSubsequences(str1, str2);
        int m = str2.length() - LongestCommonSubsequences(str1, str2);
        return l + m;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionAndInsertion("heap", "pea"));
    }
}
