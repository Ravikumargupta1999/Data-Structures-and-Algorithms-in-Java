// https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1
public class Video_16_Number_of_Unique_Paths {
    public static int NumberOfPath(int a, int b) {
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[a - 1][b - 1];
    }

    public static void main(String[] args) {
        System.out.println(NumberOfPath(3, 3));
    }
}
