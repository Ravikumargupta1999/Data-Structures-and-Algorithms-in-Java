import java.util.Scanner;

public class String_69_Edit_Distance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        int output = editDistance(str1, str2);
        System.out.println(output);
    }
    // https://www.youtube.com/watch?v=tooMn-xfYCU
    // https://www.youtube.com/watch?v=tooMn-xfYCU&list=RDCMUC7rNzgC2fEBVpb-q_acpsmw&start_radio=1&rv=tooMn-xfYCU&t=508
    // https://practice.geeksforgeeks.org/problems/edit-distance3702/1#
    // https://leetcode.com/problems/edit-distance/
    public static int editDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }

}
