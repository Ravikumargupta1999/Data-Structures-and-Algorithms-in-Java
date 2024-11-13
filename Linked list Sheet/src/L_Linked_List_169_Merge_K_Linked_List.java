import java.util.PriorityQueue;

public class L_Linked_List_169_Merge_K_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://www.youtube.com/watch?v=jhWT8qal1SI&list=PL-Jc9J83PIiGRqcfZxxgOKovgLVd3znnq&index=9
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

    static void mergeKSortedList(Node[] arr, int k) {
        int i = 0;
        int last = k - 1;
        int j;
        while (last != 0) {
            i = 0;
            j = last;
            while (i < j) {
                arr[i] = merge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return;
    }

    static Node merge(Node head1, Node head2) {
        Node merged = new Node(-1);
        Node temp = merged;
        System.out.println(temp.data);
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        Node head = merged.next;
        return head;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.print("List is ");
        printList(head);
        int k = 3;

        //head = mergeKSortedList(head,k);
        System.out.print("List is ");
        printList(head);

    }
}
