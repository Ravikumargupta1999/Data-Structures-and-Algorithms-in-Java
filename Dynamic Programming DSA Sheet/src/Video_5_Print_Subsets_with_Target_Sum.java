import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/print-all-paths-with-target-sum-subset-official/ojquestion
public class Video_5_Print_Subsets_with_Target_Sum {
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

    public static void solution(int[] arr, int tar) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][tar + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else if (j >= arr[i - 1]) {
                        if (dp[i - 1][j - arr[i - 1]]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, tar, ""));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.i == 0 || rem.j == 0)
                System.out.println(rem.psf);
            else {
                if (rem.j >= arr[rem.i - 1]) {
                    boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if (inc) {
                        queue.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], (rem.i - 1) + " " + rem.psf));
                    }
                }
                boolean exc = dp[rem.i - 1][rem.j];
                if (exc)
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());
        solution(arr, tar);
    }
}
//5
//        4
//        2
//        7
//        1
//        3
//        10