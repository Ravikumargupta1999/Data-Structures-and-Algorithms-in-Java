package Day_9_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printSubset(nums, 0, temp, res);
        return res;
    }

    public void printSubset(int[] nums, int index, List<Integer> al, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(al));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            al.add(nums[i]);
            printSubset(nums, index + 1, al, ans);
            al.remove(al.size() - 1);
        }
    }
}
