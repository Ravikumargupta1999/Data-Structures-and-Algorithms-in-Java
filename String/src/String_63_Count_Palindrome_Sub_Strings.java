import java.util.Scanner;

public class String_63_Count_Palindrome_Sub_Strings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "aaaaa";
        // str.substring()
        int count = Count_Palindrome(str);
        System.out.println(count);
    }

    // https://leetcode.com/problems/palindromic-substrings/
    // https://www.youtube.com/watch?v=XmSOWnL6T_I&t=843s
    public static int Count_Palindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (ch1 == ch2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (ch1 == ch2 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j])
                    count++;
            }
        }
        return count;
    }

    // GFg 1 length wale ko conisder nahi karta hai
    // https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1
    public int CountPS(String s, int n) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (ch1 == ch2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (ch1 == ch2 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j])
                    count++;
            }
        }
        return count - s.length();
    }
}
