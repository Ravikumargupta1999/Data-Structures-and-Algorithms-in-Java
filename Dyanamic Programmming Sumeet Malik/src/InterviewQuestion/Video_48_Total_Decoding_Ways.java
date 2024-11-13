package InterviewQuestion;

public class Video_48_Total_Decoding_Ways {
    public int CountWays(String str) {
        int[] dp = new int[str.length()];
        int p = 1000000007;
        dp[0] = 1;
        if (str.charAt(0) == '0')
            return 0;

        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1] % p;
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    int val = (i >= 2 ? dp[i - 2] : 1) % p;
                    dp[i] = val;
                } else {
                    dp[i] = 0;
                }
            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    int val = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                    dp[i] = val % p;
                } else {
                    dp[i] = dp[i - 1] % p;
                }
            }
        }
        return dp[str.length() - 1];
    }
}
