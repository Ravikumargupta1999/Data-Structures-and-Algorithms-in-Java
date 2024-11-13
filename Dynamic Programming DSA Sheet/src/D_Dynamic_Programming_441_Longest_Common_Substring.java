import java.util.ArrayList;
import java.util.List;

public class D_Dynamic_Programming_441_Longest_Common_Substring {
    public static int LongestCommonSubstring(String S1, String S2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = S1.charAt(i - 1);
                char c2 = S2.charAt(j - 1);
                if (c1 != c2)
                    dp[i][j] = 0;
                else
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }
        List<String> list = new ArrayList<>();
        findAllCommonSubString(dp, max, list, S1);
        System.out.println(list);
        return max;
    }

    public static void findAllCommonSubString(int[][] dp, int length, List<String> list, String str) {
        for (int i = dp.length - 1; i > 0; i--) {
            for (int j = dp[0].length - 1; j > 0; j--) {
                if (dp[i][j] == length)
                    getString(dp, i, j, list, length, str);
            }
        }
    }

    public static void getString(int[][] dp, int i, int j, List<String> list, int len, String str) {
        String ans = "";
        while (len-- > 0) {
            ans = str.charAt(i - 1) + "" + ans;
            i--;
            j--;
        }
        list.add(ans);
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ACB";
        System.out.println(LongestCommonSubstring(s1,s2,s1.length(),s2.length()));
    }
}
