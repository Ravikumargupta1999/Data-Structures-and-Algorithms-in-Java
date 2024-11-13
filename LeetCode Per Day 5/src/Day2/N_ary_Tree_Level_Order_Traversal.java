package Day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_Tree_Level_Order_Traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    // https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> list = new ArrayList<>();

        while (queue.size() > 0){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0){
                Node rem = queue.poll();
                temp.add(rem.val);
                for (int i=0;i<rem.children.size();i++){
                    queue.add(rem.children.get(i));
                }
            }
            list.add(temp);
        }
        return list;

    }
}
