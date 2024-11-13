import java.util.Stack;

public class Modify_Linked_List_1 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node modify(Node head) {
        Stack<Node> s = new Stack<>();
        Node ptr = head;
        while (ptr != null) {
            s.add(ptr);
            ptr = ptr.next;
        }
        ptr = head;
        int n = s.size();
        for (int i = 0; i < n / 2; i++) {
            Node t = s.pop();
            ptr.data = ptr.data - t.data;
            ptr = ptr.next;
        }

        return head;
    }
}
