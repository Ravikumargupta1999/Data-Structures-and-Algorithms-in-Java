import java.util.*;

public class Combination_Sum_GfG {
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        findCombination(0, arr, target, al, new ArrayList<>());
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < al.size(); i++)
            set.add(al.get(i));
        al.removeAll(al);
        Iterator<ArrayList<Integer>> it = set.iterator();
        while (it.hasNext()) {
            al.add(it.next());
        }
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
//        5
//        8 1 8 6 8
//        12
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 12;
        list.add(8);
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(8);
        ArrayList<ArrayList<Integer>> res = combinationSum(list, sum);
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
                    if(j < ij.size()-1)
                        System.out.print(" ");
                }
                System.out.print(")");
            }
        }
    }

}
