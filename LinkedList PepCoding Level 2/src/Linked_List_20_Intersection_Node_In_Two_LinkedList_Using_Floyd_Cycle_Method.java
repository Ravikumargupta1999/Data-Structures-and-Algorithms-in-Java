public class Linked_List_20_Intersection_Node_In_Two_LinkedList_Using_Floyd_Cycle_Method {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
    // Using Extra Space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headA.next == null || headB == null || headB.next == null)
            return null;
        ListNode temp = headA;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headB;
        return detectCycle(headA);
    }

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
