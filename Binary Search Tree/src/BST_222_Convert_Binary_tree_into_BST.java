import java.util.*;

public class BST_222_Convert_Binary_tree_into_BST {
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

    // https://www.youtube.com/watch?v=8AnntMKIWlQ&t=305s
    // https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
    Node binaryTreeToBST(Node root) {
        ArrayList<Integer> arrayList = levelOrder(root);
        if (root == null)
            return null;
        Collections.sort(arrayList);
        convertToBst(root, arrayList);
        return root;
    }

    void convertToBst(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;
        convertToBst(root.left, al);
        root.data = al.get(0);
        al.remove(0);
        convertToBst(root.right, al);

    }

    ArrayList<Integer> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            arrayList.add(temp.data);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return arrayList;
    }
}
