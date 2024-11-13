package Day3;

public class Sqrt_x {
    // https://practice.geeksforgeeks.org/problems/square-root/1
    // https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long ans = 0;
        while (start <= end) {

            long mid = (start + end) / 2;
            // System.out.println(mid + "  " + x);
            if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                ans = mid;
                start = mid + 1;
            } else {
                return (int) mid;
            }
        }
        return (int) ans;

    }
}
