import java.util.ArrayDeque;

public class Video_6_Print_Paths_of_0_1_Knapsack {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void solution(int[] wts, int[] vals, int cap) {
        int n = vals.length;
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= wts[i - 1]) {
                    if (dp[i - 1][j - wts[i - 1]] + vals[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j - wts[i - 1]] + vals[i - 1];
                    }

                }
            }
        }

        System.out.println(dp[n][cap]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, cap, ""));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                int exc = dp[rem.i - 1][rem.j];
                if (rem.j >= wts[rem.i - 1]) {
                    int inc = dp[rem.i - 1][rem.j - wts[rem.i - 1]] + vals[rem.i - 1];
                    if (dp[rem.i][rem.j] == inc) {
                        queue.add(new Pair(rem.i - 1, rem.j - wts[rem.i - 1], (rem.i - 1) + " " + rem.psf));
                    }
                }
                if (dp[rem.i][rem.j] == exc) {
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }
    }

}
