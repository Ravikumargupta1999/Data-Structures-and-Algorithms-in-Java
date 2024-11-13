package Day_10_Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Word_Break_I {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] wordDict = {"apple","pen","applepen","pine","pineapple"};
        List<String> list = new ArrayList<>();
        for (String word : wordDict)
            list.add(word);
        System.out.println(wordBreak(s,list));
    }
    public static boolean wordBreak(String A, List<String> B) {
        int[] dp = new int[A.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String str = A.substring(j, i + 1);
                System.out.println(str);
                if (B.contains(str)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }
                }
            }
            System.out.println("\n");


        }
        return dp[A.length() - 1] > 0;
    }
}
