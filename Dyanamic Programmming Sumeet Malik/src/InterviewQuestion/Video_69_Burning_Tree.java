package InterviewQuestion;

import java.util.ArrayList;

public class Video_69_Burning_Tree {
    // https://www.youtube.com/watch?v=dtBj2A_7JOk&t=185s
    //
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

    public static int minTime(Node root, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        findMinimumTime(root, target, arrayList);
        return arrayList.get(0);
    }

    public static int findMinimumTime(Node node, int target, ArrayList<Integer> res) {
        if (node == null) return -1;
        if (node.data == target) {
            burnTree(node, 0, null, res);
            return 1;
        }

        int ld = findMinimumTime(node.left, target, res);
        if (ld != -1) {
            burnTree(node, ld, node.left, res);
            return ld + 1;
        }
        int rd = findMinimumTime(node.right, target, res);
        if (rd != -1) {
            burnTree(node, rd, node.right, res);
            return rd + 1;
        }
        return -1;
    }

    public static void burnTree(Node node, int dis, Node blockNode, ArrayList<Integer> res) {

        if (node == null || node == blockNode) return;
        res.set(0, Math.max(dis, res.get(0)));
        burnTree(node.left, dis + 1, blockNode, res);
        burnTree(node.right, dis + 1, blockNode, res);
    }

}
