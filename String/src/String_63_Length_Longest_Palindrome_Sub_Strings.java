public class String_63_Length_Longest_Palindrome_Sub_Strings {


    // GFg 1 length wale ko conisder nahi karna hai gfg wale mein
    public static int CountPS(String s) {
        int len = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (ch1 == ch2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (ch1 == ch2 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j])
                    len = g + 1;
            }
        }
        return len;
    }
}
