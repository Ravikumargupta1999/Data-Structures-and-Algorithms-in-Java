import java.util.Stack;

public class BST_226_Kth_Smallest_Element_In_BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1

    // Method - 1

    public int KthSmallestElement(Node root, int k) {
        int i = 1;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (i == k) {
                    return root.data;
                } else
                    i++;
                root = root.right;
            }
        }
        return -1;
    }

    // Method -2

    int ans ;
    int count = 1;
    public int KthSmallestElement1(Node root, int k)
    {
        int count =0;
        ans = -1;
        solve(root,k);
        return ans;
    }
    void solve(Node root,int k)
    {
        if(root == null)
            return;
        solve(root.left,k);
        if(k == count)
        {
            ans = root.data;
            count++;
            return;
        }
        else
            count++;
        solve(root.right,k);
    }

}
