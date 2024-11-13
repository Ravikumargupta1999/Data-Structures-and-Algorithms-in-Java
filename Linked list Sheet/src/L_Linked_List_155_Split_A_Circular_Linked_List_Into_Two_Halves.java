public class L_Linked_List_155_Split_A_Circular_Linked_List_Into_Two_Halves {

    class circular_LinkedLis {
        Node head, head1, head2;  // head of lisl
        //Node last = null;
        Node last = null;


    }
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void splitList(circular_LinkedLis list)
    {
        // Wrong Find out why
//        Node node = list.head;
//        Node temp = node;
//        while (temp.next != node)
//            temp = temp.next;
//        temp.next = null;
//
//        Node slow = list.head;
//        Node fast = list.head;
//        while (fast.next != null && fast.next.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        list.head1 = list.head;
//        list.head2 = slow.next;
//        slow.next = null;

        // Your code here
        Node head1 = list.head;
        Node slow = list.head;

        Node fast = list.head;

        while (fast.next != head1 && fast.next.next != head1) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node tail1 = slow;
        Node head2 = slow.next;
        slow.next = null;

        Node tail2 = head2;
        while (tail2.next != head1) {
            tail2 = tail2.next;
        }

        tail1.next = head1;
        tail2.next = head2;

        list.head1 = head1;
        list.head2 = head2;
    }


}