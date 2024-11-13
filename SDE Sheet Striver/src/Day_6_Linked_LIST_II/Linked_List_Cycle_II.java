package Day_6_Linked_LIST_II;

public class Linked_List_Cycle_II {
    public static class ListNode {
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
    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)
        {
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow != fast)
            return null;
        slow = head;
        fast = fast;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
