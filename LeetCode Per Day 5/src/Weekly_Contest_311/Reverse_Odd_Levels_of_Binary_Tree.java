package Weekly_Contest_311;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_Odd_Levels_of_Binary_Tree {
    public static class TreeNode {
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

    public static TreeNode reverseOddLevels(TreeNode root) {

        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                list.add(temp);

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            if (level % 2 != 0) {
                reverse(list);
            }
            level++;
        }
        return root;
    }

    public static void reverse(List<TreeNode> list) {
        ArrayList<Integer> l1 = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            l1.add(list.get(i).val);
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = l1.get(i);
        }
    }

    public static ArrayList<Integer> levelOrder(TreeNode root){
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> list = new ArrayList<>();

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(5);

        node.left.left = new TreeNode(8);
        node.right.left = new TreeNode(21);

        node.left.right = new TreeNode(13);
        node.right.right = new TreeNode(34);

        levelOrder(node);
        levelOrder(reverseOddLevels(node));
    }
}
