import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
// https://www.youtube.com/watch?v=823Grn4_dCQ&t=1217s

public class D_Dynamic_Programming_423_Shortest_Common_Subsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        int value = shortestCommonSubsequences(s1, s2);
        System.out.println(value);
    }

    public static int shortestCommonSubsequences(String s1, String s2) {
        return s1.length() + s2.length() - LongestCommonSubsequences(s1, s2);
    }

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
}
