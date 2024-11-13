package CodeChef;

public class Find_the_Middle {
    class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static int getMiddleElement(Node head) {
        if(head == null)
            return -1;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow.val : slow.next.val;
    }
}
