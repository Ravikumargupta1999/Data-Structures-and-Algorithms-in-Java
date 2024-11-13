import java.util.Map;

public class Decimal_Equivalent_of_Binary_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static long DecimalValue(Node head) {
        long p = 1000000007;
        head = reverse(head);
        long value = 0;
        Node temp = head;
        long n = 0;
        while (temp != null) {
            if (temp.data == 1) {
                value = (value %p  +( (long) Math.pow(2, n++)%p))%p;
            } else
                n++;

            temp = temp.next;
        }
        System.out.println(value);
        return value;
    }

    static Node reverse(Node head) {
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

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(0);
        System.out.println(DecimalValue(head));
    }

}
