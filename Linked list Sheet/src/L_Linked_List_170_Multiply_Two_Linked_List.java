public class L_Linked_List_170_Multiply_Two_Linked_List {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public long multiplyTwoLists(Node head1, Node head2) {
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


    // https://www.codingninjas.com/codestudio/problems/multiply-linked-lists_983603?leftPanelTab=1
    public static Node multiplyLL(Node head1, Node head2) {
        Node node1 = reverse(head1);
        Node node2 = reverse(head2);


        Node dummy = new Node(-1);

        Node temp = dummy;

        while (node2 != null) {


            Node temp1 = node1;

            Node curr = temp;

            int carry = 0;

            while (temp1 != null) {

                int n2 = node2.data;
                int n1 = temp1.data;


                if (curr.next == null)
                    curr.next = new Node(0);

                int num = n1 * n2 + curr.next.data + carry;

                curr.next.data = num % 10;

                carry = num / 10;

                curr = curr.next;

                temp1 = temp1.next;

            }
            if (carry != 0) {
                if (curr.next == null)
                    curr.next = new Node(carry);
            }

            node2 = node2.next;
            temp  = temp.next;

        }
        Node newNode = reverse(dummy.next);
        while (newNode != null && newNode.data == 0)
            newNode = newNode.next;
        return newNode == null ? new Node(0) : newNode;
    }

    public static Node reverse(Node node) {
        if (node == null)
            return null;

        Node curr = node;

        Node prev = null;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}