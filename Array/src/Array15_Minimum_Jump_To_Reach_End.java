import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Array15_Minimum_Jump_To_Reach_End {

    // https://www.youtube.com/watch?v=_6QpiqTw_ew
    // https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
    public static int MinJump(int[] arr, int n) {
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
        if (n == 1)
            return 0;
        else if (arr[0] == 0)
            return -1;
        else {
            for (int i = 1; i < n; i++) {
                if (i == n - 1) {
                    return jump;
                }
                maxReach = Math.max(maxReach, i + arr[i]);
                step--;
                if (step == 0) {
                    jump++;
                    if (i >= maxReach)
                        return -1;
                }
                step = maxReach - i;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/jump-game/submissions/865780372/
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) {
                    continue;
                }

                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0] == null ? false : true;
    }

    // https://leetcode.com/problems/jump-game-ii/submissions/865781234/
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n) {
                    continue;
                }

                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }

            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }

    // https://leetcode.com/problems/jump-game-iii/description/
    public static boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int n = arr.length;
        boolean[] dp = new boolean[n];
        dp[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dp[start] = true;
        while (!queue.isEmpty()) {

            int temp = queue.poll();
            if (temp + arr[temp] < n && !dp[temp + arr[temp]]) {
                if (arr[temp + arr[temp]] == 0)
                    return true;
                queue.add(temp + arr[temp]);
                dp[temp + arr[temp]] = true;
            }

            if (temp - arr[temp] >= 0 && !dp[temp - arr[temp]]) {
                if (arr[temp - arr[temp]] == 0)
                    return true;
                queue.add(temp - arr[temp]);
                dp[temp - arr[temp]] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println();
    }
}

