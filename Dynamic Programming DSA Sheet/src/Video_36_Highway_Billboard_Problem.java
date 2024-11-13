// https://www.geeksforgeeks.org/highway-billboard-problem/
public class Video_36_Highway_Billboard_Problem {
    public static int maxRevenue(int m, int[] x, int[] rev, int t) {
        int[] dp = new int[x.length];
        dp[0] = rev[0];
        int ans = 0;
        for (int i = 1; i < x.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int distance = x[i] - x[j];
                if (distance > t) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + rev[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    //
    public static void main(String[] args) {
        int m = 20;
        int[] x = new int[]{6, 7, 12, 13, 14};
        int[] revenue = new int[]{5, 6, 5, 3, 1};
        int n = x.length;
        int t = 5;
        System.out.println(maxRevenue(m, x, revenue, t));
    }
}
