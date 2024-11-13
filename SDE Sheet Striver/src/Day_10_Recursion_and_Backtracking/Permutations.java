package Day_10_Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // https://leetcode.com/problems/permutations/submissions/
    public List<List<Integer>> permute(int[] arr) {
        int n = arr.length;
        boolean[] flag = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        printPermutation(arr, 0, n, flag, temp, res);
        return res;
    }

    public void printPermutation( int[] arr, int used, int n, boolean[] flag, List<Integer> temp, List<List<Integer>> res) {
        if (used == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                temp.add(arr[i]);
                printPermutation(arr,used+1,n,flag,temp,res);
                temp.remove(temp.size()-1);
                flag[i] = false;
            }
        }
    }
}
