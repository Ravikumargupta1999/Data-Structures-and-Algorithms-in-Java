// https://practice.geeksforgeeks.org/problems/two-mirror-trees/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=3&query=company[]Amazondifficulty[]0page3company[]Amazon

public class Two_Mirror_Trees {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    boolean areMirror(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.data != b.data)
            return false;
        return areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }
}
