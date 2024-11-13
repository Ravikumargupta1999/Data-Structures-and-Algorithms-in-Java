// https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/?category[]=Arrays&category[]=Arrays&difficulty[]=2&page=1&query=category[]Arraysdifficulty[]2page1category[]Arrays#
// https://www.youtube.com/watch?v=Lj68VJ1wu84
public class Ugly_Numbers {
    static long getNthUglyNo(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for(int i = 2; i <= n ; i++)
        {
            long f1 = 2*dp[p2];
            long f3 = 3*dp[p3];
            long f5 = 5*dp[p5];
            long min = Math.min(f1,Math.min(f3,f5));
            dp[i] = min;
            if(f1 == min)
                p2++;
            if(f3 == min)
                p3++;
            if(f5 == min)
                p5++;
        }
        return dp[n];

    }
    public static void main(String[] args) {
        System.out.println(getNthUglyNo(10));
    }
}
