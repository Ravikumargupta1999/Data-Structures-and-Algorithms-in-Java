public class Video_54_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    //    Recursion

//    public int minimumDeleteSum(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        return minAsciiDelete(s1, s2, len1, len2);
//    }
//
//    public int minAsciiDelete(String s1, String s2, int len1, int len2) {
//        if (len1 == 0 && len2 == 0)
//            return 0;
//        else if (len1 == 0)
//            return getRemainingSum(s2, len2);
//        else if (len2 == 0)
//            return getRemainingSum(s1, len1);
//        int res = 0;
//        if (s1.charAt(len1 - 1) != s2.charAt(len2 - 1)) {
//            int res1 = s1.charAt(len1 - 1) + minAsciiDelete(s1, s2, len1 - 1, len2);
//            int res2 = s2.charAt(len2 - 1) + minAsciiDelete(s1, s2, len1, len2 - 1);
//            res = Math.min(res1, res2);
//        } else {
//            res += minAsciiDelete(s1, s2, len1 - 1, len2 - 1);
//        }
//        return res;
//    }
//
//    public int getRemainingSum(String str, int n) {
//        int cost = 0;
//        for (int i = 0; i < n; i++) {
//
//            int val = str.charAt(i);
//
//            cost += val;
//        }
//        return cost;
//    }

    // Memoization
//    public int minimumDeleteSum(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//        int[][] dp = new int[len1 + 1][len2 + 1];
//        for (int[] temp : dp)
//            Arrays.fill(temp, -1);
//        return minAsciiDelete(s1, s2, len1, len2, dp);
//    }
//
//    public int minAsciiDelete(String s1, String s2, int len1, int len2, int[][] dp) {
//        if (len1 == 0 && len2 == 0)
//            return 0;
//        else if (len1 == 0)
//            return dp[len1][len2] = getRemainingSum(s2, len2);
//        else if (len2 == 0)
//            return dp[len1][len2] = getRemainingSum(s1, len1);
//        if (dp[len1][len2] != -1)
//            return dp[len1][len2];
//        int res = 0;
//        if (s1.charAt(len1 - 1) != s2.charAt(len2 - 1)) {
//            int res1 = s1.charAt(len1 - 1) + minAsciiDelete(s1, s2, len1 - 1, len2, dp);
//            int res2 = s2.charAt(len2 - 1) + minAsciiDelete(s1, s2, len1, len2 - 1, dp);
//            res = Math.min(res1, res2);
//        } else {
//            res += minAsciiDelete(s1, s2, len1 - 1, len2 - 1, dp);
//        }
//        return dp[len1][len2] = res;
//    }
//
//    public int getRemainingSum(String str, int n) {
//        int cost = 0;
//        for (int i = 0; i < n; i++) {
//
//            int val = str.charAt(i);
//
//            cost += val;
//        }
//        return cost;
//    }

    public int minimumDeleteSum(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length-1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = (int) s2.charAt(j) + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = (int) s1.charAt(i) + dp[i + 1][j];
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }


}
