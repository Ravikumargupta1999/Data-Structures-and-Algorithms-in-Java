import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/box-stacking/1#
// https://www.youtube.com/watch?v=YoZxqKAM5wg
// https://practice.geeksforgeeks.org/contest/coding-try-outs-amazon/problems#
public class String_89_3_Box_Stacking {
    static class Volume implements Comparable<Volume> {
        int l;
        int h;
        int w;

        public Volume(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }

        public int compareTo(Volume a) {
            return a.l * a.w - this.l * this.w;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        Volume[] v = new Volume[6 * n];
        for (int i = 0; i < n; i++) {
            v[i] = new Volume(height[i], width[i], length[i]);
            v[i + n] = new Volume(height[i], length[i], width[i]);
            v[i + 2 * n] = new Volume(width[i], length[i], height[i]);
            v[i + 3 * n] = new Volume(width[i], height[i], length[i]);
            v[i + 4 * n] = new Volume(length[i], width[i], height[i]);
            v[i + 5 * n] = new Volume(length[i], height[i], width[i]);
        }
        Arrays.sort(v);
        int[] dp = new int[6 * n];
        int ans = 0;
        for (int i = 0; i < 6 * n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (v[j].l > v[i].l && v[j].w > v[i].w) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + v[i].h;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
