import java.util.Arrays;

public class D_Dynamic_Programming_469_Maximum_Length_Of_Chain_Pair {
    // https://www.youtube.com/watch?v=v0D3HtS8GAg
    // https://leetcode.com/problems/maximum-length-of-pair-chain/submissions/
    public int findLongestChain(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) ->
        {
            return a[1] - b[1];
        });
        int omax = 0;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = dp[i];
                if (arr[j][1] < arr[i][0]) {
                    int temp = dp[j] + 1;
                    if (dp[i] < temp)
                        dp[i] = temp;
                }

            }
            if (omax < dp[i])
                omax = dp[i];
        }

        if (omax == 0)
            return 1;
        return omax;
    }

    class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    // https://practice.geeksforgeeks.org/problems/max-length-chain/1
    int maxChainLength(Pair[] arr, int n) {

        Arrays.sort(arr, (a, b) ->
        {
            return a.y - b.y;
        });
        int overallMax = 0;
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;
        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j].y < arr[i].x) {
                    int temp = dp[j] + 1;
                    if (dp[i] < temp)
                        dp[i] = temp;
                }

            }
            if (overallMax < dp[i])
                overallMax = dp[i];
        }

        if (overallMax == 0)
            return 1;
        return overallMax;
    }

}