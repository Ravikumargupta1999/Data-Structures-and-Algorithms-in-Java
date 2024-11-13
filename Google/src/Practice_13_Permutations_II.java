import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/submissions/
public class Practice_13_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(nums.length, temp, res, map);
        return res;
    }

    public void permute(int n, List<Integer> temp, List<List<Integer>> res, HashMap<Integer, Integer> map) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                map.put(key,map.get(key)-1);
                temp.add(key);
                permute(n, temp, res, map);
                temp.remove(temp.size() - 1);
                map.put(key,map.get(key)+1);
            }
        }
    }
}
