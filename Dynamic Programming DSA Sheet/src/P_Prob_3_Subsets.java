import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://practice.geeksforgeeks.org/problems/subsets-1613027340/1/#
public class P_Prob_3_Subsets {
    static void helper(int[] A, int curr, int n, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (curr == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(A[curr]);
        helper(A, curr + 1, n, temp, res);
        temp.remove(temp.size() - 1);
        helper(A, curr + 1, n, temp, res);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        int[] A = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            A[i] = arr.get(i);
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(A, 0, A.length, new ArrayList<>(), res);
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.size() - o2.size();
            }
        });
        return res;
    }

}
