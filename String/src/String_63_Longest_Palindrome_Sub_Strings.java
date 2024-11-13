
// Done


public class String_63_Longest_Palindrome_Sub_Strings {

    // https://leetcode.com/problems/longest-palindromic-substring/submissions/
    // https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/#
    // https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1/#
    String longestPalindrome1(String s) {
        int len = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        int start = 0;
        int end = 0;
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
                if (dp[i][j]) {
//                    System.out.println(s.substring(i,j+1)+"  "+(g+1)+"   "+len);
                    if (g + 1 > len) {
                        len = g + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        if (start == end)
            return s.charAt(0) + "";
        return s.substring(start, end + 1);
    }


    static String longestPalSubstr1(String str) {
        int n = str.length(); // calculcharAting size of string
        if (n < 2)
            return str.charAt(0) + ""; // if string is empty then size will be 0.
        // if n==1 then, answer will be 1(single character will always palindrome)

        int maxLength = 1, start = 0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i)) //increment 'high'
                high++;

            while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
         return  str.substring(start, start + maxLength);
    }

    // https://www.youtube.com/watch?v=jCOJk4UyO8w
    public static String longestPalindrome(String S) {
        if (S.length() <= 1)
            return S;
        int max_len = 1;
        int n = S.length();
        int start = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (S.charAt(l) == S.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int len = r - l - 1;
            if (len > max_len) {
                max_len = len;
                start = l + 1;
                end = r - 1;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n) {
                if (S.charAt(l) == S.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            int len = r - l - 1;
            if (len > max_len) {
                max_len = len;
                start = l + 1;
                end = r - 1;
            }
        }
        return S.substring(start, end + 1);
    }
}
