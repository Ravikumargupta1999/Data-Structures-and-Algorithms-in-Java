package Recursion;

import java.util.ArrayList;

public class Print_Encoding {
    public static void main(String[] args) {
        System.out.println(numDecoding("226"));
        ArrayList<String> al = new ArrayList<>();
        printEncodings("226", "", al);
        System.out.println(al);

    }

    public static void printEncodings(String ques, String asf, ArrayList<String> res) {
        if (ques.length() == 0) {
            res.add(asf);

        } else if (ques.length() == 1) {
            char ch = ques.charAt(0);
            if (ch != '0') {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                res.add(asf + code);
            }
        } else {
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncodings(roq, asf + code, res);
            }

            String ch12 = ques.substring(0, 2);
            String roq2 = ques.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncodings(roq2, asf + code, res);
            }
        }
    }

    //  https://www.youtube.com/results?search_query=Total+Decoding+Messages
    //  https://leetcode.com/problems/decode-ways/submissions/
    //  https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1
    //  DP Approach
    public static int numDecoding(String str) {
        int[] dp = new int[str.length()];

        dp[0] = 1;
        if (str.charAt(0) == '0')
            return 0;

        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    int val = (i >= 2 ? dp[i - 2] : 1);
                    dp[i] = val;
                } else {
                    dp[i] = 0;
                }
            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    int val = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                    dp[i] = val;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[str.length() - 1];
    }
}
