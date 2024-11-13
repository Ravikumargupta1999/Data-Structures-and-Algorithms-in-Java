public class Linked_List_28_Segregate_0_1_Node_Of_A_Linked_List_Over_Swapping_Node {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node segregate(Node head) {
        Node Zero = new Node(-1);
        Node One = new Node(-1);
        Node zero = Zero;
        Node one = One;

        Node temp = head;
        while (head != null) {
            if (head.data == 0) {
                zero.next = head;
                zero = zero.next;
            }
            {
                one.next = head;
                one = one.next;
            }
            head = head.next;
        }
        zero.next = One.next;
        one.next = null;
        return Zero.next;
    }
}
