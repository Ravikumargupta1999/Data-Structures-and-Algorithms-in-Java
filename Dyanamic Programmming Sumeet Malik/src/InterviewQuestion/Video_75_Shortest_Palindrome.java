package InterviewQuestion;

public class Video_75_Shortest_Palindrome {
    // https://leetcode.com/problems/shortest-palindrome/
//    public String shortestPalindrome(String s) {
//        return str.length() - longestPalindrome(str);
//    }
    public String longestPalindrome(String str) {
        String res = "";

        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    dp[i][j] = ch1 == ch2 ? 2 : 1;
                } else {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if (ch1 == ch2) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
                if(dp[i][j] > res.length()){
                    res = str.substring(i,j+1);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Video_75_Shortest_Palindrome().longestPalindrome("abbccbd"));
    }
}
