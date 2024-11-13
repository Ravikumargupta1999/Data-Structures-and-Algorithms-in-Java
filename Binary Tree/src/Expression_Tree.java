import java.util.HashSet;
//  https://practice.geeksforgeeks.org/problems/expression-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=1&category[]=Tree&query=company[]Amazondifficulty[]0page1company[]Amazoncategory[]Tree#
public class Expression_Tree {
    class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // + , – ,*, /
    static HashSet<String> set;
    public int evalTree(Node root) {
        if (root == null)
            return 0;
        set = new HashSet<>();
        set.add("*");
        set.add("-");
        set.add("+");
        set.add("/");
        return evaluate(root);
    }

    public int evaluate(Node root) {
        if (root == null)
            return 0;
        if(!set.contains(root.data))
            return Integer.parseInt(root.data);
        int a = evaluate(root.left);
        int b = evalTree(root.right);
        if (root.data == "+")
            return (a) + (b);
        else if (root.data == "-")
            return (a) - (b);
        else if (root.data == "*")
            return (a) * (b);
        else {
            if( b == 0)
                return 0;
            return (a) / (b);
        }
    }

    public static void main(String[] args) {
//        Node root = new Node("+");
//        root.left = new Node("*");
//        root.right = new Node("-");
//        root.left.left = new Node("5");
//        root.left.right = new Node("4");
//        root.right.left = new Node("100");
//        root.right.right = new Node("20");
//        System.out.println(evalTree(root));
    }
}
