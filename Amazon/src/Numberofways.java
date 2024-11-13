// https://practice.geeksforgeeks.org/problems/number-of-ways2552/1/?category[]=Mathematical&category[]=Mathematical&company[]=Amazon&company[]=Amazon&page=3&query=category[]Mathematicalcompany[]Amazonpage3company[]Amazoncategory[]Mathematical#

public class Numberofways {
    static long arrangeTiles(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 1;
        if (n == 4)
            return 2;

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 4];
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}