import java.util.*;

public class Backtracking_286_Combination_Sum_I {
    // https://leetcode.com/problems/combination-sum/
    // https://www.youtube.com/watch?v=OyZFFqQtu98
    public List<List<Integer>> combinationSum(int[] a, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            arr.add(a[i]);
        List<List<Integer>> al = new ArrayList<>();
        findCombination(0, arr, target, al, new ArrayList<>());
        Collections.sort(al, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });
        return al;
    }

    static void findCombination(int ind, ArrayList<Integer> arr, int target, List<List<Integer>> al, ArrayList<Integer> ans) {
        if (ind == arr.size()) {
            if (target == 0) {
                ArrayList<Integer> temp = new ArrayList<>(ans);
                Collections.sort(temp);
                al.add(temp);
            }
            return;
        }
        if (arr.get(ind) <= target) {
            ans.add(arr.get(ind));
            findCombination(ind, arr, target - arr.get(ind), al, ans);
            ans.remove(ans.size() - 1);
        }
        findCombination(ind + 1, arr, target, al, ans);

    }
}
