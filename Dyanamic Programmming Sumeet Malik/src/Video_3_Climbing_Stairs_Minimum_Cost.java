public class Video_3_Climbing_Stairs_Minimum_Cost {
    static int minCostClimbingStairs(int[] cost, int n) {

        for (int i = 2; i < n; i++)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
// https://practice.geeksforgeeks.org/problems/min-cost-climbing-stairs/1
// https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
// https://www.youtube.com/watch?v=OoGswqFU-zs