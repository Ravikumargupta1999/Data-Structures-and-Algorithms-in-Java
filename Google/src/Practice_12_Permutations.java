import java.util.ArrayList;
import java.util.List;


public class Practice_12_Permutations {

    // https://leetcode.com/problems/permutations/

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> al = new ArrayList<>();
        permutation(arr, 0, al);
        return al;
    }

    void permutation(int[] arr, int index, List<List<Integer>> ans) {
        if (index == arr.length - 1) {
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                al.add(arr[i]);
            ans.add(al);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(i, index, arr);
            permutation(arr, index + 1, ans);
            swap(i, index, arr);
        }
    }

    void swap(int l, int r, int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
