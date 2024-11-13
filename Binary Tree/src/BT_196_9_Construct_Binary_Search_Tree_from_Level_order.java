import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_196_9_Construct_Binary_Search_Tree_from_Level_order {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class Pair {
        Node parents;
        int lb = -(int) 1e9;
        int rb = (int) 1e9;

        public Pair() {

        }

        public Pair(Node parents, int lb, int rb) {
            this.parents = parents;
            this.lb = lb;
            this.rb = rb;
        }
    }

    // https://www.youtube.com/watch?v=8w_NSKo9e74&t=19s
    // https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1#
    public Node constructBST(int[] arr) {
        int n = arr.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair());

        Node root = null;
        int idx = 0;
        while (queue.size() != 0 && idx < n) {
            Pair rem = queue.poll();
            int val = arr[idx];
            if (val < rem.lb || val > rem.rb)
                continue;
            Node temp = new Node(val);
            idx++;

            if (rem.parents == null) {
                root = temp;
            } else {
                Node parents = rem.parents;
                if (val <= parents.data) {
                    parents.left = temp;
                } else {
                    parents.right = temp;
                }
            }
            queue.add(new Pair(temp, rem.lb, val));
            queue.add(new Pair(temp, val, rem.rb));
        }
        return root;
    }

    // Method - 2
    // https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1#
    public Node constructBST1(int[] arr)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for (int num : arr)
            al.add(num);
        return constructBST(al);
    }
    public Node constructBST(ArrayList<Integer > list){
        if(list.size() == 0)
            return null;
        else if(list.size() == 1)
            return new Node(list.get(0));

        Node node = new Node(list.get(0));
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for (int i = 1;i<list.size();i++){
            int num = list.get(i);
            if(num < list.get(0))
                left.add(num);
            else
                right.add(num);
        }
        node.left = constructBST(left);
        node.right = constructBST(right);
        return node;
    }
}
