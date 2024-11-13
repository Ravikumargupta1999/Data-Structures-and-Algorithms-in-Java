public class Squares_In_Rectangle {
    static int mod = (int) 1e9 + 7;

    static int minSquares(long L, long B) {
        // code here
        return (int) (solve(L, B) % mod);

    }

    static long solve(long L, long B) {
        if (L == B)
            return 1;
        if (B == 0 || L == 0)
            return 0;
        if (L == 1 || B == 1)
            return Math.max(L, B);
        if (L > B)
            return solve(B, L);

        return B / L + solve(L, B % L) % mod;
    }
}
