//import javafx.util.Pair;

import java.util.Arrays;

// https://www.youtube.com/watch?v=v0D3HtS8GAg
public class D_Dynamic_Programming_433_Maximum_Length_Of_Chain_Pair {
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

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    // https://practice.geeksforgeeks.org/problems/max-length-chain/1
    static int maxChainLength(Pair[] arr, int n) {
        Arrays.sort(arr, (a, b) -> {
            return a.y - b.y;
        });

        int overAllMax = 1;

        int[] dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {

                if (arr[j].y < arr[i].x)
                    max = Math.max(max, dp[j]);

            }
//            System.out.println(i+"   "+max);
            dp[i] = max + 1;

            overAllMax = Math.max(overAllMax, dp[i]);

        }

        return overAllMax;
    }

    public static void main(String[] args) {
        Pair[] P = new Pair[5];
        P[0] = new Pair(5, 24);
        P[1] = new Pair(39, 60);
        P[2] = new Pair(15, 28);
        P[3] = new Pair(27, 40);
        P[4] = new Pair(50, 90);
        System.out.println(maxChainLength(P, 5));

    }
}
