public class Array36_Smallest_Sub_array_with_sum_greater_than_a_given_value {
    // https://leetcode.com/problems/minimum-size-subarray-sum/
    // https://www.youtube.com/watch?v=jKF9AcyBZ6E&t=447s
    public static int smallestSubWithSum(int nums[], int n, int target) {
        int sum = 0;
        int size = nums.length + 1;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > target) {
                size = Math.min(size, i - j + 1);
            }
            while (sum > target && j <= i) {
                sum -= nums[j];
                j++;
                if (sum > target) {
                    size = Math.min(size, i - j + 1);
                }
            }
        }
        return size == nums.length + 1 ? 0 : size;

    }


    // Brute Force
    public static int smallestSubWithSum3(int[] arr, int n, int x) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];
            if (currentSum > x)
                return 1;
            for (int j = i + 1; j < n; j++) {
                currentSum += arr[j];
                if (currentSum > x)
                    min = Math.min(min, j - i + 1);
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;

    }

    // https://leetcode.com/problems/minimum-size-subarray-sum/submissions/861188558/
    public int minSubArrayLen11(int target, int[] nums) {
        int sum = 0;
        int size = nums.length + 1;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                size = Math.min(size, i - j + 1);
            }
            while (sum >= target && j <= i) {
                sum -= nums[j];
                j++;
                if (sum >= target) {
                    size = Math.min(size, i - j + 1);
                }
            }
        }
        return size == nums.length + 1 ? 0 : size;
    }


}
