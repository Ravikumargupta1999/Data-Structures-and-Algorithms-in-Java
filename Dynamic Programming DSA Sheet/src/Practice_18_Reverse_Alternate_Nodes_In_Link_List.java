public class Practice_18_Reverse_Alternate_Nodes_In_Link_List {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(4);
        head.next.next = new Node(9);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        rearrange(head);
        print(head);
    }

    public static void rearrange(Node head) {
        if (head == null || head.next == null)
            return;

        Node temp = head.next.next;


        Node dummy1 = head;
        Node dummy2 = head.next;

        Node temp1 = dummy1;
        Node temp2 = dummy2;


        while (temp != null && temp.next != null) {
            Node first = temp;
            Node second = temp.next;

            temp1.next = first;
            temp2.next = second;


            temp1 = temp1.next;
            temp2 = temp2.next;


            temp = temp.next.next;

        }
        if (temp != null) {
            temp1.next = temp;
            temp1 = temp1.next;
        }
        temp1.next = null;
        temp2.next = null;
        temp1.next = reverse(dummy2);
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void print(Node h) {
        while (h != null) {
            System.out.print(h.data + "   ");
            h = h.next;
        }
        System.out.println("\n");
    }
}
