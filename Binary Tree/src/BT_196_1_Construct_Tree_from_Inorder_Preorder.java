import java.util.ArrayList;
import java.util.Stack;
// done
public class BT_196_1_Construct_Tree_from_Inorder_Preorder {
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode constructTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei)
            return null;

        TreeNode node = new TreeNode(preorder[psi]);
        int idx = isi;
        while (inorder[idx] != preorder[psi])
            idx++;
        int count = idx - isi;

        node.left = constructTree(preorder, psi + 1, psi + count, inorder, isi, idx - 1);
        node.right = constructTree(preorder, psi + count + 1, pei, inorder, idx + 1, iei);
        return node;
    }


    // https://practice.geeksforgeeks.org/problems/construct-tree-1/1#
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        return constructTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static Node constructTreeNode(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei)
            return null;

        Node node = new Node(preorder[psi]);
        int idx = isi;
        while (inorder[idx] != preorder[psi])
            idx++;
        int count = idx - isi;

        node.left = constructTreeNode(preorder, psi + 1, psi + count, inorder, isi, idx - 1);
        node.right = constructTreeNode(preorder, psi + count + 1, pei, inorder, idx + 1, iei);
        return node;
    }
    static ArrayList<Integer> iterative_Postorder(Node root) {

        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Stack<Node> st = new Stack<>();
        st.push(root);
        Stack<Node> out = new Stack<>();

        while (!st.isEmpty())
        {
            root = st.pop();
            out.push(root);
            if(root.left != null)
            {
                st.push(root.left);
            }
            if(root.right != null)
            {
                st.push(root.right);
            }

        }
        while (!out.isEmpty())
        {
            root = out.pop();
            al.add(root.data);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] in = {9,2,4,6,8,7,3,1,5,10};
        int[] pr = {8,2,9,6,4,1,3,7,5,10};
        System.out.println(iterative_Postorder(buildTree(in,pr,in.length)));

    }
}
