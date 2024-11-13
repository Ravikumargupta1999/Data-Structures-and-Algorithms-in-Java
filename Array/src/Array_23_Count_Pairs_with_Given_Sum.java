import java.util.HashMap;
// Done
public class Array_23_Count_Pairs_with_Given_Sum {
    // https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
    // Duplicates allowed
    // Method 1
    // TC : O(n^2)
    // SC : O(1)
    int getPairsCount1(int[] arr, int n, int k) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == k)
                    count++;
            }
        }
        return count;
    }
    // Method 2
    // TC : O(n)
    // SC : O(n)
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int c = 0;
        for (int x : arr) {
            if (hm.containsKey(k - x))
                c += hm.get(k - x);
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        return c;
    }

    // https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int sum = nums[i];
            res[0] = i;
            for (; j < nums.length; j++) {
                if (sum + nums[j] == target) {
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
