public class BT_211_Isomorphic_Tree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1#
    boolean isIsomorphic(Node root1, Node root2)
    {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data != root2.data)
            return false;

        // a = Ya to dono ka tree1 ka left  tree2  ka left and tree1 ka right tree2 ke right equal hona chahiye
        //  b = ya phir dono ka left1 right2 and right1 && right2 euqal hone chahiye
        boolean a = isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right);
        boolean b = isIsomorphic(root1.left,root2.right) && isIsomorphic(root1.right,root2.left);
        return a||b;

    }
}
