import java.util.ArrayList;
import java.util.List;

public class D_Dynamic_Programming_447_Word_Break_I {
    // https://www.youtube.com/watch?v=2NaaM_z_Jig
    // https://practice.geeksforgeeks.org/problems/word-break1352/1
    public static int wordBreak(String str, ArrayList<String> list) {
        int[] dp = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (list.contains(str.substring(j, i + 1))) {
                    dp[i] += j - 1 >= 0 ? dp[j - 1] : 0;
                }
            }
        }
        return dp[str.length()-1];
    }

    // // https://leetcode.com/problems/word-break/submissions/
    public boolean wordBreak(String str, List<String> list) {


        int[] dp = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (list.contains(str.substring(j, i + 1))) {
                    dp[i] += j - 1 >= 0 ? dp[j - 1] : 1;
                }
            }
        }
        return dp[str.length()-1] > 0 ? true : false;
    }
}
