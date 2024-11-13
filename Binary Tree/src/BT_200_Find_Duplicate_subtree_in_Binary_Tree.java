import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BT_200_Find_Duplicate_subtree_in_Binary_Tree {
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
    HashMap<String,Integer> hm = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    String solve(TreeNode root)
    {
        if(root == null)
            return "$";
        String s = "";
        s = Integer.toString(root.val) +" "+solve(root.left) + " "+ solve(root.right); // adding space is important
        hm.put(s,hm.getOrDefault(s,0)+1);
        if(hm.get(s) == 2 )
            ans.add(root);
        return s;
    }
}
