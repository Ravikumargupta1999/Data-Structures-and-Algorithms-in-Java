import java.util.Arrays;

public class String68_Word_Wrap_Problem {
    public static void main(String[] args) {
        int[] arr = {3,2,2,5};
        System.out.println(solveWordWrap(arr,6));
    }
    public static int solveWordWrap(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return wordwrap(nums, 0, dp, k);
    }

    private static int wordwrap(int[] nums, int index, int dp[], int k) {
        System.out.println(index);
        System.out.println(Arrays.toString(dp));
        if (index >= nums.length - 1)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int min = Integer.MAX_VALUE;
        int oneline = 0;
        for (int i = index; i < nums.length; i++) {
            oneline += nums[i];
            if (oneline <= k) {
                System.out.println("online : "+oneline);
                int result = (k - oneline) * (k - oneline) + wordwrap(nums, i + 1, dp, k);
                if (i == nums.length - 1)
                    return 0;
                oneline += 1;
                min = Math.min(min, result);
            }
            else
                break;
        }
        dp[index] = min;
        return min;
    }
}
