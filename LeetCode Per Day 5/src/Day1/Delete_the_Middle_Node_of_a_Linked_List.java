package Day1;

public class Delete_the_Middle_Node_of_a_Linked_List {
    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/
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

    public ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return null;
        else if (head.next.next == null) {
            head.next = null;
            return head;
        }
       return deleteMiddleNode(head);
    }

    public ListNode deleteMiddleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            prev.next = slow.next;
        } else {
            slow.next = slow.next.next;
        }
        return node;
    }
}
