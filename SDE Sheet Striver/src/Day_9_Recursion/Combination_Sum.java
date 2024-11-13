package Day_9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        System.out.println(combinationSum(arr, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getSum(candidates, 0, target, temp, res);
        return res;
    }

    public static void getSum(int[] candidates, int index, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index == candidates.length || target < 0)
            return;
        int i = 1;
        while (i * candidates[index] <= target) {
            temp.add(candidates[index]);
            getSum(candidates, index + 1, target - (i * candidates[index]), temp, res);
            i++;
        }
        while (i-- > 1) {
            temp.remove(temp.size() - 1);
        }
        getSum(candidates, index + 1, target, temp, res);

    }
}
