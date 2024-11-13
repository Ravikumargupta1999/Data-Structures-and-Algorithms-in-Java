package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
//    https://leetcode.com/problems/combination-sum-iii/submissions/868437164/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[10];

        recursion(0, k, n, 0, al, res, visited);

        return res;
    }

    public static void recursion(int num, int k, int n, int sum, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (n == sum && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        } else if (sum >= n || list.size() >= k)
            return;

        for (int i = num + 1; i < 10; i++) {
            System.out.print(i+"  ");
            if (!visited[i]) {

                visited[i] = true;
                list.add(i);
                recursion(i, k, n, sum + i, list, res, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }

        }
    }
}
