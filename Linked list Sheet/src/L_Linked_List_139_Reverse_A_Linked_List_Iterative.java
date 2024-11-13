//
public class L_Linked_List_139_Reverse_A_Linked_List_Iterative {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

    }

    // https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/
    Node reverseList(Node head) {
        Node current, previous, next;
        current = head;
        previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
}
