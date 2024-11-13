//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BT_188_Bottom_View_of_Binary_Tree {
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

    static class Pair {
        Node node = null;
        int h1;

        Pair(Node node, int h1) {
            this.node = node;
            this.h1 = h1;
        }
    }

    static void width(Node root, int h1, int[] ans) {
        if (root == null)
            return;
        ans[0] = Math.min(ans[0], h1);
        ans[1] = Math.max(ans[1], h1);
        width(root.left, h1 - 1, ans);
        width(root.right, h1 + 1, ans);
    }

    static ArrayList<Integer>  bottomView(Node root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        for (int i = 0; i < al.size(); i++)
            al.add(new ArrayList<>());
        if (root == null)
            return al1;

        int[] minMax = new int[2];
        width(root, 0, minMax);

        int len = minMax[1] - minMax[0] + 1;
        for (int i = 0; i < len; i++) {
            al.add(new ArrayList<>());
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Math.abs(minMax[0])));
        while (q.size() != 0) {
            Pair rp = q.poll();
            int hl = rp.h1;
            Node temp = rp.node;
            al.get(hl).add(temp.data);
            if (temp.left != null)
                q.add(new Pair(temp.left, hl - 1));
            if (temp.right != null)
                q.add(new Pair(temp.right, hl + 1));
        }

        for (int i = 0; i < al.size(); i++) {
            int j= al.get(i).size();

            al1.add(al.get(i).get(j-1));
        }
        return al1;
    }

    public static void main(String[] args) {

    }


}
