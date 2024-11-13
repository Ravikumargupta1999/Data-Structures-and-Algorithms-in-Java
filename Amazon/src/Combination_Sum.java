import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/combination-sum/submissions/
// Leetcode
public class Combination_Sum {
    public static List<List<Integer>> combinationSum(int[] a, int target) {
        ArrayList<Integer>  arr = new ArrayList<>();
        for(int i=0;i<a.length;i++)
            arr.add(a[i]);
        List<List<Integer>> al = new ArrayList<>();
        findCombination(0, arr, target, al, new ArrayList<>());
        Collections.sort(al, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for(int i=0;i<o1.size();i++)
                {
                    if(o1.get(i) != o2.get(i))
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
//    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
//        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
//        findCombination(0, arr, target, al, new ArrayList<>());
//        Collections.sort(al, new Comparator<ArrayList<Integer>>() {
//            @Override
//            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//                for(int i=0;i<o1.size();i++)
//                {
//                    if(o1.get(i) != o2.get(i))
//                        return o1.get(i) - o2.get(i);
//                }
//                return o1.get(0) - o2.get(0);
//            }
//        });
//        return al;
//    }
//
//    static void findCombination(int ind, ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> ans) {
//        if (ind == arr.size()) {
//            if (target == 0) {
//                ArrayList<Integer> temp = new ArrayList<>(ans);
//                Collections.sort(temp);
//                al.add(temp);
//            }
//            return;
//        }
//        if (arr.get(ind) <= target) {
//            ans.add(arr.get(ind));
//            findCombination(ind, arr, target - arr.get(ind), al, ans);
//            ans.remove(ans.size() - 1);
//        }
//        findCombination(ind + 1, arr, target, al, ans);
//    }

    public static void main(String[] args) {
        int[] al = {6,5,7,1,8,2,9,9,7,7,9};

        int sum = 6;
        List<List<Integer>> res = combinationSum(al, sum);
        System.out.println();
        if (res.size() == 0) {
            System.out.print("Empty");
        }

        // Print all combinations stored in res.
        for (int i = 0; i < res.size(); i++) {
            if (res.size() > 0) {
                System.out.print("(");
                List<Integer> ij = res.get(i);
                for (int j = 0; j < ij.size(); j++) {

                    System.out.print(ij.get(j));
                    if (j < ij.size() - 1)
                        System.out.print(" ");
                }
                System.out.print(")");
            }
        }
    }


}
