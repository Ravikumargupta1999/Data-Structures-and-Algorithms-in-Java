import java.util.ArrayDeque;
import java.util.Scanner;

public class Video_8_Print_All_Longest_Increasing_Subsequences {
    public static class Pair {
        int length;
        int i;
        int value;
        String psf;

        Pair(int l, int i, int v, String psf) {
            this.length = l;
            this.i = i;
            this.value = v;
            this.psf = psf;
        }
    }

    public static void solution(int[] arr) {
        int[] dp = new int[arr.length];
        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max)
                        max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];

            }
        }
        System.out.println(omax);

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++)
            if (dp[i] == omax)
                queue.add(new Pair(omax, i, arr[i], arr[i] + ""));


        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.length == 1)
                System.out.println(rem.psf);
            for (int j = rem.i - 1; j >= 0; j--) {
                if (dp[j] == rem.length - 1 && arr[j] <= rem.value) {
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rem.psf));
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        int[] arr = {100, 101, 102, 103, 5, 8, 3, 7, 9, 10};

        solution(arr);

        scn.close();
    }
}
