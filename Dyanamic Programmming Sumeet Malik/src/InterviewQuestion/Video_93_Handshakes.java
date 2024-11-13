package InterviewQuestion;

public class Video_93_Handshakes {
    //https://www.youtube.com/watch?v=J3Mtaa0jv6s
    // https://practice.geeksforgeeks.org/problems/handshakes1303/1
    static int count(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int n = 2; n <= N; n++) {
            for (int i = 0; i <= n - 2; i++) {
                dp[n] += dp[i] * dp[n - 2 - i];
            }
        }
        return dp[N];
    }
}
