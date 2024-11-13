import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Serialize_and_Deserialize_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node == null)
            {
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i=1;i<values.length;i++)
        {
            TreeNode parent = queue.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
