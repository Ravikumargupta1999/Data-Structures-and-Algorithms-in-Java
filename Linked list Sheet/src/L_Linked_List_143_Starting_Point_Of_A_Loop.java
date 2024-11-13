public class L_Linked_List_143_Starting_Point_Of_A_Loop {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // https://leetcode.com/problems/linked-list-cycle-ii/submissions/
    // https://www.youtube.com/watch?v=jcZtMh_jov0
    public ListNode detectCycle(ListNode head) {
        ListNode meet = checkCycle(head);
        if (meet == null)
            return null;
        ListNode start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;

    }


    public ListNode checkCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return fast;
        }
        return null;
    }
}
