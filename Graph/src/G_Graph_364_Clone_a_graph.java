import java.util.*;
// https://www.youtube.com/watch?v=jWf5F_shzho
// https://leetcode.com/problems/clone-graph/
// https://practice.geeksforgeeks.org/problems/clone-graph/0/?category[]=Graph
public class G_Graph_364_Clone_a_graph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Integer, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        DFS(node, copy, map);
        return copy;
    }

    public void DFS(Node node, Node copy, HashMap<Integer, Node> map) {
        map.put(node.val, copy);
        for (Node neighbour : node.neighbors) {
            if (!map.containsKey(neighbour.val)) {
                Node newNode = new Node(neighbour.val);
                copy.neighbors.add(newNode);
                DFS(neighbour, newNode, map);
            } else {
                copy.neighbors.add(map.get(neighbour.val));
            }
        }
    }


}

