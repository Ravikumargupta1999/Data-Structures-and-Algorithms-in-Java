import java.util.ArrayList;
import java.util.HashMap;

public class BT_204_Largest_Sum_Subtree {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Without DP
    public static int largestSubtreeSum(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        solve(root, list);
        return list.get(0);
    }

    public static int solve(TreeNode<Integer> root, ArrayList<Integer> list) {
        if (root == null)
            return 0;
        int currentSum = root.data + solve(root.left, list) + solve(root.right, list);
        list.set(0, Math.max(list.get(0), currentSum));
        return currentSum;
    }


    // DP
    public static int largestSubtreeSum1(TreeNode<Integer> root) {
        if (root == null)
            return 0;
        HashMap<TreeNode<Integer>,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        getLargestSumSubTree(root, list,map);
        return list.get(0);
    }

    public static int getLargestSumSubTree(TreeNode<Integer> root, ArrayList<Integer> list,HashMap<TreeNode<Integer>,Integer> map) {
        if (root == null)
            return 0;
        if(map.containsKey(root)){
            return map.get(root);
        }
        int currentSum = root.data + getLargestSumSubTree(root.left, list,map) + getLargestSumSubTree(root.right, list,map);
        list.set(0, Math.max(list.get(0), currentSum));
        map.put(root,currentSum);
        return currentSum;
    }


}
