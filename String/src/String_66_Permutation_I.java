import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class String_66_Permutation_I {
    // Will not work for repeated character
    public static void main(String[] args) {
        System.out.println(new String_66_Permutation_I().find_permutation("ABC"));
    }

    public List<String> find_permutation(String s) {
        List<String> list = new ArrayList<>();
        getPermutation(0, s.toCharArray(), list);
        Collections.sort(list);
        return list;
    }

    public void getPermutation(int index, char[] arr, List<String> list) {

        if (index == arr.length) {
            String str = new String(arr);

            list.add(str);
            return;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getPermutation(index + 1, arr, list);
            swap(arr, index, i);
        }
    }

    public void swap(char[] arr, int l, int r) {
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutationOfArray(0, nums, res);
        return res;
    }

    public void permutationOfArray(int index, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums)
                temp.add(num);
            res.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swapIndex(nums, i, index);
            permutationOfArray(index + 1, nums, res);
            swapIndex(nums, i, index);
        }
    }

    public void swapIndex(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
