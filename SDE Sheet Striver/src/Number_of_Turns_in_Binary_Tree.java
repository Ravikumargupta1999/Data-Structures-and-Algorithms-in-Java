import java.util.ArrayList;

public class Number_of_Turns_in_Binary_Tree {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }


    static Node lca(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);
        if (root.data == a || root.data == b) {
            return root;
        }
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        }
        return null;
    }

    static int dfs(Node _lca, int a, int side, ArrayList<Integer> turns) {
        if (_lca == null) {
            return 0;
        }
        if (_lca.data == a) {
            return 1;
        }
        int l = dfs(_lca.left, a, -1, turns);
        int r = dfs(_lca.right, a, 1, turns);
        if (l == 1 && side == 1) {
            turns.set(0, turns.get(0) + 1);
            return 1;
        } else if (r == 1 && side == -1) {
            turns.set(0, turns.get(0) + 1);
            return 1;
        }
        return Math.max(l, r);
    }

    static int NumberOfTurns(Node root, int first, int second) {
        // Your code goes here
        ArrayList<Integer> turns = new ArrayList<>();
        turns.add(0);
        Node LCA = lca(root, first, second);
        dfs(LCA, first, 0, turns);
        dfs(LCA, second, 0, turns);
        if (first != LCA.data && second != LCA.data) {
            turns.set(0, turns.get(0) + 1);
        }
        return turns.get(0);
    }

}
