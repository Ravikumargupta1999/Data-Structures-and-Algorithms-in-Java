import java.util.ArrayList;
import java.util.List;

public class Backtracking_286_Combination_Sum_III {
    public static void main(String[] args) {
        int k = 2;
        int n = 18;
        System.out.println(new Backtracking_286_Combination_Sum_III().combinationSum3(k, n));
    }

    // https://leetcode.com/problems/combination-sum-iii/submissions/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(0, n, k, list, ans);
        return ans;
    }

    public void findCombination(int val, int n, int k, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        } else if (list.size() > k)
            return;
        for (int i = val + 1; i <= 9; i++) {
            list.add(i);
            findCombination(i, n - i, k, list, ans);
            list.remove(list.size() - 1);
        }
    }

}
