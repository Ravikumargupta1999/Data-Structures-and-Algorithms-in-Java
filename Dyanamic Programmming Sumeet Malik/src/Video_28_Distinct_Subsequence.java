import java.util.HashMap;

public class Video_28_Distinct_Subsequence {
    static int distinctSubsequences(String S) {
        // code her
        int mod = 1000000007;
        int[] dp = new int[S.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 1; i < dp.length; i++) {
            dp[i] = (2 * dp[i - 1]) % mod;

            char ch = S.charAt(i - 1);

            if (map.containsKey(ch)) {
                dp[i] = (dp[i] - dp[map.get(ch) - 1]) % mod;
                dp[i] %= mod;
            }
            map.put(ch, i);
        }
        if (dp[S.length()] <= 0)
            return dp[S.length()] += (mod);
        return dp[S.length()];
    }

    public static void main(String[] args) {
        System.out.println(distinctSubsequences("qhjsjuinavbufqmsppcfhgrvqsmwhcbxlmrvj"));
    }
}
