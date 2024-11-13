import java.util.*;

public class Backtracking_286_Combination_Sum_IV {
    // https://leetcode.com/problems/combination-sum-iv/submissions/906989071/
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 4;
        System.out.println(new Backtracking_286_Combination_Sum_IV().combinationSum43(arr, target));
    }

    // Method - 1
    public int combinationSum4(int[] a, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            arr.add(a[i]);
        findCombination(arr, target);
        return count;
    }

    int count = 0;

    void findCombination(ArrayList<Integer> arr, int target) {
        if (target == 0) {
            count++;
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (target - arr.get(i) >= 0) {
                findCombination(arr, target - arr.get(i));
            }
        }
    }

    // Method - 2
    public int combinationSum43(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int num : nums) {

                if (i - num >= 0) {

                    dp[i] = dp[i] + dp[i-num];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];

    }
}
