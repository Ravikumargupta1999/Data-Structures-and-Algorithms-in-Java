import java.util.HashSet;

public class BT_196_5_Construct_Tree_from_Inorder_Levelorder {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1/
    // https://www.youtube.com/watch?v=mfEs11IKEes&t=421s
    Node buildTree(int inorder[], int level[]) {
        if (inorder.length == 0)
            return null;
        return constructTree(inorder, 0, inorder.length - 1, level);
    }

    Node constructTree(int[] inorder, int isi, int iei, int[] levelOrder) {
        if (isi > iei)
            return null;
        Node node = new Node(levelOrder[0]);

        if (levelOrder.length == 1)
            return node;


        HashSet<Integer> set = new HashSet<>();
        int idx = isi;

        while (inorder[idx] != node.data) {
            set.add(inorder[idx++]);
        }

        int[] leftLevel = new int[idx - isi];
        int[] rightLevel = new int[iei - idx];
        int ls = 0;
        int rs = 0;

        for (int i = 1; i < levelOrder.length; i++) {
            int val = levelOrder[i];
            if (set.size() != 0 && set.contains(val)) {
                leftLevel[ls++] = val;
                set.remove(val);
            } else {
                rightLevel[rs++] = val;
            }
        }
        node.left = constructTree(inorder, isi, idx - 1, leftLevel);
        node.right = constructTree(inorder, idx + 1, iei, rightLevel);
        return node;
    }

}
