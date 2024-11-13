public class L_Linked_List_171_Delete_nodes_having_greater_value_on_right {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1#
    Node compute(Node head) {
        Node dummy = new Node(-1);

        head = reverse(head);
        if (head == null || head.next == null)
            return head;

        Node temp = dummy;

        Node c1 = head;
        while (c1 != null) {

            if (c1.data >= temp.data) {
                temp.next = c1;
                temp = temp.next;
            }
            c1 = c1.next;
        }
        temp.next = null; // most important step
        return reverse(dummy.next);
    }

    public Node reverse(Node head) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


}
