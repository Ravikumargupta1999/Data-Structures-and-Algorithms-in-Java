
public class Practice_16_1_Arithmetic_Slices {
    // https://leetcode.com/problems/arithmetic-slices/submissions/
   //  https://www.youtube.com/watch?v=rSi4MpGEz1M&t=23s

    public int numberOfArithmeticSlices(int[] arr) {
        int[] dp = new int[arr.length];
        int n = arr.length;
        if (n <= 2)
            return 0;
        int ans = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
