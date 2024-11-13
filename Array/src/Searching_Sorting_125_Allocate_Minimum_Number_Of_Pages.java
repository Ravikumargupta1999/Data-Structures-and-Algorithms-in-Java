public class Searching_Sorting_125_Allocate_Minimum_Number_Of_Pages {
    public static int findPages(int[] A, int n, int m) {

        int max = A[0];
        int sum = 0;
        for (int num : A) {

            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) {
            return sum;
        } else if (m == n) {
            return max;
        } else if (m > n) {
            return -1;
        }

        int start = max;
        int end = sum;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) >> 1;

            if (isPossible(A, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] A, int m, int mid) {
        int count = 1;
        int val = 0;

        for (int num : A) {
            val += num;
            if (val > mid) {
                count++;
                val = num;
            }
            if (count > num)
                return false;
        }
        return count <= m;
    }
}
