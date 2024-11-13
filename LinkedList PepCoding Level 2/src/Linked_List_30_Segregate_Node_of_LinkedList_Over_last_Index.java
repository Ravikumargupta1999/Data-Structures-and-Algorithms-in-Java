public class Linked_List_30_Segregate_Node_of_LinkedList_Over_last_Index {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;

        }
    }

    static Node segregate(Node head) {
        if (head == null || head.next == null)
            return head;
        Node tail = getTail(head);
        Node smaller = new Node(-1);
        Node pr = smaller;
        Node larger = new Node(-1);
        Node pl = larger;
        Node curr = head;
        while (curr != null) {
            if (curr.data <= tail.data) {
                pr.next = curr;
                pr = pr.next;
            } else {
                pl.next = curr;
                pl = pl.next;
            }
            curr = curr.next;
        }
        pr.next = larger.next;
        pl.next = null;

        // return pivot node
        return pr;
    }

    static Node getTail(Node head) {
        if (head == null || head.next == null)
            return head;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.print("\n");
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
        printList(segregate(head));
    }
}
