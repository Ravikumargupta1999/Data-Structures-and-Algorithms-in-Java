public class Video_23_Split_Array_Largest_Sum {
    //https://leetcode.com/problems/split-array-largest-sum/submissions/
    public int splitArray(int[] pages, int m) {
        int n = pages.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : pages) {
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
            if (isPossible(pages, mid, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                li = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int mid, int m) {
        int pg = 1;
        int sum = 0;
        for (int val : arr) {
            sum += val;
            if (sum > mid) {
                pg++;
                sum = val;
            }
            if (pg > m)
                return false;
        }
        return pg <= m;
    }
}
