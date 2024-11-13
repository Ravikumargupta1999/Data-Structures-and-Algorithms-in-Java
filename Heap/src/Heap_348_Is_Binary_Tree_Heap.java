public class Heap_348_Is_Binary_Tree_Heap {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }


    boolean isHeap1(Node root) {
        if (root == null)
            return true;
        int node_count = countNodes(root);

        if (isCompleteUtil(root, 0, node_count) && isHeapUtil(root))
            return true;
        return false;
    }

    int countNodes(Node root) {
        if (root == null)
            return 0;
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    boolean isCompleteUtil(Node root, int index, int number_nodes) {
        if (root == null)
            return true;
        if (index >= number_nodes)
            return false;
        return isCompleteUtil(root.left, 2 * index + 1, number_nodes) && isCompleteUtil(root.right, 2 * index + 2, number_nodes);
    }

    boolean isHeapUtil(Node root) {
        if (root.left == null && root.right == null)
            return true;
        if (root.right == null) {
            return root.data >= root.left.data;
        } else {
            if (root.data >= root.left.data && root.data >= root.right.data)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }

    boolean isHeap(Node root) {
        if (root == null)
            return true;
        if (root.right != null && (root.right.left != null || root.right.right != null)) {
            if (root.left.left == null || root.left.right == null)
                return false;
        }
        if (root.left != null && root.left.data >= root.data || root.right != null && root.right.data >= root.data)
            return false;
        return isHeap(root.left) && isHeap(root.right);
    }

}
