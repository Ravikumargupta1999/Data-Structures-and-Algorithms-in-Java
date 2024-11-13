import java.util.PriorityQueue;

public class Heap_345_Merge_K_Sorted_Linked_List {
    // https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
    class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node mergeKList(Node[] lists, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return a.data - b.data;
        });
        for (Node l : lists)
            if (l != null)
                pq.add(l);
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (pq.size() != 0) {
            Node p = pq.poll();
            temp.next = p;
            temp = temp.next;
            p = p.next;
            if (p != null)
                pq.add(p);
        }
        return dummy.next;
    }
}
