import java.util.ArrayList;
import java.util.List;

public class Video_50_Print_Permutations_using_Backtracking {
    // https://leetcode.com/problems/permutations/submissions/
    public void permutations(int[] arr, List<Integer> temp, List<List<Integer>> list, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(arr[i]);
                permutations(arr, temp, list, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        permutations(arr, temp, list, new boolean[arr.length]);
       return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new Video_50_Print_Permutations_using_Backtracking().permute(arr));
    }

}
