

public class String_90_Minimum_Insertion_To_Make_String_Palindrome {
    // https://www.youtube.com/watch?v=AEcRW4ylm_c
    // https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    // https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/
    // https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1/
    public static int minCount(String str) {
        return str.length() - longestPalindrome(str);
    }
    public static int longestPalindrome(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    dp[i][j] = ch1 == ch2 ? 2 : 1;
                } else {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if (ch1 == ch2) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCount("geeks"));
    }
}
