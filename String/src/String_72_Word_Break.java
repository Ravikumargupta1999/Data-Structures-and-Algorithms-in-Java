
import java.util.ArrayList;


public class String_72_Word_Break {
    // Recursion
    // https://www.youtube.com/watch?v=LmHWIsBQBU4&t=262s
    public static int wordBreak(String A, ArrayList<String> B) {
        return findValidAns(A, "", B) ? 1 : 0;
    }

    public static boolean findValidAns(String str, String ans, ArrayList<String> B) {
        if (str.length() == 0) {
            System.out.println(ans);
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (B.contains(left)) {
                boolean val = findValidAns(str.substring(i + 1), ans + left + " ", B);
                if (val)
                    return true;
            }
        }
        return false;
    }

    // DP Solution
    // https://www.youtube.com/watch?v=2NaaM_z_Jig
    // https://practice.geeksforgeeks.org/problems/word-break1352/1#
    public static int Solution(String A, ArrayList<String> B) {
        int[] dp = new int[A.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String str = A.substring(j, i + 1);
                if (B.contains(str)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }
                }
            }

        }
        return dp[A.length() - 1] > 0 ? 1 : 0;
    }
}

