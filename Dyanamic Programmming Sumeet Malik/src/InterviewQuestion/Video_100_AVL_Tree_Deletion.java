package InterviewQuestion;

public class Video_100_AVL_Tree_Deletion {
    // https://practice.geeksforgeeks.org/problems/avl-tree-deletion/1
    class Node
    {
        int data, height;
        Node left, right;

        Node(int x)
        {
            data=x;
            left=right=null;
            height=1;
        }
    }

    public static Node deleteNode(Node root, int key)
    {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = bf(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && bf(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && bf(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && bf(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && bf(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    static Node minValueNode(Node node)
    {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
    static int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    static int bf(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    static Node rightRotate(Node c) {

        Node b = c.left;
        Node T3 = b.right;

        // rotate
        b.right = c;
        c.left = T3;

        // ht update
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }

    static Node leftRotate(Node c) {

        Node b = c.right;
        Node T2 = b.left;

        // rotate
        b.left = c;
        c.right = T2;

        // ht update
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }
}
