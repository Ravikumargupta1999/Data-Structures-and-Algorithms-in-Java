import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Video_52_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, temp, list);
        return list;
    }

    public void findCombination(int idx, int[] arr, int tar, List<Integer> temp, List<List<Integer>> list) {
        if (tar == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
//        System.out.println(temp + "  " + list);
        if (tar < 0 || idx == arr.length)
            return;

        for (int j = tar / arr[idx]; j >= 1; j--) {
            for (int i = 0; i < j; i++) {
                temp.add(arr[idx]);
            }
            findCombination(idx + 1, arr, tar - arr[idx]*j, temp, list);
            for (int i = 0; i < j; i++) {
                temp.remove(temp.size()-1);
            }
        }
        findCombination(idx + 1, arr, tar, temp, list);
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 5};
//        System.out.println(new Video_52_Combination_Sum_gfg().combinationSum(arr, 8));
    }
}
