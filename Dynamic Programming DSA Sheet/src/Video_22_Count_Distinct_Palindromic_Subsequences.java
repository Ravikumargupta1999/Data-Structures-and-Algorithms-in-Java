import java.util.HashMap;

public class Video_22_Count_Distinct_Palindromic_Subsequences {
    // https://www.youtube.com/watch?v=9UEHPiK53BA&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=34
    //

    public int countPalindromicSubsequences(String s) {
        long[][] dp = new long[s.length()][s.length()];
        int[] prev = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch))
                prev[i] = -1;
            else
                prev[i] = map.get(ch);
            map.put(ch, i);
        }
        map.clear();
        int[] next = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch))
                next[i] = -1;
            else
                next[i] = map.get(ch);
            map.put(ch, i);
        }
        long mod = 1_000_000_07;
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = 2;
                } else {
                    char sc = s.charAt(i);
                    char ec = s.charAt(j);
                    if (sc != ec) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int n = next[i];
                        int p = prev[i];
                        if (n > p) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        } else if (n == p) {
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        } else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[n + 1][p - 1];
                        }
                    }
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
        }
        return (int) dp[0][s.length() - 1];
    }

    public int countPalindromicSubsequences1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        long[][] dp = new long[n][n];
        long mod = 1_000_000_007;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 2 * dp[i + 1][j - 1];
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && chars[left] != chars[i]) {
                        left++;
                    }
                    while (left <= right && chars[right] != chars[i]) {
                        right--;
                    }
                    if (left > right) {
                        dp[i][j] += 2;
                    } else if (left == right) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[left + 1][right - 1];
                    }
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[0][n - 1];
    }
}
