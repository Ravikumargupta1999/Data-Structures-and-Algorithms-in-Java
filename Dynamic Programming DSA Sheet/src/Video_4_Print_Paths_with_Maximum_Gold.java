import java.util.ArrayDeque;
import java.util.Scanner;

public class Video_4_Print_Paths_with_Maximum_Gold {

    private static class Pair {
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
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else if (i == n - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i + 1][j + 1], dp[i][j + 1]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i][ind] > max)
                max = dp[i][ind];
        }
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dp[i][ind] == max)
                queue.add(new Pair(i + " ", i, ind));
        }
        System.out.println(max);
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (rem.j == m - 1)
                System.out.println(rem.psf);
            if (isValid(arr, rem.i - 1, rem.j + 1)) {
                if (arr[rem.i][rem.j] == dp[rem.i][rem.j] - dp[rem.i - 1][rem.j + 1]) {
                    queue.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }
            }
            if (isValid(arr, rem.i, rem.j + 1)) {
                if (arr[rem.i][rem.j] == dp[rem.i][rem.j] - dp[rem.i][rem.j + 1]) {
                    queue.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
            }
            if (isValid(arr, rem.i + 1, rem.j + 1)) {
                if (arr[rem.i][rem.j] == dp[rem.i][rem.j] - dp[rem.i + 1][rem.j + 1]) {
                    queue.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
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
        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int m = s.nextInt();
//        int[][] arr = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = s.nextInt();
//            }
//        }
        int n = 6, m = 6;
        int[][] arr = {{0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}};
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        solution(arr);
    }

}
