public class Video_26_Scramble_String {
//    public boolean isScramble(String s1, String s2) {
//        if (s1.equals(s2))
//            return true;
//        for (int i = 1; i < s1.length(); i++) {
//            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
//                    (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))))
//                return true;
//        }
//        return false;
//
//    }
    public boolean isScramble(String s1, String s2) {
        return s1.length() == s2.length() ? isScramble1(s1, s2, 0, 0, s1.length(), new Boolean[s1.length()][s1.length()][s1.length() + 1]) : false;
    }

    public static boolean isScramble1(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {
        if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len)))
            return true;
        if (dp[si1][si2][len] != null) {
            return dp[si1][si2][len];
        }
        for (int k = 1; k < len; k++) {
            if ((isScramble1(s1, s2, si1, si2, k, dp) && isScramble1(s1, s2, si1 + k, si2 + k, len - k, dp))
                    || (isScramble1(s1, s2, si1, si2 + len - k, k, dp) && isScramble1(s1, s2, si1 + k, si2, len - k, dp))) {
                dp[si1][si2][len] = true;
                return true;
            }
        }
        dp[si1][si2][len] = false;
        return false;

    }

}
