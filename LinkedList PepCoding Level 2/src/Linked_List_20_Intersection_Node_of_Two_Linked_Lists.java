import java.util.HashSet;

public class Linked_List_20_Intersection_Node_of_Two_Linked_Lists {
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
        HashSet<ListNode> set = new HashSet<>();
        if (headA == null || headB == null)
            return null;
        set.add(headA);
        headA = headA.next;
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
    // https://www.youtube.com/watch?v=G3-DhRFnUEA&list=PL-Jc9J83PIiGRqcfZxxgOKovgLVd3znnq&index=20
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode tail = headA;
        while (tail.next != null)
            tail = tail.next;
        tail.next = headB;  // modified
        ListNode ans = deetctCycleNode(headA);
        tail.next = null; // unmodified;
        return ans;
    }

    public static ListNode deetctCycleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return null;
        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
