import java.util.*;

public class Backtracking_286_Combination_Sum_II {
    // https://leetcode.com/problems/combination-sum-ii/submissions/
    // https://www.youtube.com/watch?v=G1fRTGRxXU8
    public List<List<Integer>> combinationSum2(int[] arr, int sum) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        findCombinationSum(arr, 0, sum, new ArrayList<>(), res);
        return res;
    }

    static void findCombinationSum(int[] arr, int index, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > sum)
                break;
            temp.add(arr[i]);
            findCombinationSum(arr, i + 1, sum - arr[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
