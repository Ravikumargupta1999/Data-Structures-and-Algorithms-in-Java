package Day_6_Linked_LIST_II;

import java.util.PriorityQueue;

public class Flattening_a_Linked_List {
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    // Method 1 :PriorityQueue
    Node flatten(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node(-1);

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            return a.data - b.data;
        });

        Node temp = dummy;

        Node curr = root;

        while (curr != null) {
            queue.add(curr);
            curr = curr.next;
        }

        while (queue.size() != 0) {

            Node xyz = queue.poll();
            if (xyz.bottom != null)
                queue.add(xyz.bottom);
            xyz.next = null;
            xyz.bottom = null;

            temp.bottom = xyz;
            temp = temp.bottom;
        }
        return dummy.bottom;
    }

    Node flatten1(Node root) {
        if (root == null || root.next == null)
            return root;

        root.next = flatten(root.next);
        root = merge(root,root.next);
        return root;
    }

    Node merge(Node n1, Node n2) {

        Node dummy = new Node(-1);

        Node temp = dummy;

        while (n1 != null && n2 != null){
            if(n1.data < n2.data){
                temp.bottom = n1;
                temp = temp.bottom;
                n1 = n1.bottom;
            }else {
                temp.bottom = n2;
                temp = temp.bottom;
                n2 = n2.bottom;
            }
        }
        if(n1 != null){
            temp.bottom = n1;
        }
        if(n2 != null){
            temp.bottom = n2;
        }
        return dummy.bottom;
    }


}
