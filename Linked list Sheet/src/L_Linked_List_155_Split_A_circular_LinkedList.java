public class L_Linked_List_155_Split_A_circular_LinkedList {
    // https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1#
    class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
//    Node head, head1, head2;
//    void splitList(circular_LinkedList list)
//    {
//        Node newNode  = new Node(-1);
//        circular_LinkedList st = list;
//        while (list != null)
//        {
//            if(list.e)
//        }
//    }
    public Node middleNode(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            return slow;
        return slow.next;
    }
}
