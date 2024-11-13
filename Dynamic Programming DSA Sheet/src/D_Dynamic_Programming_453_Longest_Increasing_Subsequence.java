public class D_Dynamic_Programming_453_Longest_Increasing_Subsequence {
    // https://www.youtube.com/watch?v=odrfUCS9sQk
    // https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
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

    static int longestSubsequence1(int s, int v[]) {
        if (v.length == 0)
            return 0;

        int[] tail = new int[v.length];
        int size = 0;
        for (int x : v) {
            int i = 0;
            int j = size;

            while (i != j) {
                int mid = (i + j) / 2;

                if (tail[mid] < x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }

            tail[i] = x;

            if (i == size)
                size++;
        }
        return size;
    }
}
