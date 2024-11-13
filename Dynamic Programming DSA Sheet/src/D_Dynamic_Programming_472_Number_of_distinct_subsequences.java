import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1#
// https://leetcode.com/problems/distinct-subsequences-ii/submissions/
public class D_Dynamic_Programming_472_Number_of_distinct_subsequences {
    static int distinctSubsequences(String str) {
        int p = 1000000007;
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1]) % p;
            char ch = str.charAt(i - 1);
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = (dp[i] - dp[j - 1]) % p;
                dp[i] %= p;
            }
            map.put(ch, i);
        }
        if (dp[str.length()] < 0)
            return dp[str.length()] += p;
        return dp[str.length()];
    }

    public static int distinctSubsequenceII(String str) {
        int p = 1000000007;
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1]) % p;
            char ch = str.charAt(i - 1);
            if (map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = (dp[i] - dp[j - 1]) % p;
                dp[i] %= p;
            }
            map.put(ch, i);
        }
        if (dp[str.length()] <= 0)
            return dp[str.length()] += (p - 1);
        return dp[str.length()] - 1;
    }

    public static void main(String[] args) {
        String str = "ravi";
        System.out.println(distinctSubsequenceII(str));
        System.out.println(distinctSubsequences(str));
    }
}
