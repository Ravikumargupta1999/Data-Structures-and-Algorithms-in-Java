public class Video_41_Maximum_Sum_of_3_Non_Overlapping_Subarrays {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] pSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0)
                pSum[i] = arr[i];
            else
                pSum[i] = arr[i] + pSum[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += arr[i];
                left[i] = sum;
            } else {
                sum += (arr[i] - arr[i - k]);
                left[i] = Math.max(left[i - 1], sum);
            }
        }

        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k >= n) {
                sum += arr[i];
                right[i] = sum;
            } else {
                sum += (arr[i] - arr[i + k]);
                right[i] = Math.max(right[i + 1], sum);
            }
        }

        int maxSum = 0;
        int lSum = 0;
        int spma = -1;
        int rSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int temp = left[i - 1] + right[i + k] + (pSum[i + k - 1] - pSum[i - 1]);
            if (temp > maxSum) {
                maxSum = temp;
                lSum = left[i - 1];
                rSum = right[i + k];
                spma = i;
            }
        }
        int[] ans = new int[3];
        ans[1] = spma;

        for (int i = k - 1; i < spma; i++) {
            if (pSum[i] - (i - k < 0 ? 0 : pSum[i - k]) == lSum) {
                ans[0] = i - k + 1;
                break;
            }
        }

        for (int i = spma + (2 * k) - 1; i < n; i++) {
            if (pSum[i] - pSum[i - k] == rSum) {
                ans[2] = i - k + 1;
                break;
            }
        }
        return ans;
    }
}
