public class Add_all_greater_values_to_every_node_in_a_BST {
    // https://practice.geeksforgeeks.org/problems/add-all-greater-values-to-every-node-in-a-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
    class Node {
        int data;
        Node left, right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }


    int sum = 0;

    public Node modify(Node root) {
        modify1(root);
        return root;
    }

    void modify1(Node root) {
        if (root == null) {
            return;
        }
        modify1(root.right);
        sum += root.data;
        root.data = sum;
        modify1(root.left);
    }

}
