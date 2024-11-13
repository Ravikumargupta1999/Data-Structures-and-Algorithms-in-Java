import java.util.*;

public class BT_187_Vertical_Order_Of_Binary_Tree_HashMap_Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1#
    // https://www.youtube.com/watch?v=LscPXvD1N1A&list=PL-Jc9J83PIiHgjQ9wfJ8w-rXU368xNX4L&index=25
    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair rem = queue.poll();
            if (!map.containsKey(rem.level))
                map.put(rem.level, new ArrayList<>());
            map.get(rem.level).add(rem.node.data);
            if (rem.node.left != null) {
                queue.add(new Pair(rem.node.left, rem.level - 1));
            }
            if (rem.node.right != null) {
                queue.add(new Pair(rem.node.right, rem.level + 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> sorted = new TreeMap<>();
        sorted.putAll(map);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sorted.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                ans.add(entry.getValue().get(i));
            }
        }
        return ans;
    }
}
