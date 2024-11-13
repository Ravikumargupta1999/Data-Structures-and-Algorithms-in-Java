public class D_Dynamic_Programming_413_Permutation_Coefficient_Problem {
    // https://www.geeksforgeeks.org/permutation-coefficient/
    // https://www.youtube.com/watch?v=Ebj83h76VUU

    // TC : O(n)
    // SC : O(n)
    static int permutationCoefficient(int n, int k) {
        int[] DP = new int[n + 1];
        DP[0] = 1;
        for (int i = 1; i <= n; i++) {
            DP[i] = i * DP[i - 1];
        }
        return DP[n] / DP[n - k];
    }

    // TC : O(n)
    // SC : O(1)
    public static int permutationCoefficient1(int n, int k) {
        int mod = 1000000007;
        int prod = 1;

        for (int i = 0; i < k; i++) {
            prod = ((prod % mod) * ((n - i) % mod)) % mod;
        }
        return prod;

    }


//    Time Complexity : O(N * K)
//    Space Complexity : O(N * K)
//
//    Where 'N' and 'K' are the number given numbers.

    public static int moduli = 1000000007;

    public static int P(int n, int k) {
        // Intial value for auxulary matrix is 0.
        long[][] p = new long[n + 1][k + 1];

        // 'P[X][0]' = 1 for all values of 'X'.
        for (int i = 0; i <= n; i++) {
            p[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                p[i][j] = p[i - 1][j] + (j * p[i - 1][j - 1]);
                p[i][j] %= moduli;
            }
        }

        return (int) p[n][k];
    }
}

