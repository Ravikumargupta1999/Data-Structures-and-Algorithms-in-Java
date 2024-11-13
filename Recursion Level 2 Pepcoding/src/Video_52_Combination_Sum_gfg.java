import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Video_52_Combination_Sum_gfg {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
        Collections.sort(arr);  // Sort the array

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) // Remove duplicates
        {
            if (arr.get(i) != arr.get(i - 1))
                arrayList.add(arr.get(i));
        }

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        findCombination(0, arrayList, target, al, new ArrayList<>());
        Collections.sort(al, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });
        return al;
    }

    static void findCombination(int ind, ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> ans) {
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

    public static void main(String[] args) {

        int[] arr = {8, 1, 8, 6, 8};
        int target = 12;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            al.add(arr[i]);
        System.out.println(combinationSum(al, target));
    }
}
