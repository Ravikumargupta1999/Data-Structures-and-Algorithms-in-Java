// https://practice.geeksforgeeks.org/problems/k-palindrome/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=1&query=category[]Dynamic%20Programmingdifficulty[]0page1category[]Dynamic%20Programming
//https://practice.geeksforgeeks.org/problems/find-if-string-is-k-palindrome-or-not1923/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=2&query=category[]Dynamic%20Programmingdifficulty[]0page2category[]Dynamic%20Programming

public class Video_22_K_Palindrome {

    boolean is_k_palin(String str, int k) {
        if (str.length() - longestPalindrom(str) <= k)
            return true;
        return false;
    }

    public static int longestPalindrom(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }
}
