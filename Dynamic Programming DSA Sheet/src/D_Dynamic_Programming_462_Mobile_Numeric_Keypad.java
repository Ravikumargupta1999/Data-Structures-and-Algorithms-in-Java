public class D_Dynamic_Programming_462_Mobile_Numeric_Keypad {
    // https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1
    // https://www.youtube.com/watch?v=IN3uTs8afz4&t=437s
    public static long getCount(int n) {
        int[][] data = {
                {0, 8},
                {1, 2, 4},
                {2, 1, 5, 3},
                {3, 2, 6},
                {4, 1, 7, 5},
                {5, 4, 2, 6, 8},
                {6, 5, 3, 9},
                {7, 4, 8},
                {8, 7, 0, 5, 9},
                {9, 8, 6},
        };

        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) {
                    dp[i][j] = 1;
                } else {
                    for (int val : data[j]) {
                        dp[i][j] += dp[i - 1][val];
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= 9; i++)
            res += dp[n][i];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getCount(2));
    }
}