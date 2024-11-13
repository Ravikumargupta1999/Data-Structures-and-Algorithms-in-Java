import java.util.*;

public class BT_187_Vertical_Order_Of_Binary_Tree_HashMap_Solution_Leetcode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Pair {
        TreeNode node;
        int row;
        int col;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    // https://www.youtube.com/watch?v=LscPXvD1N1A&list=PL-Jc9J83PIiHgjQ9wfJ8w-rXU368xNX4L&index=25
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair rem = queue.poll();
            if (!map.containsKey(rem.col))
                map.put(rem.col, new ArrayList<>());
            map.get(rem.col).add(rem);
            if (rem.node.left != null) {
                queue.add(new Pair(rem.node.left, rem.row + 1, rem.col - 1));
            }
            if (rem.node.right != null) {
                queue.add(new Pair(rem.node.right, rem.row + 1, rem.col + 1));
            }
        }
        List<List<Pair>> ans = new ArrayList<>();
        TreeMap<Integer, List<Pair>> sorted = new TreeMap<>();
        sorted.putAll(map);
        for (Map.Entry<Integer, List<Pair>> entry : sorted.entrySet()) {
            ans.add(entry.getValue());
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Pair> pairs : ans) {
            Collections.sort(pairs, (a, b) -> {
                if (a.row == b.row)
                    return a.node.val - b.node.val;
                else
                    return a.col - b.col;
            });
            ArrayList<Integer> temp = new ArrayList<>();
            for (Pair pair : pairs) {
                temp.add(pair.node.val);
            }
            res.add(temp);
        }
        return res;
    }
}
