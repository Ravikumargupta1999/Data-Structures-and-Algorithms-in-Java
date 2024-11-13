package Day_18_Binary_Tree_Part_II;

import java.util.*;

public class Zigzag_Level_Order_Traversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (queue.size()>0){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            while (size-- > 0){
                TreeNode rem = queue.poll();
                temp.add(rem.val);
                if(rem.left != null)
                    queue.add(rem.left);
                if (rem.right != null)
                    queue.add(rem.right);
            }
            if(!flag)
                Collections.reverse(temp);
            list.add(temp);
            flag = !flag;
        }
        return list;
    }
}
