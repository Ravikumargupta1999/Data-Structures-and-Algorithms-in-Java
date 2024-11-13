import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Video_3_Print_All_Paths_With_Minimum_Cost {
    public static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1)
                    dp[i][j] = arr[i][j];
                else if (i == n - 1)
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                else if (j == m - 1)
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                else
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        System.out.println(dp[0][0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("", 0, 0));
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (rem.i == n - 1 && rem.j == m - 1)
                System.out.println(rem.psf);
            int min = Integer.MAX_VALUE;
            if (isValid(arr, rem.i + 1, rem.j))
                min = Math.min(dp[rem.i + 1][rem.j], min);
            if (isValid(arr, rem.i, rem.j + 1))
                min = Math.min(dp[rem.i][rem.j + 1], min);


            if (isValid(arr, rem.i + 1, rem.j)) {
                if (min == dp[rem.i + 1][rem.j]) {
                    queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                }
            }
            if (isValid(arr, rem.i, rem.j + 1)) {
                if (min == dp[rem.i][rem.j + 1]) {
                    queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
                }
            }

        }
    }

    public static boolean isValid(int[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }
        solution(arr);
    }

}

