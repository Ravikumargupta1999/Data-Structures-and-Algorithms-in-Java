import java.util.Arrays;

// https://leetcode.com/problems/russian-doll-envelopes/
public class Video_10_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Bridge[] arr = new Bridge[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Bridge(envelopes[i][0], envelopes[i][1]);
        }
        return solution(arr);
    }

    public static class Bridge {
        int w;
        int h;

        Bridge(int w, int h) {
            this.w = w;
            this.h = h;
        }


    }

    public static int solution(Bridge[] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a.w != b.w)
                return a.w - b.w;
            else
                return a.h - b.h;
        });
        int omax = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].h < arr[i].h && arr[j].w < arr[i].w) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            omax = Math.max(omax, dp[i]);
        }
        return omax;
    }
}
