import java.util.HashMap;

public class Video_23_Count_Distinct_Subsequences {
    //    https://www.youtube.com/watch?v=9UEHPiK53BA&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=34
    // https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
    int distinctSubsequences(String str) {
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
            return dp[str.length()] += (p);
        return dp[str.length()];
    }

    // https://leetcode.com/problems/distinct-subsequences-ii/
    public int distinctSubseqII(String S) {
        int mod = 1000000007;
        int n = S.length();
        long [] dp = new long[n + 1];

        dp[0] = 1;
        HashMap<Character, Integer> lo = new HashMap<>();

        for(int i=1; i < dp.length; i++){
            dp[i] = (2 * dp[i-1]) % mod;
            char ch = S.charAt(i-1);

            if(lo.containsKey(ch)){
                int j =  lo.get(ch);
                dp[i] = (dp[i] - dp[j-1] + mod) % mod;
            }
            lo.put(ch, i % mod);

        }
        return (int)(dp[n] % mod)-1;
    }
}
