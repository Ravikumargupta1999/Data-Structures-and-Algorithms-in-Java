package Day_11_Binary_Search;

public class Nth_Root_Of_Integer {
    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        int ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.pow(mid, n) <= m) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
