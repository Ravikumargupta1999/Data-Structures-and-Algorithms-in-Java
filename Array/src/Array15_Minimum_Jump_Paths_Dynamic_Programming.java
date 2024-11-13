import java.util.ArrayDeque;


public class Array15_Minimum_Jump_Paths_Dynamic_Programming {
    public static void main(String[] args) {

        int n = 11;
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("Array is :  ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("\n\n");

        int minimum_jump = MinJump(arr);
        System.out.println("Minimum Jump :  " + minimum_jump);
    }

    // https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
    // https://www.youtube.com/watch?v=phgjL7SbsWs&t=1163s

    public static class Pair {
        int i;
        int j;
        int s;
        String psf;

        public Pair(int i, int s, int j, String psf) {
            this.i = i;
            this.s = s;
            this.j = j;
            this.psf = psf;
        }
    }

    public static int MinJump(int[] arr) {
        Integer[] dp = new Integer[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < arr.length; j++) {
                if (dp[i + j] != null && dp[i + j] < min) {
                    min = dp[i + j];
                }
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, arr[0], dp[0], 0 + " "));

        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            System.out.println(rem.i+" "+rem.s+"  "+rem.j+"  "+rem.psf);
            if (rem.j == 0)
                System.out.println(rem.psf + " .");
            for (int j = 1; j <= rem.s && rem.i + j < arr.length; j++) {
                int ci = rem.i + j;
                if (dp[ci] != null && dp[ci] == rem.j - 1) {
                   // System.out.println(rem.i+" "+rem.s+"  "+rem.j+"  "+rem.psf);
                    queue.add(new Pair(ci, arr[ci], dp[ci], rem.psf + " -> " + ci));
                }
            }
        }
        if (dp[0] != null)
            return dp[0];
        return -1;
    }

}
