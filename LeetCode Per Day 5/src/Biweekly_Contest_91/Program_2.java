package Biweekly_Contest_91;

import java.util.ArrayList;
import java.util.Arrays;

public class Program_2 {
    public static void main(String[] args) {
        Program_2 obj = new Program_2();
        System.out.println(obj.countGoodStrings(720,720,4,5));
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp,-1);
        int a1 = recursion(zero, zero, one, low, high,dp) % (1000000007);
        int a2 = recursion(one, zero, one, low, high,dp)  % (1000000007);

        return  (a1 % (1000000007) + a2 % (1000000007))% (1000000007);
    }

    public int recursion(int val, int f1, int f2, int low, int high,int[] dp) {
        int mod = 1000000007;
        if (val > high)
            return -1;
        if(dp[val] != -1)
            return dp[val];
        int ans = 0;
        if(val >= low && val <= high)
            ans = 1;
        int a1 = recursion(val + f1, f1, f2, low, high,dp);
        int a2 = recursion(val + f2, f1, f2, low, high,dp);
        if (a1 != -1)
            ans = ans  + a1 % mod;
        if (a2 != -1)
            ans = ans  + a2 % mod;
        return dp[val] =  ans % mod;

    }
}
