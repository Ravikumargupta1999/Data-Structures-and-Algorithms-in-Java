import java.util.ArrayList;
import java.util.Collections;

public class Backtracking_286_Combination_Sum {
    // https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1#
    // https://www.youtube.com/watch?v=OyZFFqQtu98
    public static void main(String[] args) {
        int[] arr = {8, 8, 1, 6, 8};

        // Array
        ArrayList<Integer> al = new ArrayList<>();
        for (int val : arr) {
            al.add(val);
        }
        System.out.println(combinationSum(al, 12));
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        Collections.sort(arr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int val : arr) {
            if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != val)
                arrayList.add(val);
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findCombinationSum(arrayList, 0, sum, new ArrayList<>(), res);
        Collections.sort(res, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                return a.get(i) - b.get(i);
            }
            return a.get(0) - b.get(0);
        });
        return res;
    }

    static void findCombinationSum(ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (index == arr.size()) {
            if (sum == 0)
                res.add(new ArrayList<>(temp));
            return;
        }
        if (arr.get(index) <= sum) {
            temp.add(arr.get(index));
            findCombinationSum(arr, index, sum - arr.get(index), temp, res);
            temp.remove(temp.size() - 1);
        }
        findCombinationSum(arr, index + 1, sum, temp, res);
    }

}
