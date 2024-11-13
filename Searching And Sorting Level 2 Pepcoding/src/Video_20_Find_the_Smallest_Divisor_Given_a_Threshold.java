public class Video_20_Find_the_Smallest_Divisor_Given_a_Threshold {
    //https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
    public int smallestDivisor(int[] arr, int threshold) {
        int max = arr[0];
        for (int val : arr)
            max = Math.max(max, val);
        if (threshold == arr.length)
            return max;
        int lo = 1;
        int hi = max;
        int divisor = Integer.MAX_VALUE;
        while (lo <= hi) {
            int div = lo + (hi - lo) / 2;
            if (isPossible(arr, div, threshold)) {
                divisor = div;
                hi = div - 1;
            } else {
                lo = div + 1;
            }
        }
        return divisor;
    }

    public boolean isPossible(int[] arr, int div, int threshold) {
        int ans = 0;
        for (int val : arr) {
            if (val % div == 0)
                ans += (val / div);
            else
                ans += (val / div) + 1;
        }
        if (ans <= threshold)
            return true;
        return false;
    }
}
