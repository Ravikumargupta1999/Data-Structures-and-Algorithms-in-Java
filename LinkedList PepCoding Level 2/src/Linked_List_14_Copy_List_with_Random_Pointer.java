import java.util.HashMap;

public class Linked_List_14_Copy_List_with_Random_Pointer {
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

    // https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
    // https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = new Node(-1);
        Node prev = newNode;
        Node curr = head;
        while (curr != null) {
            Node temp = new Node(curr.val);
            prev.next = temp;
            map.put(curr, temp);
            prev = prev.next;
            curr = curr.next;
        }

        newNode = newNode.next;

        Node c1 = head;
        Node c2 = newNode;
        while (c1 != null) {
            c2.random = c1.random != null ? map.get(c1.random) : null;
            c1 = c1.next;
            c2 = c2.next;
        }
        return newNode;
    }
}
