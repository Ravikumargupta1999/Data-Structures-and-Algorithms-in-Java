//https://www.youtube.com/watch?v=OodoQ95se20
//https://practice.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1/?company[]=Facebook&company[]=Facebook&difficulty[]=1&page=1&query=company[]Facebookdifficulty[]1page1company[]Facebook
public class Largest_Sum_Subarray_of_Size_at_least_K {
    public long maxSumWithK(long arr[], long n, long k) {
        long ans = Long.MIN_VALUE;
        long[] maxSum = new long[(int) n];
        long cSum = arr[0];
        maxSum[0] = cSum;
        for (long i = 1; i < arr.length; i++) {
            if (cSum > 0)
                cSum += arr[(int) i];
            else
                cSum = arr[(int) i];
            maxSum[(int) i] = cSum;
        }

        long exactK = 0;
        for (long i = 0; i < k; i++)
            exactK += arr[(int) i];
        if (exactK > ans)
            ans = exactK;
        for (long i = k; i < arr.length; i++) {
            exactK = exactK + arr[(int) i] - arr[(int) (i - k)];
            if (exactK > ans)
                ans = exactK;
            long moreThanK = exactK + maxSum[(int) (i - k)];
            if (moreThanK > ans)
                ans = moreThanK;
        }
        return ans;
    }
}
