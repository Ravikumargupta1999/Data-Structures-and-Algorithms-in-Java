
public class Burning_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static int maxTime = 0;

    public static int burningTree(Node root, int fireNode) {
        burningTree_(root, fireNode);
        return maxTime;
    }

    public static int burningTree_(Node root, int fireNode) {
        if (root == null)
            return -1;
        if (root.data == fireNode) {
            burningTree(root, null, 0);
            return 1;
        }
        int leftTime = burningTree_(root.left, fireNode);
        if (leftTime != -1) {
            burningTree(root, root.left, leftTime);
            return leftTime + 1;
        }

        int rightTime = burningTree_(root.right, fireNode);
        if (rightTime != -1) {
            burningTree(root, root.right, rightTime);
            return rightTime + 1;
        }
        return -1;
    }

    public static void burningTree(Node root,Node blockNode, int time) {
        if (root == null || root == blockNode)
            return;
        maxTime = Math.max(maxTime, time);
        burningTree(root.left, blockNode, time + 1);
        burningTree(root.right, blockNode, time + 1);
    }

}
