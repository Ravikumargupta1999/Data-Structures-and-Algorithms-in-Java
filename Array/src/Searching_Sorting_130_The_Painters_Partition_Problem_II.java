public class Searching_Sorting_130_The_Painters_Partition_Problem_II {


    // https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1


    static long minTime(int[] arr, int n, int k) {

        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int val : arr) {
            sum += val;
            max = Math.max(max, val);
        }
        if (k == n)
            return max;
        if (k == 1)
            return sum;

        long li = max;
        long hi = sum;
        long ans = 0;
        while (li <= hi) {
            long mid = li + (hi - li) / 2;
            if (isPossible(arr, mid, k)) {
                ans = mid;
                hi = mid - 1;
            } else {
                li = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] arr, long mid, int availablePainters) {
        int totalPainters = 1;
        long sum = 0;
        for (int val : arr) {
            sum += val;
            if (sum > mid) {
                totalPainters++;
                sum = val;
            }
            if (totalPainters > availablePainters)
                return false;
        }
        return totalPainters <= availablePainters;
    }
}
