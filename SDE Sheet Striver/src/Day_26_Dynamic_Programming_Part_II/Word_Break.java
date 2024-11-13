package Day_26_Dynamic_Programming_Part_II;

import java.util.ArrayList;

public class Word_Break {
    // https://practice.geeksforgeeks.org/problems/word-break1352/1
    public static int wordBreak(String str, ArrayList<String> list) {
        int[] dp = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (list.contains(str.substring(j, i + 1))) {
                    dp[i] += j - 1 >= 0 ? dp[j - 1] : 1;
                }
            }
        }
        return dp[str.length() - 1] > 0 ? 1 : 0;
    }
}
