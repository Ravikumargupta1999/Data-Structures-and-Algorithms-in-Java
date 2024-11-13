import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Unique_Paths {
    int p = 1000000007;

    public int uniquePaths(int m, int n) {
        if (n == 1 || m == 1)
            return 1;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    ans[i][j] = 1;
                ans[i][j] = -1;
            }
        }
        return findTotalWays(m, n, 0, 1, ans) + findTotalWays(m, n, 1, 0, ans);
    }

    int findTotalWays(int m, int n, int row, int col, int[][] arr) {
        if (col >= n || row >= m)
            return 0;
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        int ans = 0;

        if (col == n - 1) {
            if (arr[row + 1][col] != -1)
                ans += (arr[row + 1][col]) % p;
            else
                ans += (findTotalWays(m, n, row + 1, col, arr)) & p;
            arr[row][col] = ans % p;
            return ans;

        }
        if (row == m - 1) {
            if (arr[row][col + 1] != -1)
                ans += (arr[row][col + 1]) & p;
            else
                ans += (findTotalWays(m, n, row, col + 1, arr)) % p;
            arr[row][col] = ans % p;
            return ans;

        } else {
            if (arr[row][col + 1] != -1)
                ans += (arr[row][col + 1]) % p;
            else
                ans += (findTotalWays(m, n, row, col + 1, arr)) % p;


            if (arr[row + 1][col] != -1)
                ans += (arr[row + 1][col]) % p;
            else
                ans += (findTotalWays(m, n, row + 1, col, arr)) % p;

            arr[row][col] = ans % p;


        }

        return ans;
    }

    public static void main(String[] args) {
        Unique_Paths a = new Unique_Paths();
        System.out.println(a.uniquePaths(52, 42));
    }
}
