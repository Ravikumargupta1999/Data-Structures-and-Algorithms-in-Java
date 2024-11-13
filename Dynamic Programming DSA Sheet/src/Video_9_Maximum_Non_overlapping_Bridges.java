import java.util.Arrays;

public class Video_9_Maximum_Non_overlapping_Bridges {
    public static class Bridge {
        int n;
        int s;

        Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int compareTo(Bridge o) {
            if (this.n != o.n)
                return this.n - o.n;
            else
                return this.s - o.s;
        }
    }

    public static void solution(Bridge[] arr) {
        Arrays.sort(arr);
        int[] dp = new int[arr.length];
        int overAllMax = 0;
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].s <= arr[i].s) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            overAllMax = Math.max(overAllMax, dp[i]);
        }
        System.out.println(overAllMax);
    }

}
//10
//        10 20
//        2 7
//        8 15
//        17 3
//        21 40
//        50 4