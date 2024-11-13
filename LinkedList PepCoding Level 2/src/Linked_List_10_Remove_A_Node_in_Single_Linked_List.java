public class Linked_List_10_Remove_A_Node_in_Single_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1
    Node deleteNode(Node head, int x) {

        Node temp = head;
        if (x == 1) {
            if (head.next == null)
                return null;
            else
                return head.next;
        }
        Node prev = null;
        while (temp != null) {
            if (x == 1) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            x--;
        }
        return head;
    }


}
