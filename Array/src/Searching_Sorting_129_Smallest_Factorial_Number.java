public class Searching_Sorting_129_Smallest_Factorial_Number {
    static int findNum(int n) {

        int l = 1;
        int h = 50000;
        int res = 0;
        while (l <= h) {
            int mid = (l + h) >> 1;
            if (trailingZeroes(mid) >= n) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        int p = 5;
        while ((n / p) > 0) {
            ans += (n / p);
            p = p * 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findNum(10000));
    }
}
