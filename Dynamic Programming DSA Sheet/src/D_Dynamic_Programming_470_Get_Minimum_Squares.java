
//https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=3&query=category[]Dynamic%20Programmingdifficulty[]1page3category[]Dynamic%20Programming

public class D_Dynamic_Programming_470_Get_Minimum_Squares {
    int function(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int rem = i - j * j;
                if (dp[rem] < min)
                    min = dp[rem];
            }
            dp[i] = min + 1;

        }
        return dp[n];
    }

    int function1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                int rem = i - j * j;
                if (dp[rem] < min)
                    min = dp[rem];
            }
            dp[i] = min + 1;

        }
        return dp[n];
    }

}
