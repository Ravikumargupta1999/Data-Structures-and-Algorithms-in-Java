package Day_6_Linked_LIST_II;

import java.util.HashSet;

public class Intersection_of_Two_Linked_Lists {
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

    // Method 1
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
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

    // Method 2
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);

        int diff = l1 > l2 ? l1 - l2 : l2 - l1;

        ListNode d1 = headA;
        ListNode d2 = headB;

        if (l1 > l2) {
            while (diff-- > 0) {
                d1 = d1.next;
            }
        } else {
            while (diff-- > 0) {
                d2 = d2.next;
            }
        }

        while (d1 != null && d2 != null) {
            if (d1 == d2) {
                return d1;
            }
            d1 = d1.next;
            d2 = d2.next;
        }
        return null;

    }

    public int length(ListNode node) {
        int count = 0;

        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    // Method 3
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        if( headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    // Method 4 : USing cycle Detection
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode temp = headA;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = headB;
        ListNode ans = detectCycle(headA);
        temp.next = null;
        return ans;
    }
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
