import java.util.ArrayDeque;

public class Video_2_Print_all_Paths_with_Minimum_Jumps {
    // https://leetcode.com/problems/jump-game-ii/
    // https://www.youtube.com/watch?v=UagRoA3C5VQ&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG
    public int jump(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[nums.length];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < n; j++) {
                if (dp[i + j] != null && dp[i + j] < min)
                    min = dp[i + j];
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        return dp[0] != null ? dp[0] : 0;
    }

    static class Pair {
        int index;
        int s;
        int j;
        String psf;

        public Pair(int index, int s, int j, String psf) {
            this.index = index;
            this.j = j;
            this.s = s;
            this.psf = psf;
        }
    }

    public static void Solution(int nums[]) {
        int n = nums.length;
        Integer[] dp = new Integer[nums.length];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < n; j++) {
                if (dp[i + j] != null && dp[i + j] < min)
                    min = dp[i + j];
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        System.out.println(dp[0]);
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, nums[0], dp[0], 0 + ""));
        while (queue.size() > 0) {
            Pair rem = queue.removeFirst();
            if (rem.j == 0)
                System.out.println(rem.psf + " .");
            for (int j = 1; j <= rem.s && j + rem.index < nums.length; j++) {
                int ci = rem.index + j;
                if (dp[ci] != null && dp[ci] == rem.j - 1) {
                    queue.add(new Pair(j + rem.index, nums[ci], dp[ci], rem.psf + " -> " + ci));
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
