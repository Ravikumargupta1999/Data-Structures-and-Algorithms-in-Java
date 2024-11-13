package Day_25_Dynamic_Programming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {

            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS1(int[] v) {
        if (v.length == 0)
            return 0;

        int[] tail = new int[v.length];
        int length = 1;
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {

            if (v[i] > tail[length - 1]) {

                tail[length++] = v[i];
            } else {
                int idx = findCeil(tail, length, v[i]);
                System.out.println(idx);
                tail[idx] = v[i];
            }
            System.out.println(Arrays.toString(tail));
        }
        return length;
    }

    static int findCeil(int[] arr, int n, int x) {
        int l = 0;
        int r = n - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= x) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 7, 9, 0, 10, 5, 6};
        System.out.println(lengthOfLIS1(arr));
    }

    // https://www.codingninjas.com/codestudio/problems/ceiling-in-a-sorted-array_1825401?leftPanelTab=1
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int l = 0;
        int r = n - 1;
        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                res = arr[mid];
                r = mid - 1;
            }
        }
        return res;
    }
}
