package Sumit_Malik_Level_2;

public class Practice_16_Longest_Consecutive_1s {
    // https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1
    public static int maxConsecutiveOnes(int n) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}
