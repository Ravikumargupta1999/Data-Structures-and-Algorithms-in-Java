public class D_Dynamic_Programming_426_Space_Optimized_LCS {
    // https://www.youtube.com/watch?v=0Ql40Llp09E&t=1712s
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                if (ch1 == ch2)
                    dp[(i) % 2][j] = 1 + dp[(i + 1) % 2][j + 1];
                else
                    dp[(i) % 2][j] = Math.max(dp[(i + 1) % 2][j], dp[(i) % 2][j + 1]);
            }
        }
        return Math.max(dp[0][0], dp[1][0]);
    }

}
