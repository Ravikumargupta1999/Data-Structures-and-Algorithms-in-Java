import java.util.HashMap;
import java.util.Scanner;

public class BST_227_Brothers_From_Different_Roots {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }


    // Method - 1

    int count;

    int countPairs(Node root1, Node root2, int x) {
        count = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        solve1(root2, hm);
        solve2(root1, hm, x);
        return count;
    }

    void solve1(Node root, HashMap<Integer, Integer> hm) {
        if (root == null)
            return;
        solve1(root.left, hm);
        hm.put(root.data, 1);
        solve1(root.right, hm);
    }

    void solve2(Node root1, HashMap<Integer, Integer> hm, int x) {
        if (root1 == null)
            return;
        solve2(root1.left, hm, x);
        if (hm.containsKey(x - root1.data))
            count++;
        solve2(root1.right, hm, x);
    }


    // Method - 2

    // ye bhi sahi hai

//    int count;
//
//    int countPairs(Node root1, Node root2, int x) {
//        count = 0;
//        solve(root1, root2, x);
//        return count;
//    }
//
//    void solve(Node root1, Node root2, int k) {
//        if (root1 == null)
//            return;
//        solve(root1.left, root2, k);
//        if (Search(root2, k - root1.data) == 1) {
//            count++;
//        }
//        solve(root1.right, root2, k);
//    }
//
//    public static int Search(Node root, int data) {
//        if (root == null)
//            return 0;
//        else if (root.data == data) {
//            return 1;
//        } else if (data <= root.data) {
//            return Search(root.left, data);
//        } else
//            return Search(root.right, data);
//
//    }

}
