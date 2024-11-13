package Day_26_Dynamic_Programming_Part_II;

import java.util.Arrays;

// https://www.codingninjas.com/codestudio/problems/800284?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
public class Rod_Cutting_Problem {
    public static int cutRod(int[] price, int n) {
        int[] piece = new int[n];
        for (int i = 0; i < n; i++)
            piece[i] = i + 1;

        int W = n;
        int[] dp = new int[W + 1];

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (i >= piece[j]) {
                    int profit = price[j] + dp[i - piece[j]];
                    max = Math.max(max, profit);
                }
            }
            dp[i] = max;
        }
        return dp[W];
    }
}
