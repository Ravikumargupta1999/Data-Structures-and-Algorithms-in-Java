import java.util.ArrayList;
import java.util.Stack;

public class BST_223_Normal_BST_to_Balanced_BST {
    class Node {
        int data;
        Node right, left;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1/#
    Node buildBalancedTree(Node root) {
        ArrayList<Integer> arrayList = inorder(root);
        return convertToBalancedBST(arrayList,0,arrayList.size()-1);
    }
    Node convertToBalancedBST(ArrayList<Integer> arrayList,int l,int r)
    {
        if(l > r)
            return null;
        if( l == r)
            return new Node(arrayList.get(l));
        int mid = l + (r-l)/2;
        Node newNode = new Node(arrayList.get(mid));
        newNode.left = convertToBalancedBST(arrayList,l,mid-1);
        newNode.right = convertToBalancedBST(arrayList,mid+1,r);
        return newNode;
    }
    ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                al.add(root.data);
                root = root.right;
            }
        }
        return al;
    }
}

