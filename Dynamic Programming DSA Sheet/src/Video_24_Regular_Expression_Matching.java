public class Video_24_Regular_Expression_Matching {
    // https://leetcode.com/problems/regular-expression-matching/
    // https://www.youtube.com/watch?v=DJvw8jCmxUU&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=37
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    char pc = p.charAt(i - 1);
                    if (pc == '*') {
                        dp[i][j] = i - 2 >= 0 ? dp[i - 2][j] : false;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char pc = p.charAt(i - 1);
                    char sc = s.charAt(j - 1);
                    if (pc == '*') {
                        dp[i][j] = i - 2 >= 0 ? dp[i - 2][j] : false;

                        char pslc = p.charAt(i - 2);
                        if (pslc == '.' || pslc == sc) {
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                        }
                    } else if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == sc) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
