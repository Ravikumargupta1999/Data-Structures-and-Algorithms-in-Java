package InterviewQuestion;

public class Decimal_Equivalent_of_Binary_Linked_List {
    public Decimal_Equivalent_of_Binary_Linked_List() {
    }

    static long DecimalValue(Decimal_Equivalent_of_Binary_Linked_List.Node head) {
        long p = 1000000007L;
        head = reverse(head);
        long value = 0L;
        Decimal_Equivalent_of_Binary_Linked_List.Node temp = head;

        for(long n = 0L; temp != null; temp = temp.next) {
            if (temp.data == 1) {
                value = (value % p + (long)Math.pow(2.0D, (double)(n++)) % p) % p;
            } else {
                ++n;
            }
        }

        System.out.println(value);
        return value;
    }

    static Decimal_Equivalent_of_Binary_Linked_List.Node reverse(Decimal_Equivalent_of_Binary_Linked_List.Node head) {
        Decimal_Equivalent_of_Binary_Linked_List.Node current = head;

        Decimal_Equivalent_of_Binary_Linked_List.Node previous;
        Decimal_Equivalent_of_Binary_Linked_List.Node next;
        for(previous = null; current != null; current = next) {
            next = current.next;
            current.next = previous;
            previous = current;
        }

        return previous;
    }

    public static void main(String[] args) {
        Decimal_Equivalent_of_Binary_Linked_List.Node head = new Decimal_Equivalent_of_Binary_Linked_List.Node(1);
        head.next = new Decimal_Equivalent_of_Binary_Linked_List.Node(0);
        head.next.next = new Decimal_Equivalent_of_Binary_Linked_List.Node(0);
        System.out.println(DecimalValue(head));
    }

    static class Node {
        int data;
        Decimal_Equivalent_of_Binary_Linked_List.Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }
}
