package Day_9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        for (int i = index; i < candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i-1])
                continue;
            temp.add(candidates[i]);
            getSum(candidates,i+1,target-candidates[i],temp,res);
            temp.remove(temp.size()-1);
        }
        getSum(candidates, index + 1, target, temp, res);
    }
}
