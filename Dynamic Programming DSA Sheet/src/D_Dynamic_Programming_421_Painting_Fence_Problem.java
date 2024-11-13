public class D_Dynamic_Programming_421_Painting_Fence_Problem {
    // https://www.youtube.com/watch?v=ju8vrEAsa3Q
    // https://practice.geeksforgeeks.org/problems/painting-the-fence3727/0?problemType=functional&difficulty%5B%5D=1&page=5&sortBy=submissions&query=problemTypefunctionaldifficulty%5B%5D1page5sortBysubmissions
    public static long countWays(int n, int k) {
        if (n == 1)
            return k;
        int p = 1000000007;
        long same = k * 1;
        long different = k * (k - 1);
        long total = same + different;
        for (int i = 3; i <= n; i++) {
            same = (different * 1) % p;
            different = ((total % p) * ((k - 1) % p)) % p;
            total = (same % p + different % p) % p;
        }
        return total;
    }
}
