public class Linked_List_24_Multiply_two_linked_lists {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Method 1 Applicable only for smaller linked list
    public long multiplyTwoLists1(Node head1, Node head2) {
        Node first = head1;
        Node second = head2;
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second != null) {

            if (first != null) {
                num1 = ((num1) * 10) % N + first.data;
                first = first.next;
            }

            if (second != null) {
                num2 = ((num2) * 10) % N + second.data;
                second = second.next;
            }

        }
        return ((num1 % N) * (num2 % N)) % N;
    }

    // https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1
    public static Node multiplyTwoLists2(Node l1, Node l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);


        Node dummy = new Node(-1);
        Node prev = dummy;


        Node c1 = l1;
        Node c2 = l2;


        while (c2 != null) {

            c1 = l1;

            int a = c2.data;

            int rem = 0;

            Node temp = prev;

            while (c1 != null) {
                int b = 0;
                if (prev.next == null) {

                    b = ((c1.data) * (a) + rem) % 10;
                    prev.next = new Node(b);
                    rem = ((c1.data) * (a) + rem) / 10;
                } else {
                    b = ((c1.data) * (a) + rem + prev.next.data) % 10;
                    rem = ((c1.data) * (a) + rem + prev.next.data) / 10;
                    prev.next.data = (b);
                }
                prev = prev.next;
                c1 = c1.next;
            }
            if (rem != 0)
                prev.next = new Node(rem);
            prev = temp.next;
            c2 = c2.next;

        }
        return reverseList(dummy.next);
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        Node forw = head.next;
        Node prev = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

}
