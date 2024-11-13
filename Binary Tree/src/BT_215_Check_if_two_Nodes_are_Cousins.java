import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BT_215_Check_if_two_Nodes_are_Cousins {

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false
        int x = getLevel(root, a);
        int y = getLevel(root, b);
        if (x != y)
            return false;
        if (x < 3)
            return false;
        int xparent = getParent(root, a);
        int yParent = getParent(root, b);
        return xparent == yParent ? false : true;
    }

    public int getParent(Node root, int a) {
        if (root == null)
            return -1;
        if (root.left != null && root.left.data == a)
            return root.data;
        if (root.right != null && root.right.data == a)
            return root.data;
        int left = getParent(root.left, a);
        if (left != -1)
            return left;
        return getParent(root.right, a);
    }

    int getLevel(Node root, int data) {
        if (root == null)
            return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = -1;
        int level = 0;
        int max_nodes = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node current = q.peek();
                if (current.data == data)
                    return level + 1;
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            level++;
        }
        return -1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        storeParents(root, map);

        TreeNode a = getNode(root, x);
        TreeNode b = getNode(root, y);

        if (a == null || b == null)
            return false;

        if (map.containsKey(a) && map.containsKey(map.get(a)) && map.containsKey(b) && map.containsKey(map.get(b))) {
            TreeNode parentsA = map.get(a);
            TreeNode parentsB = map.get(b);
            if (parentsA == null || parentsB == null || parentsA == parentsB)
                return false;
            TreeNode grandParentsA = map.get(parentsA);
            TreeNode grandParentsB = map.get(parentsB);

            if (grandParentsA != null && grandParentsB != null && grandParentsA == grandParentsB)
                return true;
            return false;
        }else {
            return false;
        }


    }

    public void storeParents(TreeNode node, HashMap<TreeNode, TreeNode> map) {
        if (node == null)
            return;
        if (node.left != null) {
            map.put(node.left, node);
            storeParents(node.left, map);
        }
        if (node.right != null) {
            map.put(node.right, node);
            storeParents(node.right, map);
        }
    }

    public TreeNode getNode(TreeNode node, int x) {
        if (node == null)
            return null;
        if (node.val == x)
            return node;
        TreeNode temp = getNode(node.left, x);
        if (temp != null)
            return temp;
        return getNode(node.right, x);
    }
}