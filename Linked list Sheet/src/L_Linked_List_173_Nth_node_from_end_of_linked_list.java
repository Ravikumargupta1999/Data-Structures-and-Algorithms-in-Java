public class L_Linked_List_173_Nth_node_from_end_of_linked_list {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1#
    public static int getNthFromLast(Node head, int n) {
        if (length(head) < n)
            return -1;
        head = reverse(head);
        for (int i = 0; i < n - 1; i++) {
            head = head.next;
        }
        return head.data;
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;

    }

    static int length(Node temp) {
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        System.out.print("List is ");
        printList(head);
        int n = 1;
        int value = getNthFromLast(head, n);
        System.out.print("Value " + value);

    }
}
