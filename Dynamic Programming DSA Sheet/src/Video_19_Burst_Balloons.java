public class Video_19_Burst_Balloons {
    // https://leetcode.com/problems/burst-balloons/
    // https://www.youtube.com/watch?v=YzvF8CqPafI&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=23
    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : nums[i - 1]) * nums[k] * (j == nums.length - 1 ? 1 : nums[j + 1]);
                    max = Math.max(max,left + right + val);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{5}));
    }
}
