import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class Video_50_Minimum_Cost_to_Cut_a_Stick {
    int len = 0;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        len = n;
        int l = cuts.length;
        int[][] dp = new int[l + 1][l + 1];
        return rec(0, cuts.length, cuts, dp);
    }

    public int rec(int si, int ei, int[] cuts, int[][] dp) {
        if (si >= ei)
            return 0;
        if (dp[si][ei] != 0)
            return dp[si][ei];
        int ans = (int) 1e8;
        for (int cut = si; cut < ei; cut++) {
            int le = si == 0 ? 0 : cuts[si - 1];
            int re = ei == cuts.length ? len : cuts[ei];
            int cost = re - le;
            int left = rec(si, cut, cuts, dp);
            int right = rec(cut + 1, ei, cuts, dp);
            ans = Math.min(ans, left + cost + right);
        }
        return dp[si][ei] = ans;
    }
}
