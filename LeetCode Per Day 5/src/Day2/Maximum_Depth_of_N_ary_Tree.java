package Day2;

import java.util.List;

public class Maximum_Depth_of_N_ary_Tree {
//    https://leetcode.com/problems/maximum-depth-of-n-ary-tree/submissions/
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children.size() == 0)
            return 1;
        return minDepth1(root);
    }

    public int minDepth1(Node root) {
        if (root == null)
            return -1;
        else if (root.children.size() == 0)
            return 1;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, minDepth1(root.children.get(i)));
        }
        return max + 1;
    }
}
