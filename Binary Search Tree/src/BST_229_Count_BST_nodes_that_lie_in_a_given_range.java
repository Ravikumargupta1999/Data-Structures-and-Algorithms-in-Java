public class BST_229_Count_BST_nodes_that_lie_in_a_given_range {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1#
    public int getCount(Node root, int l, int r) {
        Node curr = root;
        int count = 0;

        while (curr != null) {

            Node leftNode = curr.left;

            if (leftNode == null) {
                if (curr.data >= l && curr.data <= r)
                    count++;
                curr = curr.right;
            } else {
                Node rightMostNode = getRightMostNode(leftNode, curr);
                // create thread
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;

                    curr = curr.left;
                }

                // break thread
                else {
                    rightMostNode.right = null;
                    if (curr.data >= l && curr.data <= r)
                        count++;
                    curr = curr.right;
                }
            }
        }
        return count;


    }

    public Node getRightMostNode(Node node, Node curr) {
        while (node.right != null && node.right != curr)
            node = node.right;
        return node;
    }
}
