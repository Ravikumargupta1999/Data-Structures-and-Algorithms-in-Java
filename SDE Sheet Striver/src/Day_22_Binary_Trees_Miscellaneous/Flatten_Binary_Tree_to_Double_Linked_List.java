package Day_22_Binary_Trees_Miscellaneous;

public class Flatten_Binary_Tree_to_Double_Linked_List {
    class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }

    }

    int f = 0;
    Node head = null;
    Node prev = null;

    Node bToDLL(Node root) {
        if (root == null)
            return null;
        solve(root);
        return head;
    }

    void solve(Node root) {
        if (root == null)
            return;
        solve(root.left);
        if (f == 0) {
            f = 1;
            prev = root;
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = prev.right;
        }
        solve(root.right);
    }
}
