public class L_Linked_List_153_Middle_Node_Of_Linked_List {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //
    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null)
            return slow;
        return slow.next;

    }
    class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    int getMiddle(Node head)
    {

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next == null)
            return slow.data;
        return slow.next.data;

    }
}
