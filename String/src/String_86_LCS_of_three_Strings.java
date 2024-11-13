import java.util.Arrays;

public class String_86_LCS_of_three_Strings {
    // Solution 1
    int LCSof31(String X, String Y, String Z, int n1, int n2, int n3) {
        int[][][] L = new int[X.length() + 1][Y.length() + 1][Z.length() + 1];
        for (int i = 0; i <= X.length(); i++) {
            for (int j = 0; j <= Y.length(); j++) {
                for (int k = 0; k <= Z.length(); k++) {
                    if (i == 0 || j == 0 || k == 0)
                        L[i][j][k] = 0;

                    else if (X.charAt(i - 1) == Y.charAt(j - 1)
                            && X.charAt(i - 1) == Z.charAt(k - 1))
                        L[i][j][k] = L[i - 1][j - 1][k - 1] + 1;

                    else
                        L[i][j][k] = Math.max(Math.max(L[i - 1][j][k],
                                        L[i][j - 1][k]),
                                L[i][j][k - 1]);
                }
            }
        }
        return L[X.length()][Y.length()][Z.length()];
    }

    // Solution 2
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for (int[][] temp : dp) {
            for (int[] a : temp) {
                Arrays.fill(a, -1);
            }
        }
        return LCS(A, B, C, n1, n2, n3, dp);
    }

    int LCS(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if (i == 0 || j == 0 || k == 0)
            return 0;
        if (dp[i][j][k] != -1)
            return dp[i][j][k];
        if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
            return dp[i][j][k] = 1 + LCS(s1, s2, s3, i - 1, j - 1, k - 1, dp);
        }
        int l = LCS(s1, s2, s3, i - 1, j, k, dp);
        int m = LCS(s1, s2, s3, i, j - 1, k, dp);
        int n = LCS(s1, s2, s3, i, j, k - 1, dp);

        return dp[i][j][k] = Math.max(l, Math.max(m, n));
    }
}
