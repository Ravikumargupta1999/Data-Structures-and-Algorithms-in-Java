import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BT_206_Print_all_k_sum_paths_in_a_binary_tree {
    static class Node {
        int data;
        Node left, right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    // Solution 1
    // Love Babbar
    public int sumK(Node root, int k) {
        if (root == null) return 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        solve(root, new ArrayList<>(), k, ans);
        return ans.get(0);
    }

    public void solve(Node root, ArrayList<Integer> al, int k, ArrayList<Integer> ans) {
        if (root == null)
            return;
        al.add(root.data);
        solve(root.left, al, k, ans);
        solve(root.right, al, k, ans);
        printSum(al, k, ans);
        al.remove(al.size() - 1);

    }

    public void printSum(ArrayList<Integer> arrayList, int k, ArrayList<Integer> ans) {
        int sum = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            sum += arrayList.get(i);
            if (sum == k)
                ans.set(0, ans.get(0) + 1);
        }
    }

    // Solution 2
    static int count = 0;

    public int sumK2(Node root, int k) {
        count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        dfs(root, k, mp, 0);
        return count;
    }

    public void dfs(Node root, int k, Map<Integer, Integer> mp, int sum) {
        if (root == null)
            return;
        sum += root.data;
        if (mp.containsKey(sum - k)) {
            int n = mp.get(sum - k);
            count += n;
        }
        mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        dfs(root.left, k, mp, sum);
        dfs(root.right, k, mp, sum);
        mp.put(sum, mp.get(sum) - 1);
    }


}
//    Root of below binary tree:
//                   1
//                  / \
//                /    \
//               /      \
//              /        \
//              3        -1
//             / \      /   \
//            2   1    4     5
//                /   / \     \
//               1   1   2     6