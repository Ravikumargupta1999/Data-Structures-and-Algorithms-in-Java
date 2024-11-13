public class BT_196_8_Construct_Binary_Search_Tree_from_Postorder_Traversal {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1/
    public static Node constructTree(int[] post, int n) {
        if (n == 0)
            return null;
        else if (n == 1)
            return new Node(post[0]);

        return constructBST(post, 0, n - 1);
    }

    public static Node constructBST(int[] post, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new Node(post[start]);


        Node node = new Node(post[end]);

        int index = start;

        while (post[index] < post[end]) {
            index++;
        }

        node.left = constructBST(post, start, index - 1);
        node.right = constructBST(post,index,end-1);
        return node;
    }
}
