public class Video_24_Capacity_To_Ship_Packages_Within_D_Days {
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    // https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days-1641193159/1/
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : weights) {
            sum += val;
            max = Math.max(max, val);
        }
        if (days == n)
            return max;
        if (days == 1)
            return sum;

        int li = max;
        int hi = sum;
        int ans = 0;
        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (isPossible(weights, mid, days)){
                ans = mid;
                hi = mid - 1;
            } else {
                li = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int mid, int days) {
        int day = 1;
        int sum = 0;
        for (int val : arr) {
            sum += val;
            if (sum > mid) {
                day++;
                sum = val;
            }
            if (day > days)
                return false;
        }
        return day <= days;

    }
}
