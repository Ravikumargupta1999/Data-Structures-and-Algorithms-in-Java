public class Binary_Tree_Maximum_Path_Sum_Between_Leaf_nodes {
    class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    class Res {
        int val;
    }
    Node root;
    Node setTree(Node root){

        Node temp = new Node(0);
        if(root.right==null){
            root.right=temp;
        }
        else{
            root.left=temp;
        }

        return root;
    }

    int maxPathSum(Node root)
    {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        if(root.left==null || root.right==null){
            root=setTree(root);
        }
        maxPathSumUtil(root, res);
        return res.val;

    }
    int maxPathSumUtil(Node node, Res res) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);
        if (node.left != null && node.right != null) {
            res.val = Math.max(res.val, ls + rs + node.data);
            return Math.max(ls, rs) + node.data;
        }
        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }
}
