import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/submissions/
public class Binary_Tree_Right_Side_View {


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


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {

            int size = queue.size();
            int val = 0;
            while (size-- > 0) {
                TreeNode rem = queue.poll();
                if (rem.left != null)
                    queue.add(rem.left);
                if (rem.right != null)
                    queue.add(rem.right);
                val = rem.val;
            }
            list.add(val);
        }
        return list;
    }
}