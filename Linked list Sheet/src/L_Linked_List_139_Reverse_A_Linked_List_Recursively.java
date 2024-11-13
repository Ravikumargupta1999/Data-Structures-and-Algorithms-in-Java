import java.util.Stack;

public class L_Linked_List_139_Reverse_A_Linked_List_Recursively {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/
    // Using stack
    static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (stack.size() > 0) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null; // most important step
        return dummy.next;
    }


}
