public class Maximum_Average_Subarray {
    int findMaxAverage(int[] arr, int n, int k) {
        // code here
        int max = Integer.MIN_VALUE;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            if (i >= k - 1)
                break;
            sum += arr[i];
        }
        int i = 0;
        int j = k - 1;
        while (j < n) {
            sum += arr[j];
            j++;
            if (sum  > max) {
                max = sum;
                start = i;
            }
            sum -= arr[i];
            i++;
        }
        return start;
    }
}
