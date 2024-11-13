package One;
// https://leetcode.com/problems/subsets/submissions/
import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        subsetFunction(0, arr, ans, list);
        return list;
    }

    public void subsetFunction(int index, int[] arr, List<Integer> ans, List<List<Integer>> list) {
        if (index == arr.length) {
//            list.add(ans);
            list.add(new ArrayList<>(ans));
            return;
        }
        System.out.println(arr[index] + " " + list + "  " + ans);
        ans.add(arr[index]);
        subsetFunction(index + 1, arr, ans, list);
        ans.remove(ans.size() - 1);
        subsetFunction(index + 1, arr, ans, list);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Subsets().subsets(arr));
    }
}
