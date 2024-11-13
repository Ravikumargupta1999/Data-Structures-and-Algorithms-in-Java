package InterviewQuestion;

import java.util.ArrayList;

public class Video_20_Sum_Of_Leaf_Nodes {
    // https://practice.geeksforgeeks.org/problems/sum-of-leaf-nodes/1
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public int SumofLeafNodes(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        getLeafSum(root, list);
        return list.get(0);
    }

    public void getLeafSum(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.set(0, list.get(0) + root.data);
        getLeafSum(root.left, list);
        getLeafSum(root.right, list);
    }
}
