import javafx.scene.transform.Scale;

// https://practice.geeksforgeeks.org/problems/geek-onacci-number/0/?problemType=full&page=1&query=problemTypefullpage1#

import java.util.Scanner;

public class Geek_onacci_Number {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0)
        {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            System.out.println(GeekNumber(a,b,c,d));
        }
    }
    public static int GeekNumber(int a,int b,int c,int n)
    {
        int[] dp = new int[n];
        dp[0] = a;
        dp[1] = b;
        dp[2] = c;
        for(int i=3 ; i<=n-1;i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        return dp[n-1];
    }
}
