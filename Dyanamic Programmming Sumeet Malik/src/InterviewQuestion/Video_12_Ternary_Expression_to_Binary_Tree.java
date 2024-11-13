package InterviewQuestion;

import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/ternarytotree_1102306?leftPanelTab=1

public class Video_12_Ternary_Expression_to_Binary_Tree {

    static class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static TreeNode<Character> toBinaryTree(String str) {
        ArrayList<Integer> ref = new ArrayList<>();
        ref.add(0);
        return convertExp(str, ref);
    }

    public static TreeNode<Character> convertExp(String str, ArrayList<Integer> ref) {
        if (ref.get(0) == str.length()) {
            return null;
        } else {
            TreeNode<Character> root = new TreeNode<Character>(str.charAt(ref.get(0)));

            boolean left = false;
            if (ref.get(0) + 1 != str.length() && str.charAt(ref.get(0) + 1) == '?') {
                left = true;
                ref.set(0, ref.get(0) + 2);
                root.left = convertExp(str, ref);
            }


            if (left && ref.get(0) + 1 != str.length()) {
                ref.set(0, ref.get(0) + 2);
                root.right = convertExp(str, ref);
            }

            return root;
        }
    }
}
