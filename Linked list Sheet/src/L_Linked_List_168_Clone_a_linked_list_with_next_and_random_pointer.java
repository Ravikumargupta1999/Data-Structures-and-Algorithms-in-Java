import java.util.HashMap;

public class L_Linked_List_168_Clone_a_linked_list_with_next_and_random_pointer {
    class Node {
        int data;
        Node next;
        Node arb;

        public Node(int val) {
            this.data = val;
            this.next = null;
            this.arb = null;
        }
    }

    //https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
    // https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1#
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(-1);
        Node prev = newNode;
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.data);
            prev.next = temp;
            map.put(curr, temp);
            prev = prev.next;
            curr = curr.next;
        }

        newNode = newNode.next;
        Node c1 = head;
        Node c2 = newNode;
        while (c1 != null) {
            c2.arb = c1.arb != null ? map.get(c1.arb) : null;
            c1 = c1.next;
            c2 = c2.next;
        }
        return newNode;
    }

    // Without Exraa Space
    public Node copyRandomList1(Node head) {
        copyList(head);
        copyRandomPointers(head);
        return extraDeepCopy(head);
    }

    void copyList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node forw = curr.next;
            Node temp = new Node(curr.data);
            curr.next = temp;
            curr = forw;
        }
    }
    void copyRandomPointers(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            Node random = curr.arb;
            if(random != null)
            {
                curr.next.arb = random.next;
            }
            curr = curr.next.next;
        }
    }
    Node extraDeepCopy(Node head)
    {
        Node dummy = new Node(-1);
        Node prev = dummy;
        Node curr = head;
        while (curr != null)
        {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
