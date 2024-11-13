public class Video_29_Minimum_Cost_To_Make_Two_Strings_Identical {
    // https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1#
    public static int findMinCost(String s1, String s2, int c1, int c2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length-1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = 0;
                else if (i == dp.length - 1)
                    dp[i][j] = 0;
                else if (j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        int lcs = dp[0][0];
        int s1r = s1.length() - lcs;
        int s2r = s2.length() - lcs;
        int cost = s1r * c1 + s2r * c2;
        return cost;
    }
    // https://leetcode.com/problems/delete-operation-for-two-strings/
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length-1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = 0;
                else if (i == dp.length - 1)
                    dp[i][j] = 0;
                else if (j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
        }
        int lcs = dp[0][0];
        int s1r = s1.length() - lcs;
        int s2r = s2.length() - lcs;
        return s1r + s2r;
    }

    public static void main(String[] args) {
        System.out.println(findMinCost("abcd", "acbd", 10, 20));
    }
}
