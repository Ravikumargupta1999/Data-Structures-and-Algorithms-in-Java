public class Searching_Sorting_104_Square_Root_Of_A_Numbe {
    // https://practice.geeksforgeeks.org/problems/count-squares3649/1#
    public static int SquareRoot(int n) {
        int a = (int) Math.sqrt(n);
        if (a * a == n)
            return a - 1;
        else
            return a;
    }

    // https://practice.geeksforgeeks.org/problems/square-root/0/?problemStatus=unsolved&page=1&query=problemStatusunsolvedpage1
    long floorSqrt(long x) {
        long end = x;
        long start = 1;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid == x)
                return mid;
            if (mid * mid < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}

