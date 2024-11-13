import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/check-if-subtree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class BT_214_Check_if_subtree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    // Method - 1
    public static boolean isSubtree(Node T, Node S) {

        if (T == null)
            return false;

        return isIdentical(T, S) || isSubtree(T.left, S) || isSubtree(T.right, S);

    }

    static boolean isIdentical(Node root1, Node root2) {

        if (root1 == null || root2 == null)
            return root1 == root2 ? true : false;

        if (root1.data != root2.data)
            return false;

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

    }

    // Method - 2

    public static boolean isSubtree1(Node T, Node S) {
        HashSet<String> set = new HashSet<>();
        getAllSubTree(T, set);

        return set.contains(subTree(S));

    }

    public static String getAllSubTree(Node T, HashSet<String> set) {
        if (T == null)
            return "$";
        String s = "";
        s = Integer.toString(T.data) + " " + getAllSubTree(T.left, set) + " " + getAllSubTree(T.right, set); // adding space is important
        set.add(s);
        return s;
    }

    public static String subTree(Node T) {
        if (T == null)
            return "$";
        String s = "";
        s = Integer.toString(T.data) + " " + subTree(T.left) + " " + subTree(T.right); // adding space is important
        return s;
    }

}
