import java.util.ArrayList;

public class Video_54_Partition_to_K_Equal_Sum_Subsets {
    // Time Limit Exceed
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int val : nums)
            sum += val;
        if (k > nums.length || sum % k != 0) {
            return false;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(nums, 0, nums.length, k, 0, ans);
        return count > 0 ? true : false;
    }

    int count = 0;

    public void solution(int[] arr, int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i >= n) {
            if (rssf == k) {
                if (isValid(ans, k)) {
                    count++;
                }
            }
            return;
        }
        int val = arr[i];
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(val);
                solution(arr, i + 1, n, k, rssf, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(val);
                solution(arr, i + 1, n, k, rssf + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static boolean isValid(ArrayList<ArrayList<Integer>> arrayLists, int k) {
        ArrayList<Integer> temp = arrayLists.get(0);
        int sum = 0;
        for (int val : temp)
            sum += val;
        for (int j = 1; j < arrayLists.size(); j++) {
            ArrayList<Integer> temp1 = arrayLists.get(j);
            int sum1 = 0;
            for (int val : temp1)
                sum1 += val;
            if (sum1 != sum)
                return false;
        }
        return true;
    }
}
