public class Video_3_Climbing_Stair_Case_With_Minimum_Jump {
    static int canReach(int[] arr, int n) {
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            if (arr[i] == 0)
                continue;
            for (int step = 1; step <= arr[i] && i + step < dp.length; step++) {
                if (dp[i + step] != null)
                    min = Math.min(min, dp[i + step]);
            }

            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }

        if (dp[0] == null)
            return 0; // can't reach
        else
            return 1; // can reach
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(canReach(arr, arr.length));
    }
}
