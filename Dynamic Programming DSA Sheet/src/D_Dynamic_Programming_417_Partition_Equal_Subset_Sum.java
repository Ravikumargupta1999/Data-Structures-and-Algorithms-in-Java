public class D_Dynamic_Programming_417_Partition_Equal_Subset_Sum {
    // https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
    // https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1
    static int equalPartition(int n, int nums[]) {
        int k = 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (k > n || sum % k != 0)
            return 0;
        return canPartition(nums, new boolean[n], 0, k, 0, sum / k) ? 1 : 0;
    }

    public static boolean canPartition(int[] arr, boolean[] visited, int index, int k, int curSum, int subsetSum) {
        if (k == 0)
            return true;
        if (curSum > subsetSum)
            return false;
        if (curSum == subsetSum)
            return canPartition(arr, visited, 0, k - 1, 0, subsetSum);

        for (int i = index; i < arr.length; i++) {
            if (visited[i] || curSum + arr[i] > subsetSum)
                continue;
            visited[i] = true;
            if (canPartition(arr, visited, i + 1, k, curSum + arr[i], subsetSum))
                return true;
            visited[i] = false;
        }
        return false;
    }
}
