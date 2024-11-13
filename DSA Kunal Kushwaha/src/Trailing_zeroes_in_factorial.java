public class Trailing_zeroes_in_factorial {
    //https://leetcode.com/problems/factorial-trailing-zeroes/
    //https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1#
    static int trailingZeroes(int n) {
        int ans = 0;
        int p = 5;
        while ((n / p) > 0) {
            ans += (n / p);
            p = p * 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
}
