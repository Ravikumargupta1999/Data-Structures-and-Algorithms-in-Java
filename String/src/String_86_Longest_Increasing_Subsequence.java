public class String_86_Longest_Increasing_Subsequence {
    // https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
    // https://www.youtube.com/watch?v=odrfUCS9sQk
    static int longestSubsequence(int size, int[] arr) {
        int[] dp = new int[size];
        int overAllMax = 0;
        for (int i = 0; i < size; i++) {

            int currMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            dp[i] = currMax + 1;
            overAllMax = Math.max(overAllMax, dp[i]);
        }
        return overAllMax;
    }

    static int lis(int nums[]) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;

            }

            tails[i] = x;
            if (i == size)
                ++size;

        }
        return size;
    }

    public static void main(String args[]) {

        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr));
    }
}
