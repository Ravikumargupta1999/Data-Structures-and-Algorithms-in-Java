public class Linked_List_11_Segregate_even_and_odd_nodes_in_a_Link_List {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

    }

    // https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1#
    static Node divide(int N, Node head) {
        if (head == null || head.next == null)
            return head;
        Node Odd = new Node(-1);
        Node Even = new Node(-1);
        Node odd = Odd;
        Node even = Even;
        while (head != null) {
            if (head.data % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }
        even.next = Odd.next;
        odd.next = null;
        return Even.next;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(11);
        head.next.next = new Node(31);
        head.next.next.next = new Node(91);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next.next.next = new Node(9);
        printList(head);
        printList(divide(1, head));
    }
}
