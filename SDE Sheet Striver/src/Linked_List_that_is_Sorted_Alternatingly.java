public class Linked_List_that_is_Sorted_Alternatingly {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node merge(Node head1, Node head2) {
        Node newHead = new Node(-1);
        Node p = head1, q = head2, r = newHead;
        while (p != null && q != null) {
            if (p.data <= q.data) {
                r.next = p;
                r = r.next;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return newHead.next;
    }

    public Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }

    public Node sort(Node head) {
        Node newHead = new Node(-1);
        Node curr = head, t2 = newHead;
        while (curr != null) {
            Node t = curr.next;
            if (t == null) curr.next = null;
            else curr.next = t.next;
            t2.next = t;
            t2 = t2.next;
            curr = curr.next;
        }
        //t2.next=null;
        newHead = reverse(newHead.next);
        head = merge(head, newHead);
        return head;
    }
}
