public class BT_196_3_Construct_Tree_from_Preorder {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //    pre[] = {10, 30, 20, 5, 15}
    //    preLN[] = {N, N, L, L, L}
    // https://practice.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1#
    class Pair {
        int val;
        boolean isLeaf;

        public Pair(int val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }
    }

    public Node constructTree(int n, int[] pre, char[] preLN) {
        if (n == 0)
            return null;
        java.util.Queue<Pair> queue = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (preLN[i] == 'L') {
                queue.add(new Pair(pre[i], true));
            } else {
                queue.add(new Pair(pre[i], false));
            }
        }
        return constructTreeNode(queue);
    }

    public Node constructTreeNode(java.util.Queue<Pair> queue) {
        if (queue.size() == 0)
            return null;
        Pair temp = queue.poll();
        if (temp.isLeaf) {
            return new Node(temp.val);
        } else {
            Node node = new Node(temp.val);
            node.left = constructTreeNode(queue);
            node.right = constructTreeNode(queue);
            return node;
        }
    }


}
