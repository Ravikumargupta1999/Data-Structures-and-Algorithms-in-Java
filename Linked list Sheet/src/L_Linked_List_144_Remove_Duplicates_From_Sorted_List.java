public class L_Linked_List_144_Remove_Duplicates_From_Sorted_List {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (head != null) {
            if (head.data != temp.data) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
