public class Video_16_Non_Intersecting_Chords_in_a_Circle {
    // https://www.geeksforgeeks.org/count-ways-divide-circle-using-n-non-intersecting-chords/
    static long chordCnt(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {

                dp[i] += dp[l] * dp[r];
                l++;
                r--;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(chordCnt(5));
    }
}
