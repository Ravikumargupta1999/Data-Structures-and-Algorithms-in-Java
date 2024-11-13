import java.util.PriorityQueue;

public class L_Linked_List_166_Flattening_A_Linked_List {
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

    // https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
    Node flatten(Node root)
    {
        if (root == null)
            return null;
        Node dummy = new Node(-1);

        Node temp = dummy;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
            return a.data - b.data;
        });

        // next pointers may or not be sorted
        // Bottom pointers are sorted for sure
        // so at start add all next pointers in priority queue
        // then process with bottom pointers
        // basically question now becomes for merging k sorted list with bottom pointers

        Node curr = root;
        while (curr != null){
            queue.add(curr);
            curr = curr.next;
        }

        while (!queue.isEmpty()) {
            Node rem = queue.poll();

            temp.bottom = rem;
            temp = temp.bottom;


            if (rem.bottom != null)
                queue.add(rem.bottom);
        }
        return dummy.bottom;

    }

}
