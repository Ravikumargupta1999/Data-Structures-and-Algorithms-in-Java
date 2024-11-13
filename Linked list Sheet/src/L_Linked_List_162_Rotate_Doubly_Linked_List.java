public class L_Linked_List_162_Rotate_Doubly_Linked_List {
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public Node rotateDLL(Node start, int p) {
        Node temp = start;
        for (int i = 0; i < p - 1; i++)
            temp = temp.next;


        Node head = temp.next;
        head.prev = null;
        temp.next = null;



        temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = start;
        start.prev = temp;

        return head;
    }

   
}
