import java.util.Scanner;


// https://www.codingninjas.com/codestudio/problems/catalan-number_893076?leftPanelTab=1
public class D_Dynamic_Programming_414_Catalan_Number_Coding_Ninja {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0){

            int n = scn.nextInt();

            System.out.println(getCatalan(n));
        }
    }
    public static int getCatalan(int n) {
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l <= i - 1) {
                dp[i] = (dp[i] + (dp[l] * dp[r])) % 1000000007;
                l++;
                r--;
            }
        }
        return (int) dp[n] % 1000000007;
    }

}
