package Day_21_Binary_Search_Tree_Part_II;

import java.util.Stack;

public class Binary_Search_Tree_Iterator {
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
    // https://leetcode.com/problems/binary-search-tree-iterator/submissions/
    // https://www.youtube.com/watch?v=D2jMcmxU4bs
    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }


        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
