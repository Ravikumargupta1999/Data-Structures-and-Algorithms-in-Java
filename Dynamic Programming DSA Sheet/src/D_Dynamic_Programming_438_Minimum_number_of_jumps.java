public class D_Dynamic_Programming_438_Minimum_number_of_jumps {
    // https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
    // https://www.youtube.com/watch?v=phgjL7SbsWs
    // TC : O(n^2)
    // SC : O(n)
    static int minJumps(int[] arr) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < n; j++) {
                if (dp[i + j] != null) {
                    min = Math.min(min, dp[i + j]);
                }
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        return dp[0] == null ? -1 : dp[0];
    }

    // https://www.youtube.com/watch?v=CqgK_qi4SKQ&t=100s
    static int minJumps1(int[] arr) {

        int n = arr.length;
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1;
        if (n == 1)
            return 0;
        else if (arr[0] == 0)
            return -1;
        else {
            for (int i = 1; i < n; i++) {
                if (maxReach >= n - 1)
                    return jump;
                if (i == n - 1)
                    return jump;
                maxReach = Math.max(maxReach, i + arr[i]);
                steps--;
                if (steps == 0) {
                    jump++;
                    if (i >= maxReach) {
                        return -1;
                    }
                    steps = maxReach - i;
                }
            }
        }
        return jump;
    }


}
