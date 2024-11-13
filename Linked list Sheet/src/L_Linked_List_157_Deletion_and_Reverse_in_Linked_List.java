public class L_Linked_List_157_Deletion_and_Reverse_in_Linked_List {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list/1/
    public static Node deleteNode(Node head, int d) {
        Node curr = head;
        while (curr.next.data != d) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    //This method returns the head node of the reversed Linked list.
    public static Node reverse(Node head) {
        //Add your code here
        Node curr = head;
        Node prev = null;
        do {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while (curr != head);
        curr.next = prev;
        return prev;
    }
}
