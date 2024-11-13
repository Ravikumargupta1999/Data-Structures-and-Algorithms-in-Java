import java.util.Arrays;

//Test Cases Passed:
//        46 /  57
//
//        Time Limit Exceeded
//
//
//        Your program took more time than expected.Time Limit Exceeded
//        Expected Time Limit 1.23sec
//        Hint : Please optimize your code and submit again.
public class Backtracking_282_2_Partitioning_Into_K_Equal_Sum_Subsets {

    boolean flag;

    public boolean isKPartitionPossible(int[] arr, int n, int k) {
        Arrays.sort(arr);
        reverse(arr); // reverse kiya hai less no of recursion ho
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        if (k == 1) {
            return true;
        }
        if (k > n || sum % k != 0) {
            return false;
        }
        int[] size = new int[k];
        flag = false;
        checkIfPossible(arr, 0, n, k, new int[k], 0, size, sum);
        return flag;
    }

    public void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }

    public void checkIfPossible(int[] arr, int index, int n, int k, int[] subsetSum, int ssf, int[] size, int sum) {
        if (index == n) {
            if (ssf == k) {
                flag = true;
            }
            return;
        }
        for (int j = 0; j < k; j++) {
            if (size[j] > 0) {
                if (subsetSum[j] + arr[index] <= sum / k) {
                    subsetSum[j] += arr[index];
                    size[j]++;
                    checkIfPossible(arr, index + 1, n, k, subsetSum, ssf, size, sum);
                    subsetSum[j] -= arr[index];
                    size[j]--;
                    break;
                }

            } else {
                if (subsetSum[j] + arr[index] <= sum / k) {
                    subsetSum[j] += arr[index];
                    size[j]++;
                    checkIfPossible(arr, index + 1, n, k, subsetSum, ssf + 1, size, sum);
                    subsetSum[j] -= arr[index];
                    size[j]--;
                }
            }
        }
    }

    // Efficient Approach
    // https://www.youtube.com/watch?v=8t8TeyRJDvk&t=466s
    // https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (k > n || sum % k != 0)
            return false;
        // System.out.println("G");
        return canPartition(nums, new boolean[n], 0, k, 0, sum / k);
    }

    public static boolean canPartition(int[] arr, boolean[] visited, int index, int k, int curSum, int subsetSum) {
        if (k == 0)
            return true;
        if (curSum > subsetSum)
            return false;

        // if one  subset is completed start scanning for next subset with starting index
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

    public static void main(String[] args) {
        int[] arr = {4,3,2,3,5,2,1};
        System.out.println(canPartitionKSubsets(arr,4));
    }
}
