package InterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1
// https://www.youtube.com/watch?v=s22QClql9LU
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class Video_68_Nodes_At_Given_Distance_In_Binary_Tree {
    class Node {
        int data;
        Node left, right;
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        kDistanceNode(root, target, k, list);
        Collections.sort(list);
        return list;
    }

    public static int kDistanceNode(Node root, int target, int k, ArrayList<Integer> list) {
        if (root == null) {
            return -1;
        }
        if (root.data == target) {
            kDown(root, k, null, list);
            return 1;
        }
        int ld = kDistanceNode(root.left, target, k, list);
        if (ld != -1) {
            kDown(root, k - ld, root.left, list);
            return ld + 1;
        }
        int rd = kDistanceNode(root.right, target, k, list);
        if (rd != -1) {
            kDown(root, k - rd, root.right, list);
            return rd + 1;
        }
        return -1;
    }

    public static void kDown(Node root, int k, Node blockNode, ArrayList<Integer> list) {
        if (root == null || k < 0 || root == blockNode)
            return;
        if (k == 0) {
            list.add(root.data);
            return;
        }
        kDown(root.left, k - 1, blockNode, list);
        kDown(root.right, k - 1, blockNode, list);
    }
}
