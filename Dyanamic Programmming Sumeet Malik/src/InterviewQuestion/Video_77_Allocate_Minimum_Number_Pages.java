package InterviewQuestion;

public class Video_77_Allocate_Minimum_Number_Pages {
    // https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
    public static int findPages(int[] arr, int n, int m) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : arr) {
            sum += val;
            max = Math.max(max, val);
        }
        if (m == n)
            return max;
        if (m == 1)
            return sum;

        int li = max;
        int hi = sum;
        int ans = 0;
        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (isPossible(arr, mid, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                li = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int mid, int m) {
        int st = 1;
        int sum = 0;
        for (int val : arr) {
            sum += val;
            if (sum > mid) {
                st++;
                sum = val;
            }
            if (st > m)
                return false;
        }
        return st <= m;
    }
}
