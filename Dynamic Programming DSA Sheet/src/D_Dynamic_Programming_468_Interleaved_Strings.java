// https://www.youtube.com/watch?v=79g3LJoQk_U&t=5s
// https://practice.geeksforgeeks.org/problems/interleaved-strings/1#
// https://leetcode.com/problems/interleaving-string/
public class D_Dynamic_Programming_468_Interleaved_Strings {
    // wrong solution
    public boolean isInterLeaveString(String a, String b, String c) {
        if (a.length() + b.length() != c.length())
            return false;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == c.charAt(k)) {
                i++;
                k++;
            } else if (b.charAt(j) == c.charAt(k)) {
                j++;
                k++;
            } else {
                return false;
            }
        }

        while (i < a.length()) {
            if (a.charAt(i) == c.charAt(k)) {
                i++;
                k++;
            } else {
                return false;
            }
        }

        while (j < b.length()) {
            if (b.charAt(j) == c.charAt(k)) {
                j++;
                k++;
            } else {
                return false;
            }
        }
        return true;
    }

    // Recursion
    public boolean isInterleave(String s1, String s2, String s3) {
        return s1.length() + s2.length() == s3.length() && isInterleave1(s1, s2, s3, 0, 0);
    }

    public boolean isInterleave1(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (isInterleave1(s1, s2, s3, i + 1, j))
                return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (isInterleave1(s1, s2, s3, i, j + 1))
                return true;
        }
        return false;
    }

    // Memoization
    public boolean isInterleave3(String s1, String s2, String s3) {
        return s1.length() + s2.length() == s3.length() && isInterleave3(s1, s2, s3, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean isInterleave3(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (dp[i][j] != null)
            return dp[i][j];
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            boolean val = isInterleave3(s1, s2, s3, i + 1, j, dp);
            dp[i][j] = val;
            if (val)
                return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            boolean val = isInterleave3(s1, s2, s3, i, j + 1, dp);
            dp[i][j] = val;
            if (val)
                return true;
        }
        dp[i][j] = false;
        return false;
    }

    // DP Approach
    public boolean isInterleave5(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) ? dp[i][j - 1] : false;
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) ? dp[i - 1][j] : false;
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
