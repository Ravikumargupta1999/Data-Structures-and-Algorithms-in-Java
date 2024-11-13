//https://practice.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=1&query=company[]Amazondifficulty[]0page1company[]Amazon#

public class Root_to_leaf_paths_sum {
    static class Tree {
        int data;
        Tree left, right;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static long treePathsSum(Tree root) {
        return sum(root, 0);
    }

    public static long sum(Tree node, long val) {
        if (node == null)
            return 0;
        val = (val * 10 + node.data);
        System.out.println(val);
        if (node.left == null && node.right == null)
            return val;

        return sum(node.left, val) + sum(node.right, val);
    }

    public static void main(String[] args) {
        Tree root = new Tree(6);
        root.left = new Tree(3);
        root.right = new Tree(5);
        root.right.right = new Tree(4);
        root.left.left = new Tree(2);
        root.left.right = new Tree(5);
        root.left.right.right = new Tree(4);
        root.left.right.left = new Tree(7);

        System.out.print("Sum of all paths is " + treePathsSum(root));
    }

}
