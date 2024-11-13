package InterviewQuestion;

import java.util.HashSet;

public class Video_95_Find_A_Pair_With_Target_In_BST {
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
    public int isPairPresent(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return findPair(root, target, set) ? 1 : 0;
    }

    public boolean findPair(Node root, int target, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(target - root.data))
            return true;
        set.add(root.data);
        if (findPair(root.left, target, set))
            return true;
        return findPair(root.right, target, set);
    }
    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/
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
    public boolean findTarget(TreeNode root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return findPair(root,target,set) ;
    }
    public boolean findPair(TreeNode root,int target,HashSet<Integer>set){
        if(root == null)
            return false;
        if(set.contains(target-root.val))
            return true;
        set.add(root.val);
        if(findPair(root.left,target,set))
            return true;
        return findPair(root.right,target,set);
    }
}
