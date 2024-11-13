public class Linked_List_15_Copy_List_with_Random_Pointer_Without_Extra_Space {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
    public Node copyRandomList(Node head) {
        copyList1(head);
        copyRandomPointers(head);
        return extraDeepCopy(head);
    }

    void copyList1(Node head) {
        Node curr = head;
        while (curr != null) {
            Node forward = curr.next;

            Node temp = new Node(curr.val);
            curr.next = temp;
            temp.next = forward;

            curr = forward;
        }
    }

    void copyRandomPointers(Node head) {
        Node curr = head;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) {
                curr.next.random = random.next;
            }
            curr = curr.next.next;
        }
    }

    Node extraDeepCopy(Node head) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = head;
        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
