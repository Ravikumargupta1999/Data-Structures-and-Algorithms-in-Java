package Day3;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Path_Sum_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        getTotalPath(root, targetSum, list);
        return count;
    }

    public void getTotalPath(TreeNode node, long targetSum, ArrayList<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        long sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i);
            if (sum == targetSum)
                count++;
        }
        getTotalPath(node.left, targetSum, list);
        getTotalPath(node.right, targetSum, list);
        list.remove(list.size() - 1);
    }

}
