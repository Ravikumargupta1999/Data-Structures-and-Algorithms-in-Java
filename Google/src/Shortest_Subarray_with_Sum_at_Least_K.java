public class Shortest_Subarray_with_Sum_at_Least_K {
    public int shortestSubarray(int[] arr, int k) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int[] maxSum = new int[n];
        int cSum = arr[0];
        maxSum[0] = cSum;
        for (int i = 1; i < arr.length; i++) {
            if (cSum > 0)
                cSum += arr[i];
            else
                cSum = arr[i];
            maxSum[i] = cSum;
        }

        int exactK = 0;
        for (int i = 0; i < k; i++)
            exactK += arr[i];
        if (exactK > ans)
            ans = exactK;
        for (int i = k; i < arr.length; i++) {
            exactK = exactK + arr[i] - arr[(i - k)];
            if (exactK > ans)
                ans = exactK;
            int moreThanK = exactK + maxSum[(i - k)];
            if (moreThanK > ans)
                ans = moreThanK;
        }
        return ans;
    }
}
