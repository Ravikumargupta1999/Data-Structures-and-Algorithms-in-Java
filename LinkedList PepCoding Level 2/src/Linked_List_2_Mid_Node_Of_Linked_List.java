public class Linked_List_2_Mid_Node_Of_Linked_List {
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

        // look at this  case full
        //   1      2       4       5        6       7
        //
        if (fast.next == null)
            return slow;
        return slow.next;

    }

    // Middle Node
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/

    int getMiddle(Node head) {
        if (head == null)
            return -1;
        if (head.next == null)
            return head.data;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // look at this  case full
        //   1      2       4       5        6       7
        //
        if (fast.next == null)
            return slow.data;
        return slow.next.data;

    }
}
