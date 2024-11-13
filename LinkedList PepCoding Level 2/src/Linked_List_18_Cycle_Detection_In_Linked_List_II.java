public class Linked_List_18_Cycle_Detection_In_Linked_List_II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/submissions/
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return null;
        slow = head;
        fast = fast;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
