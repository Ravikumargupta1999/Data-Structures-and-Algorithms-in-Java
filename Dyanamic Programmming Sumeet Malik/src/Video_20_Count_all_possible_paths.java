public class Video_20_Count_all_possible_paths {
    long numberOfPaths(int a, int b) {
        long p = 1000000007;
        long[][] dp = new long[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = (dp[i - 1][j] % p + dp[i][j - 1] % p) % p;
                }
            }
        }
        return dp[a - 1][b - 1];
    }

    public static void main(String[] args) {

    }
}
//https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=4&query=category[]Dynamic%20Programmingdifficulty[]0page4category[]Dynamic%20Programming#
