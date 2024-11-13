public class Video_32_Maximum_Sum_Subarray_With_At_Least_Size_K {
    // https://www.youtube.com/watch?v=OodoQ95se20&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=47
    // https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
    public long maxSumWithK(long[] arr, long n, long k) {

        long[] maxSum = new long[(int) n];
        maxSum[0] = arr[0];
        long currSum = arr[0];

        for (long i = 1; i < n; i++) {
            if (currSum > 0)
                currSum += arr[(int) i];
            else
                currSum = arr[(int) i];
            maxSum[(int) i] = currSum;
        }


        long ans = Integer.MIN_VALUE;
        long exactK = 0;
        for (long i = 0; i < k; i++)
            exactK += arr[(int) i];

        ans = Math.max(ans, exactK);

        for (long i = k; i < n; i++) {
            exactK += arr[(int) i] - arr[(int) (i - k)];
            ans = Math.max(ans, exactK);

            long moreThanK = exactK + maxSum[(int) (i - k)];

            ans = Math.max(ans, moreThanK);
        }

        return ans;
    }
}
