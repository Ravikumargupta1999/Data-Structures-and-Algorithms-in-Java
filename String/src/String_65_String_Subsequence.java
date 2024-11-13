public class String_65_String_Subsequence {
    // https://practice.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1/
    // https://www.youtube.com/watch?v=YbanXpPqW1g
    int countWays(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    char ch1 = s1.charAt(i - 1);
                    char ch2 = s2.charAt(j - 1);
                    if (ch1 == ch2) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }



//    https://leetcode.com/problems/number-of-matching-subsequences/
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isMatching(s, word))
                count++;
        }
        return count;
    }

    public boolean isMatching(String string, String word) {
        if (word.length() > string.length())
            return false;
        int j = 0;
        for (int i = 0; i < word.length(); i++) {
            while (j < string.length() && string.charAt(j) != word.charAt(i))
                j++;
            if (j < string.length() && word.charAt(i) == string.charAt(j))
                j++;
            else
                return false;
        }
        return true;
    }
}
