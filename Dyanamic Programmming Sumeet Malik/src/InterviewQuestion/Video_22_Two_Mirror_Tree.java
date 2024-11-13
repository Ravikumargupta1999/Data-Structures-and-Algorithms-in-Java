package InterviewQuestion;

public class Video_22_Two_Mirror_Tree {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    boolean areMirror(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        } else if (a != null && b == null) {
            return false;
        } else if (a == null && b != null) {
            return false;
        } else {
            return a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left);
        }
    }
}
