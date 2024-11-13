

public class String_64_Longest_Repeating_Subsequences {
    // https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1/#
    //
    public static int  longestRepeatingSubsequence(String s1) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp.length - 2; j >= 0; j--) {

                    if (s1.charAt(i) == s1.charAt(j) && i != j)
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);

                }
            }
        }
        int length = dp[0][0];
//        System.out.println("Length of longest Repeating subsequences :  " + length);
        int temp = length;
        char[] value = new char[length + 1];
        value[length] = '\0';
        int len = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s1.length()) {
            if (s1.charAt(i) == s1.charAt(j) && i != j) {
                value[len] = s1.charAt(i);
                i++;
                j++;
                len++;
            } else if (dp[i + 1][j] > dp[i][j + 1])
                i++;
            else
                j++;
        }
//        System.out.print("Longest Common Subsequences is :  ");
//        for (int k = 0; k <= temp; k++)
//            System.out.print(value[k]);
//        System.out.println("");
        String str = new String(value);
        System.out.println(str);
        System.out.println(dp[0][0]);
        return dp[0][0];
    }

    public static void main(String[] args) {
        longestRepeatingSubsequence("axxzxy");
    }
}
