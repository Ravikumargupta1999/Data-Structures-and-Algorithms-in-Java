package InterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Video_21_Common_Node_In_Two_BST {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> findCommon(Node root1, Node root2) {
        HashSet<Integer> set1 = new HashSet<>();
        inorder(root1, set1);
        HashSet<Integer> set2 = new HashSet<>();
        inorder(root2, set2);

        ArrayList<Integer> list = new ArrayList<>();
        for (int val : set1)
            if (set2.contains(val))
                list.add(val);
        Collections.sort(list);
        return list;
    }

    public static void inorder(Node root, HashSet<Integer> set) {
        if(root == null)
            return;
        set.add(root.data);
        inorder(root.left,set);
        inorder(root.right,set);
    }
}
